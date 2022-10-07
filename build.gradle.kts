plugins {
    id("java")
    signing
    `maven-publish`
}

group = "me.thealgorithm476"
version = "1.0.1"

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
}

dependencies {}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "me.thealgorithm476"
            artifactId = "parseua"
            version = project.version as String?

            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "octanrepo"
            url = uri("https://maven.octandevelopment.com/releases")
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
}

signing {
    sign(publishing.publications["maven"])
}