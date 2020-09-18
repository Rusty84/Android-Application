package com.testing.app.Tests

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.testing.app.R
import com.testing.app.Util.UiTest
import com.testing.app.Util.click
import com.testing.app.Util.isDisplayed
import com.testing.app.Util.waitForDisplay
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


