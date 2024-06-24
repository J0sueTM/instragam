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
    implementation("org.jooq:jooq:3.16.4")
    implementation("org.jooq:jooq-meta:3.16.4")
    implementation("org.jooq:jooq-codegen:3.16.4")
    implementation("org.jooq:jooq-meta-extensions:3.16.4")
    implementation("com.sparkjava:spark-core:2.9.4")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("at.favre.lib:bcrypt:0.10.2")
    implementation("com.github.slugify:slugify:3.0.7")
    implementation("jakarta.validation:jakarta.validation-api:3.1.0")
    // implementation("jakarta.el:jakarta.el-api:6.0.0")
    implementation("org.glassfish:jakarta.el:4.0.2")
    implementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")
    implementation("io.jsonwebtoken:jjwt-api:0.12.6")
    implementation("io.jsonwebtoken:jjwt-gson:0.12.6")

    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")

    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
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
