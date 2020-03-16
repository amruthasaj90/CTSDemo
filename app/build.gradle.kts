import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = "com.cts.demo"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 41
        versionName = "1.4.1"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        (kotlinOptions as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions).apply {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }

        javaCompileOptions {
            annotationProcessorOptions {
                includeCompileClasspath = true
            }
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }

    dataBinding.isEnabled = true
    androidExtensions.isExperimental = true
}

dependencies {
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.fragmentKtx)
    implementation(Libraries.lifecycleExtensions)
    implementation(Libraries.lifecycleLivedata)
    implementation(Libraries.lifecycleViewmodel)
    implementation(Libraries.navigationFragment)
    implementation(Libraries.navigationUiKtx)
    implementation(Libraries.recyclerView)
    implementation(Libraries.cardView)
    implementation(Libraries.material)
    implementation(Libraries.coroutinesAndroid)
    implementation(Libraries.coroutinesCore)

    // network
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitConverter)
    implementation(Libraries.retrofitMoshiConverter)
    implementation(Libraries.retrofitAdapter)
    implementation(Libraries.loggingInterceptor)

    //test
    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)

    //image compressor
    implementation(Libraries.glide)
    kapt(Libraries.glideKapt)

    //Kotlin live data
    implementation(Libraries.kotlinLivedata)

}
