plugins {
    id("java")
    id 'org.hidetake.swagger.generator' version '2.19.2'
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.38.0")
    testImplementation("com.squareup.okhttp3:okhttp:5.3.0")
    testImplementation("com.squareup.okhttp3:okhttp-urlconnection:5.3.0")
    testImplementation ("org.eclipse.angus:angus-mail:2.0.4")
    swaggerCodegen 'io.swagger:swagger-codegen-cli:2.4.34'

}


tasks.test {
    useJUnitPlatform()
}

swaggerSources {
    mantis {
        inputFile = file('swagger.json')
        code {
            language = 'java'
        }
    }
}