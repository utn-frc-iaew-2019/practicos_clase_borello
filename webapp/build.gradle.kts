plugins {
    java
    application
}

group = "iaew"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
    implementation("com.sparkjava:spark-core:2.8.0")
    implementation("com.h2database","h2","1.4.199")
    implementation("org.sql2o:sql2o:1.6.0")
    implementation("com.google.code.gson:gson:2.8.5")
}

application {
    mainClassName = "webapp.Main"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}