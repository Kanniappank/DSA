plugins {
    id("java")
}

group = "org.com.split-wise"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
    testCompileOnly("org.projectlombok:lombok:1.18.34")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.34")

    // SLF4J logging
    implementation("org.slf4j:slf4j-api:2.0.13")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.13")  // <-- use runtimeOnly instead of implementation
    testRuntimeOnly("org.slf4j:slf4j-simple:2.0.13") // <-- ensure available in tests

    // JUnit
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}


tasks.test {
    useJUnitPlatform()
}