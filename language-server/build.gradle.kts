plugins {
    kotlin("jvm")
    application
}

group = "dev.toliner"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.12.0")
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("MainKt")
}