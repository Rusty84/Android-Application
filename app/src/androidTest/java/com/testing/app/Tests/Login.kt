package com.testing.app.Tests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.testing.app.LoginActivity
import com.testing.app.R
import com.testing.app.Util.UiTest
import com.testing.app.Util.click
import com.testing.app.Util.isDisplayed
import com.testing.app.Util.waitForDisplay
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest

class Login : UiTest() {

    @get:Rule
    var mActivityRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun testNoDetails() {
        R.id.login_button.isDisplayed().click()
    }

    @Test
    fun testUsernameOnly() {
        onView(withId(R.id.username_field)).perform(typeText("User"), closeSoftKeyboard())
        R.id.login_button.isDisplayed().click()

    }

    @Test
    fun testPasswordOnly() {
        onView(withId(R.id.password_field)).perform(typeText("User"), closeSoftKeyboard())
        R.id.login_button.isDisplayed().click()
    }

    @Test
    fun testLogin() {
        R.id.username_field.isDisplayed()
        R.id.password_field.isDisplayed()
        onView(withId(R.id.username_field)).perform(typeText("User"), closeSoftKeyboard())
        onView(withId(R.id.password_field)).perform(typeText("Password"), closeSoftKeyboard())
        R.id.login_button.isDisplayed().click()
        R.id.navigation_home.isDisplayed()

    }

    private fun text(screenText: String) {
        screenText.waitForDisplay().isDisplayed()
    }

}