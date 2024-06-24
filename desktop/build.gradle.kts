plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation(libs.guava)
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("jakarta.validation:jakarta.validation-api:3.1.0")
    implementation("org.glassfish:jakarta.el:4.0.2")
    implementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")

    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "com.j0suetm.instragam.desktop.Main"
}

javafx {
       version = "23-ea+22"
       modules("javafx.base", "javafx.graphics", "javafx.controls", "javafx.fxml")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
