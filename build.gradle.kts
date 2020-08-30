plugins {
    java
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots");
    maven("https://oss.sonatype.org/content/repositories/snapshots");
}

configurations {
    create("export");
    implementation.get().extendsFrom(getByName("export"))
}

dependencies {

    implementation("org.spigotmc:spigot-api:1.12.2-R0.1-SNAPSHOT")

    "export"("org.javassist:javassist:3.26.0-GA");

    testCompileOnly("junit", "junit", "4.12")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.shadowJar {
    this.configurations.clear();
    this.configurations.add(project.configurations.getByName("export"));

//    relocate("javassist", "net/otlg/scrap/shadow/javassist")

    this.dependsOn(tasks.build);
}