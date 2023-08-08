val moduleName = "generator-core"

dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation(project(":backends:backend-teavm"))

    implementation("com.github.xpenatan.gdx-imgui:core:${LibExt.gdxImGuiVersion}")
    implementation("com.github.xpenatan.gdx-imgui:gdx:${LibExt.gdxImGuiVersion}")
    implementation("com.github.xpenatan.gdx-imgui:core-desktop:${LibExt.gdxImGuiVersion}")

    implementation(project(":extensions:gdx-freetype-teavm"))
    implementation(project(":extensions:gdx-box2d:gdx-box2d-teavm"))

    implementation("org.eclipse.jetty:jetty-server:${LibExt.jettyVersion}")
    implementation("org.eclipse.jetty:jetty-webapp:${LibExt.jettyVersion}")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = moduleName
            from(components["java"])
        }
    }
}
