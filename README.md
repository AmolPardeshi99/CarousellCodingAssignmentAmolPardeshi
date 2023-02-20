# :newspaper: Carousell News App 🤩🔥

Carousell News is Android App for showing News. The objective of the repository is to demonstrate the:

* MVVM Android App architecture 
* Filter the news Logic according to ranking and upload date
* UI Implementation using Material Components
* Coroutines and Livedata
* Standard Coding practices  
* Dependency using Dagger-2
* Unit Testing


# Links for Demo

https://drive.google.com/file/d/1IZtEPthLrcoO90j_lOyw5qYLkg0gHdyI/view?usp=share_link



# Things used while making this application

* Recycler View
* Retrofit Library
* MVVM
* Room DataBase
* Coroutines
* Dagger2
* Unit test using J-Unit4
* [News API]("https://storage.googleapis.com/carousell-interview-assets/android/carousell_news.json")

# Tech Stack ✨

* [Android Studio](https://developer.android.com/studio)
* [Kotlin](https://kotlinlang.org/)

# Architecture

This app uses [MVVM (Model View View-Model)](https://developer.android.com/jetpack/guide#recommended-app-arch) architecture.

<img src="https://camo.githubusercontent.com/be9b0e8eb62e13a031031fb16e99f33c647da47908a21f451cb00d2c99fb9b31/68747470733a2f2f646576656c6f7065722e616e64726f69642e636f6d2f746f7069632f6c69627261726965732f6172636869746563747572652f696d616765732f66696e616c2d6172636869746563747572652e706e67">



# Let's See
 
 <img src="https://github.com/AmolPardeshi99/CarousellCodingAssignmentAmolPardeshi/blob/master/Assets/carousell_news_app_demo.gif" width="300" height="750">
 
 ## Home Page
 
<img src="https://github.com/AmolPardeshi99/CarousellCodingAssignmentAmolPardeshi/blob/master/Assets/news_home_page.png" width="300" height="750">
 
 ## Menu - Sorting Options
 
<img src="https://github.com/AmolPardeshi99/CarousellCodingAssignmentAmolPardeshi/blob/master/Assets/menu_options.png" width="300" height="750">
 
 ## Sorted According to Recents
 
<img src="https://github.com/AmolPardeshi99/CarousellCodingAssignmentAmolPardeshi/blob/master/Assets/news_sorted_recent.png" width="300" height="750">


 
 
 # Clone this Repo To Your System Using Android Studio✨

* Step 1: Open your Android Studio then go to the File > New > Project from Version Control as shown in the below image.
* Step 2: After clicking on the Project from Version Control a pop-up screen will arise like below. In the Version control choose Git from the drop-down menu.
* Step 3: Then at last paste the link in the URL and choose your Directory. Click on the Clone button and you are done.

# Clone this Repo To Your System Using GitBash✨

* Open Git Bash

* If Git is not already installed, it is super simple. Just go to the Git Download Folder and follow the instructions.

* Go to the current directory where you want the cloned directory to be added.

* To do this, input cd and add your folder location. You can add the folder location by dragging the folder to Git bash.

* Go to the page of the repository that you want to clone

* Click on “Clone or download” and copy the URL.

* Use the git clone command along with the copied URL from earlier. $ git clone https://github.com/AmolPardeshi99/CarousellCodingAssignmentAmolPardeshi.git

* Press Enter. $ git clone https://github.com/AmolPardeshi99/CarousellCodingAssignmentAmolPardeshi.git

Congratulations, you have created your local clone from your remote Github repository.

Open Android Studio. Go to File > New > Project From Version Control. Copy the link of this repositary. Paste the link in Url Box of Android Studio window and click on "Clone" button.




# Dependencies 

    dependencies {
    
    implementation 'androidx.core:core-ktx:1.9.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.8.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    testImplementation 'androidx.test.ext:truth:1.5.0'
    testImplementation 'org.mockito:mockito-core:3.10.0'
    androidTestImplementation 'org.mockito:mockito-android:3.10.0'
    testImplementation 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0'


    implementation 'androidx.arch.core:core-common:2.2.0-alpha01'
    implementation 'androidx.arch.core:core-runtime:2.2.0-alpha01'
    implementation 'androidx.arch.core:core-testing:2.2.0-alpha01'

    def dagger_version = "2.44.2"
    implementation "com.google.dagger:dagger:$dagger_version"
    kapt "com.google.dagger:dagger-compiler:$dagger_version"
    implementation "com.google.dagger:dagger-android:$dagger_version"
    implementation "com.google.dagger:dagger-android-support:$dagger_version"
    kapt "com.google.dagger:dagger-android-processor:$dagger_version"

    def retrofit_version = "2.9.0"
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"

    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"

    def coroutines_version = "1.6.4"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"

    // glide
    implementation 'com.github.bumptech.glide:glide:4.8.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.8.0'
   
}

    


Hard work beats the talent, when talent doesn't do the hardwork.
I am new person in open source of Android Development, so please feel free to correct and make changes. #LookingForward 
