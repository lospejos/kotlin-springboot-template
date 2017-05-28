import org.springframework.boot.gradle.repackage.RepackageTask

buildscript {
    val springBootVersion = "1.5.3.RELEASE"
    val kotlinVersion = "1.1.2-4"
    extra["springBootVersion"] = springBootVersion
    extra["kotlinVersion"] = kotlinVersion

    repositories {
        gradleScriptKotlin()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

apply {
    plugin("kotlin")
    plugin("idea")
    plugin("org.springframework.boot")
}

version = "0.0.1-SNAPSHOT"

configure<JavaPluginConvention> {
    setSourceCompatibility(1.8)
    setTargetCompatibility(1.8)
}

(tasks.getByName("bootRepackage") as RepackageTask).apply {
    enabled = false
}


val kotlinVersion = extra["kotlinVersion"] as String
val springBootVersion = extra["springBootVersion"] as String

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}")
    compile(project(":kotlinboot-commons"))
    compile("org.glassfish.jersey.core:jersey-client:2.25")
    compile("org.glassfish.jersey.ext:jersey-proxy-client:2.25")
    compile("org.glassfish.jersey.media:jersey-media-json-jackson:2.25")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.8.4")

    testCompile(project(":kotlinboot-server"))
    testCompile("org.spockframework:spock-spring:1.0-groovy-2.4")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}
