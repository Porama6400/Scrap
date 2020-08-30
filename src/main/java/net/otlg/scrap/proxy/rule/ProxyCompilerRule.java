package net.otlg.scrap.proxy.rule;

import java.util.HashMap;
import java.util.Map;

public class ProxyCompilerRule {
    Map<String, ProxyPolicy> functionProxyRules = new HashMap<>();
    Map<String, ProxyPolicy> argumentProxyRules = new HashMap<>();

    public boolean isSandboxed() {
        return true;
    }

    public Map<String, ProxyPolicy> getFunctionProxyRules() {
        return functionProxyRules;
    }

    public Map<String, ProxyPolicy> getArgumentProxyRules() {
        return argumentProxyRules;
    }
}
