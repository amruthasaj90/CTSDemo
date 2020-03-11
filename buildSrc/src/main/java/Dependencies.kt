const val kotlinVersion = "1.3.61"

object BuildPlugins {
    object Versions {
        const val androidBuildToolsVersion = "3.5.1"

    }

    const val androidGradlePlugin =
        "com.android.tools.build:gradle:${Versions.androidBuildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"

    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"


}

object AndroidSdk {
    const val min = 23
    const val compile = 29
    const val target = compile
}

object Libraries {
    private object Versions {
        const val jetpack = "1.1.0"
        const val constraintLayout = "2.0.0-beta1"
        const val ktx = "1.1.0"
        const val fragmentVersion = "1.2.1"
        const val lifecycleVersion = "2.2.0-alpha01"
        const val navigationVersion = "2.0.0"
        const val recyclerViewVersion = "1.1.0-alpha05"
        const val cardViewVersion = "1.0.0"
        const val materialVersion = "material:1.0.0"
        const val coroutine = "1.0.0"
        const val retrofit = "2.3.0"
        const val okhttp = "3.11.0"
        const val imageLoader = "4.11.0"
        const val kotlinLifecycleLivedata = "2.1.0"

    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    //ktx
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"

    //lifecycle
    const val lifecycleExtensions =
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    const val lifecycleLivedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val lifecycleViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"

    //navigation
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUiKtx =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"

    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}"
    const val material = "com.google.android.material:${Versions.materialVersion}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardViewVersion}"

    //corountine
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"

    // network
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val retrofitAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"


    //Glide Image Loader
    val glide = "com.github.bumptech.glide:glide:${Versions.imageLoader}"
    val glideKapt = "com.github.bumptech.glide:compiler:${Versions.imageLoader}"

    //Kotlin Lifecycle Livedata
    const val kotlinLivedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.kotlinLifecycleLivedata}"

}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.2.0"
        const val espresso = "3.2.0"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}