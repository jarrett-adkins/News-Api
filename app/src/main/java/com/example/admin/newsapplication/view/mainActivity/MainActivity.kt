package com.example.admin.newsapplication.view.mainActivity

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.admin.newsapplication.R
import com.example.admin.newsapplication.model.Model
import com.example.admin.newsapplication.viewModel.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
// The Kotlin Android Extensions plugin allows us to import views in a layout as “synthetic” properties.

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val MY_PERMISSIONS_REQUEST_LOCATION = 99

    private var viewModel = ViewModel()

    private var articleList: ArrayList<Model.Article> = ArrayList()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: MyItemListAdapter
    private val recyclerView by lazy {
        rvRecyclerView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestLocationPermission()
    }

    private fun requestLocationPermission() {
        val permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission not granted")

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Permission to access the device's location is required for " +
                        "this application")
                        .setTitle("Permission required")

                builder.setPositiveButton("OK"
                ) { dialog, id ->
                    Log.i(TAG, "Clicked")
                    makeRequest()
                }

                val dialog = builder.create()
                dialog.show()
            } else {
                makeRequest()
            }
        } else {
            Log.i(TAG, "Permission granted")
            initRecyclerView()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                MY_PERMISSIONS_REQUEST_LOCATION)
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_LOCATION -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG, "Permission has been denied by user")
                } else {
                    Log.i(TAG, "Permission has been granted by user")
                    initRecyclerView()
                }
            }
        }
    }

    private fun initRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = MyItemListAdapter(articleList)
        recyclerView.adapter = adapter

        subscribe(viewModel.getHeadlines()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    result ->
                    Log.d("Result", "There are ${result.articles.size} results")

                    for( a in result.articles )
                        articleList.add(a)

                    adapter.notifyItemInserted(articleList.size)
                }, { error ->
                    error.printStackTrace()
                }))
    }

    val subscriptions = CompositeDisposable()

    fun subscribe(disposable: Disposable): Disposable {
        subscriptions.add(disposable)
        return disposable
    }
}

/*
There's basically 20 things. Ive done 9.

Create an Android News application using the following libraries:
X Retrofit
X RxKotlin/RxJava
- Dagger
X Kotlin
X Gson
- JaCoCo
- Junit (Unit Testing)
- Mockito (Unit Testing)
- Espresso (UI Testing)
- SQLite

[DONE] Architecture:  MVVM

Due date:  01/11/2018 2:00 PM EST

Requirements:
[DONE] The entire application should be written in Kotlin

[DONE] The application will allow a user fetch a list of news.

[DONE] Home screen:
The first time it loads the home screen it should ask the user for Location permission
(Runtime permission flow).

[DONE] Once the location is received, it would present a list of news and present them in a
RecyclerView as well, including relevant news information.

News Detail screen:
It should display the details on the news
and allow the user to store them in a local SQlite database.
The ActionBar
should have a favorite icon
that changes color if the news being shown is a saved news article.

Since we are senior developers and professional consultants, we value high quality in code, so make
sure your code is presentable before any commit is made, and provide at least one Unit Test per
Presenter and at least one UI Test with Espresso.

Your repository should contain the html directory holding the JaCoCo report with your code coverage.

Deliverable Product:

The GitHub link to the repository hosting this application and that clearly shows atomic commits
relevant to each story being implemented.

Communication expectations:
At the beginning and end of every day you should update your project's Skype group chat by filling
the below template.

Should you get stuck or have any doubts, request for clarification/assistance in the project chat
group as well, ideally if half an hour has gone by and you haven't made any progress.

Suggested API: https://newsapi.org/

For Kotlin you can take a look into the following resources:

https://blog.mindorks.com/a-complete-guide-to-learn-kotlin-for-android-development-b1e5d23cc2d8
https://www.raywenderlich.com/132381/kotlin-for-android-an-introduction
https://kotlinlang.org/docs/tutorials/kotlin-android.html

Codelab:
https://codelabs.developers.google.com/codelabs/build-your-first-android-app-kotlin/index.html?index
=..%2F..%2Findex#0

Book:
https://antonioleiva.com/kotlin-android-developers-book/

Please report your progress using this template:

Task:
Progress: 
Completion %:
Deadline:
Will Hit Deadline:
Issues: 
Pending Items:
Actions to be taken:
 */

/*
Show them this
https://segunfamisa.com/posts/using-retrofit-on-android-with-kotlin
and ask if the SearchRepository is a better practice.

Do I display the full article on the news detail screen? The api on returns a description and a link.
 */

/*
JaCoCo
Reporting code coverage. Making sure every line of code relevant to gusiness logic is tested.
Viewmodel is interacting with dif layers, make sure each interaction is tested. Can use JUnit, ect.
JaCoCo tracks the testing.
80%

MVVM
https://medium.com/@manuelvicnt/rxjava-android-mvvm-app-structure-with-retrofit-a5605fa32c00
Model to ViewModel, data comes from web and is mapped to pojo and sent to view model. With RxJava
you can subscribe the viewmodel to the data. Viewmodel can be observable, extend base observable. Will
bind and make the application react to a model change or view interaction.

 */