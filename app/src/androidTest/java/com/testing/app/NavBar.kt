package com.testing.app

import Util.UiTest
import Util.isDisplayed
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)

class NavBar : UiTest() {

    @Test
    fun testNavbar() {
        R.id.nav_host_fragment.isDisplayed()
    }

}

