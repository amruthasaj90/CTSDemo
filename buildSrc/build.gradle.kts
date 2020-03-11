plugins {
    `kotlin-dsl`
}

repositories {
    jcenter() // this is needed to download dependencies for kotlin-dsl
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
