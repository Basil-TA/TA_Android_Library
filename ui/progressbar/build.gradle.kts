plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.ta.ui.progressbar"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

// Place the version of your library here
val getVersionName: () -> String = {
    "0.0.1"
}

// Add the name of your library here
val getArtifactId: () -> String = {
    "progressbar"
}

// Add the group ID of your library here
val getGroupId: () -> String = {
    "com.ta.com"
}

// Prepare URL of maven package.
// Replace 'Basil-TA' with your github repo's username or organization name.
// Replace 'analytics-sdk-android' with the name of the github repo
val getGitHubUrl: () -> String = {
    "https://maven.pkg.github.com/Basil-TA/TA_Library"
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = groupId
            artifactId = artifactId
            version = getVersionName()

            afterEvaluate {
                from(components["release"])
            }
        }


    }


//    repositories {
//        maven {
//            name = "GitHubPackages"
//            url = uri(getGitHubUrl())
//            credentials {
//                username = System.getenv("GITHUB_USER_NAME")
//                password = System.getenv("GITHUB_TOKEN")
//            }
//        }
//    }
}
dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}