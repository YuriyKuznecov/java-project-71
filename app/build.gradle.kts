plugins {
    application
    id("java")
    id("io.freefair.lombok") version "8.7.1"
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {mainClass.set("hexlet.code.App")}

repositories {
    mavenCentral()
}

dependencies {
    implementation ("info.picocli:picocli:4.7.6")
    annotationProcessor ("info.picocli:picocli-codegen:4.7.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.0-rc1")
    implementation("commons-io:commons-io:2.16.1")
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jacocoTestReport {
    reports { xml.required.set(true) }
}