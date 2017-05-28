buildscript {
	val springBootVersion = "1.5.3.RELEASE"
	val kotlinVersion = "1.1.2-4"
	extra["kotlinVersion"] = kotlinVersion

	repositories {
		mavenCentral()
		gradleScriptKotlin()
	}

	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
	}
}

apply {
	plugin("kotlin")
	plugin("application")
	plugin("idea")
	plugin("org.springframework.boot")
}

version = "0.0.1-SNAPSHOT"

configure<JavaPluginConvention> {
	setSourceCompatibility(1.8)
	setTargetCompatibility(1.8)
}

repositories {
	mavenCentral()
}

val kotlinVersion = extra["kotlinVersion"] as String

dependencies {
	compile(project(":kotlinboot-commons"))
	compile("org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}")
	compile("org.springframework.boot:spring-boot-starter-web")
	compile("org.springframework.boot:spring-boot-starter-data-jpa")
	compile("org.springframework.boot:spring-boot-starter-jersey")
	compile("org.springframework.boot:spring-boot-starter-data-cassandra") // for now Cassandra 2.X.X
	//compile("org.springframework.boot:spring-boot-starter-data-redis")

    compile("org.springframework.hateoas:spring-hateoas:0.21.0.RELEASE")  // TODO: why not 'org.springframework.boot:spring-boot-starter-hateoas' ?
	compile("org.springframework.boot:spring-boot-starter-data-rest")
	compile("com.h2database:h2")
	compile("com.fasterxml.jackson.module:jackson-module-kotlin:2+") // 2.9.0.pr3
	testCompile("org.spockframework:spock-spring:1+")
	testCompile("org.springframework.boot:spring-boot-starter-test")
	testCompile("org.cassandraunit:cassandra-unit-spring:2+")
}

// if you get "input line is tool ong error, replace line "set CLASSPATH=..." to "set CLASSPATH=%APP_HOME%\lib\*" in bat file
// or fix startScripts: replace set CLASSPATH
//startScripts {
//	//classpath += files('src/dist/XxxAPlaceHolderForAConfigxxX')
//	// Properties in config folder will override properties packed into jar
//	//classpath = files('src/dist/XxxAPlaceHolderForAConfigxxX') + classpath
//	doLast {
//		def windowsScriptFile = file getWindowsScript()
//		def unixScriptFile    = file getUnixScript()
//		windowsScriptFile.text = windowsScriptFile.text.replace('%APP_HOME%\\lib\\XxxAPlaceHolderForAConfigxxX', '%APP_HOME%\\config')
//		unixScriptFile.text  = unixScriptFile.text.replace('$APP_HOME/lib/XxxAPlaceHolderForAConfigxxX', '$APP_HOME/config')
//	}
//}

