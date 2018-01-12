package com.example.admin.newsapplication

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.admin.newsapplication.view.newsDetailsActivity.NewsDetailActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class NewsDetailActivityTest {

    @Rule @JvmField
    var rule = ActivityTestRule(NewsDetailActivity::class.java)
//    var rule = ActivityTestRule<NewsDetailActivity>(NewsDetailActivity::class.java)

//    val checkThat: Matchers = Matchers()

    @Test
    fun shouldChangeActionBarIconOnClick() {
        onView(withId(R.id.mFavorite)).perform(click())
    }
}

//class Matchers {
//// A wrapper around Espresso checks
//    fun viewIsVisibleAndContainsText(@StringRes stringResource: Int) {
//        onView(withText(stringResource)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
//    }
//}