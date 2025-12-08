
plugins {
    // root-level plugins if needed
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
