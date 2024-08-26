plugins {
    `java-library`
    id("software.amazon.smithy.gradle.smithy-jar")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/JordonPhillips/smithy-test-package")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    val smithyVersion: String by project

    smithyCli("software.amazon.smithy:smithy-cli:$smithyVersion")
    implementation("me.jkphillips:smithy-test-package:1.0")

    // Uncomment below to add various smithy dependencies (see full list of smithy dependencies in https://github.com/awslabs/smithy)
    // implementation("software.amazon.smithy:smithy-model:$smithyVersion")
    // implementation("software.amazon.smithy:smithy-linters:$smithyVersion")
}
