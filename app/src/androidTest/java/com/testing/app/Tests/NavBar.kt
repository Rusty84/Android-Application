package com.testing.app.Tests

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.testing.app.MainActivity
import com.testing.app.R
import com.testing.app.Util.UiTest
import com.testing.app.Util.click
import com.testing.app.Util.isDisplayed
import com.testing.app.Util.waitForDisplay
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)


class NavBar : UiTest() {

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testNavbarDisplay() {
        R.id.nav_host_fragment.isDisplayed()
    }

    @Test
    fun testScreenText() {
        text("This is the home screen")
    }

    @Test
    fun testNavButtons() {
        R.id.navigation_notifications.click()
        text("This is the notifications screen")
        R.id.navigation_home.click()
        text("This is the home screen")
    }

    private fun text(screenText: String) {
        screenText.waitForDisplay().isDisplayed()
    }

}


