package net.otlg.scrap.proxy;

import javassist.*;
import javassist.bytecode.AccessFlag;
import net.otlg.scrap.Scrap;
import net.otlg.scrap.logger.ScrapVolatileLogger;
import net.otlg.scrap.proxy.rule.DefaultProxyCompilerRule;
import net.otlg.scrap.proxy.rule.ProxyCompilerRule;
import net.otlg.scrap.proxy.rule.ProxyPolicy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ProxyCompiler {

    private static ScrapVolatileLogger logger = ScrapVolatileLogger.CONSOLE;
    private static ScrapVolatileLogger apiLogger = ScrapVolatileLogger.NOP;

    private static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    private static Map<String, Class> classMap = new HashMap<>();
    private static Map<String, Constructor> constructorMap = new HashMap<>();
    private static Map<String, Field> originalFieldMap = new HashMap<>();
    private static ProxyCompilerRule rule = new DefaultProxyCompilerRule();

    public static Class<?> compile(Class originalClass) throws CannotCompileException, NotFoundException, NoSuchMethodException, ClassNotFoundException {
        if (classMap.containsKey(originalClass.getName())) {
            return classMap.get(originalClass.getName());
        }

        ClassPool classPool = ClassPool.getDefault();
        classPool.appendClassPath(new LoaderClassPath(Scrap.class.getClassLoader()));
        classPool.appendClassPath(new LoaderClassPath(originalClass.getClassLoader()));

        CtClass objectClass = classPool.get(Object.class.getName());
        CtClass stringClass = classPool.get(String.class.getName());
        CtClass originalCtClass = classPool.get(originalClass.getName());
        CtClass proxyClass = classPool.makeClass("net.otlg.scrap.generated.ProxyClass" + originalClass.getSimpleName());

        logger.logln("Compiling " + proxyClass.getName());
        apiLogger.logln(">> " + proxyClass.getName());
        System.out.println("Compiling wrapper for " + originalClass.getName());

        CtField fieldOriginal = new CtField(classPool.get(originalClass.getName()), "original", proxyClass);
        proxyClass.addField(fieldOriginal);

        CtConstructor constructor = CtNewConstructor.make(new CtClass[]{originalCtClass}, new CtClass[]{}, proxyClass);
        constructor.setBody("{original = $1;}");
        proxyClass.addConstructor(constructor);

        CtMethod toOriginalString = CtNewMethod.make(stringClass, "toOriginalString", null, new CtClass[]{}, "{ return original.toString(); }", proxyClass);
        proxyClass.addMethod(toOriginalString);

        outerFor:
        for (CtMethod method : originalCtClass.getMethods()) {
            String fullName = method.getName() + ":" + method.getReturnType().getName();
            if ((method.getModifiers() & (AccessFlag.PUBLIC)) == 0) {
                continue;
            }

            for (CtMethod objectMethod : objectClass.getMethods()) {
                if (method.getName().equals(objectMethod.getName())) continue outerFor;
            }

            String[] proxyClasses = new String[method.getParameterTypes().length];

            for (int i = 0; i < method.getParameterTypes().length; i++) {
                CtClass type = method.getParameterTypes()[i];
                String name = type.getName();
                ProxyPolicy action = rule.getArgumentProxyRules().get(name);
                if (action == ProxyPolicy.ALLOW) continue;

                proxyClasses[i] = name;
                method.getParameterTypes()[i] = objectClass;
            }

            logger.logln(">> " + fullName);

            ProxyPolicy action = rule.getFunctionProxyRules().get(fullName);
            if (action == null) continue;

            CtClass returnType = method.getReturnType();

            boolean proxyOut = (action == ProxyPolicy.PROXY) ||
                    (rule.getArgumentProxyRules().get(returnType.getName()) == ProxyPolicy.PROXY);

            StringBuilder builder = new StringBuilder("{");
            builder.append(" return ");
            if (proxyOut) {
                builder.append("net.otlg.scrap.proxy.ProxyCompiler.construct(");
                returnType = objectClass;
            }
            builder.append("original");
            builder.append(".").append(method.getName()).append("(");

            for (int i = 0; i < proxyClasses.length; i++) {
                String originalClassType = proxyClasses[i];
                if (i > 0) builder.append(",");
                if (originalClassType == null) {
                    builder.append("$").append(i + 1);
                } else {
                    builder.append("((").append(originalClassType).append(")net.otlg.scrap.proxy.ProxyCompiler.revert(")
                            .append("$").append(i + 1)
                            .append("))");
                }
            }

            builder.append(")");
            if (proxyOut) builder.append(")");
            builder.append(";}");

            CtMethod newMethod = CtNewMethod.make(returnType, method.getName(), method.getParameterTypes(), method.getExceptionTypes(), null, proxyClass);

            newMethod.setModifiers(Modifier.PUBLIC);
            newMethod.setBody(builder.toString());

            proxyClass.addMethod(newMethod);

            logger.logln(action.name() + " - " + builder.toString());
            apiLogger.logln(newMethod.getName() + newMethod.getSignature());
        }

        Class<?> aClass = proxyClass.toClass(classLoader, originalClass.getProtectionDomain());
        classMap.put(originalClass.getName(), aClass);
        constructorMap.put(originalClass.getName(), aClass.getConstructor(originalClass));

        logger.logln("");
        logger.flush();
        apiLogger.logln("");
        apiLogger.flush();

        return aClass;
    }

    public static Object construct(Object original) {
        if (!rule.isSandboxed()) return original;
        try {
            compile(original.getClass());
            Constructor constructor = constructorMap.get(original.getClass().getName());
            return constructor.newInstance(original);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | CannotCompileException | NotFoundException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object revert(Object original) throws Exception {
        Class<?> originalClass = original.getClass();
        Field field = originalFieldMap.get(originalClass.getName());
        if (field == null) {
            field = originalClass.getField("original");
            originalFieldMap.put(originalClass.getName(), field);
        }

        return field.get(original);
    }

    public static ProxyCompilerRule getRule() {
        return rule;
    }

    public static void setRule(ProxyCompilerRule rule) {
        ProxyCompiler.rule = rule;
    }

    public static void setApiLogger(ScrapVolatileLogger apiLogger) {
        ProxyCompiler.apiLogger = apiLogger;
    }

    public static ScrapVolatileLogger getLogger() {
        return logger;
    }

    public static void setLogger(ScrapVolatileLogger logger) {
        ProxyCompiler.logger = logger;
    }

    public static ClassLoader getClassLoader() {
        return classLoader;
    }

    public static void setClassLoader(ClassLoader classLoader) {
        ProxyCompiler.classLoader = classLoader;
    }
}