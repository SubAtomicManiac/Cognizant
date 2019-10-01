package com.example.cognizantchallenge

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.cognizantchallenge.ui.HomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @get:Rule
    val rule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun activityStartsSuccessfully(){
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun activityStarts_recyclerView_displays(){
        ActivityScenario.launch(HomeActivity::class.java)

        onView(withId(R.id.rv_albums)).check(matches(isDisplayed()))
    }




}