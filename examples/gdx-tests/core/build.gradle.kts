plugins {
    id("java-library")
}

dependencies {
    implementation(project(":examples:core:core"))
    implementation(project(":examples:freetype:core"))

    // Required
    implementation("com.badlogicgames.gdx:gdx-platform:${LibExt.gdxVersion}:natives-desktop")
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:${LibExt.gdxVersion}")

    implementation("com.github.xpenatan.gdx-imgui:imgui-core:${LibExt.gdxImGuiVersion}")
    implementation("com.github.xpenatan.gdx-imgui:gdx-impl:${LibExt.gdxImGuiVersion}")

    // Optional
    implementation("com.github.xpenatan.gdx-multi-view:core:${LibExt.gdxMultiViewVersion}")

    api("com.badlogicgames.gdx:gdx-tests")

}