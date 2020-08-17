package com.testing.app.Tests

import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.testing.app.R
import com.testing.app.Util.*
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)

class NavBar : UiTest() {

    @Test
    fun testNavbarDisplay() {
        R.id.nav_host_fragment.isDisplayed()
    }

    @Test
    fun testScreenText() {
        Text("This is the home screen")
    }

    @Test
    fun testNavButtons() {
        R.id.navigation_notifications.click()
        Text("This is the notifications screen")
        R.id.navigation_home.click()
        Text("This is the home screen")
    }

    private fun Text(screenText: String) {
        screenText.waitForDisplay().isDisplayed()
    }

}


