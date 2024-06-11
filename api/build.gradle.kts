plugins {
    application
    id("org.flywaydb.flyway") version "10.0.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.cdimascio:dotenv-java:3.0.0")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation(libs.guava)
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("org.flywaydb:flyway-core:10.14.0")
    implementation("org.flywaydb:flyway-database-postgresql:10.1.0")
    implementation("com.zaxxer:HikariCP:5.1.0")

    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

buildscript {
  repositories {
    mavenCentral()
  }

  dependencies {
  }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "com.j0suetm.instragam.api.Main"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
