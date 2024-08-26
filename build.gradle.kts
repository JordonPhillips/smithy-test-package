plugins {
    `java-library`
    id("software.amazon.smithy.gradle.smithy-jar")
    `maven-publish`
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/JordonPhillips/smithy-test-package")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            groupId = "me.jkphillips"
            artifactId = "smithy-test-package"
            version = "1.0"
            from(components["java"])
        }
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    val smithyVersion: String by project

    smithyCli("software.amazon.smithy:smithy-cli:$smithyVersion")

    // Uncomment below to add various smithy dependencies (see full list of smithy dependencies in https://github.com/awslabs/smithy)
    // implementation("software.amazon.smithy:smithy-model:$smithyVersion")
    // implementation("software.amazon.smithy:smithy-linters:$smithyVersion")
}
