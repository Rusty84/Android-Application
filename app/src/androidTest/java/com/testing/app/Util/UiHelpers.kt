package com.testing.app.Util

import android.annotation.SuppressLint
import android.view.View
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.AllOf
import org.hamcrest.core.AnyOf
import java.util.*

fun ViewInteraction.match(matcher: Matcher<View>): ViewInteraction = this.check(ViewAssertions.matches(matcher))
fun ViewInteraction.isDisplayed(): ViewInteraction = this.match(ViewMatchers.isDisplayed())
fun ViewInteraction.isNotDisplayed(): ViewInteraction = this.match(CoreMatchers.not(ViewMatchers.isDisplayed()))
fun ViewInteraction.isDisplayingAtLeast(percent: Int): ViewInteraction = this.match(ViewMatchers.isDisplayingAtLeast(percent))
fun ViewInteraction.doesNotExist(): ViewInteraction = this.check(ViewAssertions.doesNotExist())
fun ViewInteraction.click(): ViewInteraction = this.perform(ViewActions.click())
fun ViewInteraction.waitFor(millis: Long): ViewInteraction = this.perform(
    waitForMillis(
        millis
    )
)
fun ViewInteraction.waitForDisplay(millis: Long = 10000): ViewInteraction {
    val startDate = Date()
    while (true) {
        try {
            return this.isDisplayed()
        } catch (throwable: Throwable) {
            val timePassed = Date().time - startDate.time
            if (timePassed > millis) {
                throw throwable
            }
        }
    }
}

fun Matcher<View>.match(matcher: Matcher<View>): ViewInteraction = Espresso.onView(this).match(matcher)
fun Matcher<View>.first(): ViewInteraction = Espresso.onView(
    withIndex(
        this,
        0
    )
)
fun Matcher<View>.withIndex(index: Int): ViewInteraction = Espresso.onView(
    withIndex(
        this,
        index
    )
)
fun Matcher<View>.isNotDisplayed(): ViewInteraction = Espresso.onView(this).isNotDisplayed()
fun Matcher<View>.isDisplayed(): ViewInteraction = Espresso.onView(this).isDisplayed()
fun Matcher<View>.isDisplayingAtLeast(percent: Int): ViewInteraction = Espresso.onView(this).isDisplayingAtLeast(percent)
fun Matcher<View>.doesNotExist(): ViewInteraction = Espresso.onView(this).doesNotExist()
fun Matcher<View>.click(): ViewInteraction = Espresso.onView(this).click()
fun Matcher<View>.waitFor(millis: Long): ViewInteraction = Espresso.onView(this).waitFor(millis)
fun Matcher<View>.waitForDisplay(millis: Long = 10000): ViewInteraction = Espresso.onView(this).waitForDisplay(millis)
fun Matcher<View>.isParent(): Matcher<View> = ViewMatchers.isDescendantOfA(this)

fun String.match(matcher: Matcher<View>): ViewInteraction = ViewMatchers.withText(this).match(matcher)
fun String.first(): ViewInteraction = ViewMatchers.withText(this).first()
fun String.withIndex(index: Int): ViewInteraction = ViewMatchers.withText(this).withIndex(index)
fun String.isNotDisplayed(): ViewInteraction = ViewMatchers.withText(this).isNotDisplayed()
fun String.isDisplayed(): ViewInteraction = ViewMatchers.withText(this).isDisplayed()
fun String.isDisplayingAtLeast(percent: Int): ViewInteraction = ViewMatchers.withText(this).isDisplayingAtLeast(percent)
fun String.doesNotExist(): ViewInteraction = ViewMatchers.withText(this).doesNotExist()
fun String.click(): ViewInteraction = ViewMatchers.withText(this).click()
fun String.waitFor(millis: Long): ViewInteraction = ViewMatchers.withText(this).waitFor(millis)
fun String.waitForDisplay(millis: Long = 10000): ViewInteraction = ViewMatchers.withText(this).waitForDisplay(millis)
fun String.isParent(): Matcher<View> = ViewMatchers.withText(this).isParent()

fun @receiver:IdRes Int.match(matcher: Matcher<View>): ViewInteraction = ViewMatchers.withId(this).match(matcher)
fun @receiver:IdRes Int.first(): ViewInteraction = ViewMatchers.withId(this).first()
fun @receiver:IdRes Int.withIndex(index: Int): ViewInteraction = ViewMatchers.withId(this).withIndex(index)
fun @receiver:IdRes Int.isNotDisplayed(): ViewInteraction = ViewMatchers.withId(this).isNotDisplayed()
fun @receiver:IdRes Int.isDisplayed(): ViewInteraction = ViewMatchers.withId(this).isDisplayed()
fun @receiver:IdRes Int.isDisplayingAtLeast(percent: Int): ViewInteraction = ViewMatchers.withId(this).isDisplayingAtLeast(percent)
fun @receiver:IdRes Int.doesNotExist(): ViewInteraction = ViewMatchers.withId(this).doesNotExist()
fun @receiver:IdRes Int.click(): ViewInteraction = ViewMatchers.withId(this).click()
fun @receiver:IdRes Int.waitFor(millis: Long): ViewInteraction = ViewMatchers.withId(this).waitFor(millis)
fun @receiver:IdRes Int.waitForDisplay(millis: Long = 10000): ViewInteraction = ViewMatchers.withId(
    this
).waitForDisplay(millis)
fun @receiver:IdRes Int.isParent(): Matcher<View> = ViewMatchers.withId(this).isParent()

fun all(vararg resIdOrTextOrMatcher: Any): Matcher<View> {
    return CoreMatchers.allOf(
        mapToMatchers(
            resIdOrTextOrMatcher.toList()
        )
    )
}

fun any(vararg resIdOrTextOrMatcher: Any): Matcher<View> {
    return CoreMatchers.anyOf(
        mapToMatchers(
            resIdOrTextOrMatcher.toList()
        )
    )
}

private fun mapToMatchers(resIdOrTextOrMatchers: List<Any>): List<Matcher<View>> {
    return resIdOrTextOrMatchers.map {
        val mapped = when (it) {
            is String -> ViewMatchers.withText(it)
            is Int -> ViewMatchers.withId(it)
            is AnyOf<*> -> it as? AnyOf<View>
            is AllOf<*> -> it as? AllOf<View>
            is Matcher<*> -> it as? Matcher<View>
            else -> null
        }
        mapped ?: throw IllegalArgumentException("Cannot match this type $it")
    }
}

fun withIndex(matcher: Matcher<View>, index: Int): Matcher<View> {
    return object : TypeSafeMatcher<View>() {
        private var currentIndex: Int = 0
        private var viewObjHash: Int = 0

        @SuppressLint("DefaultLocale")
        override fun describeTo(description: Description) {
            description.appendText(String.format("with index: %d ", index))
            matcher.describeTo(description)
        }

        override fun matchesSafely(view: View): Boolean {
            if (matcher.matches(view) && currentIndex++ == index) {
                viewObjHash = view.hashCode()
            }
            return view.hashCode() === viewObjHash
        }
    }
}

fun waitForMillis(millis: Long): ViewAction {
    return object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isDescendantOfA(ViewMatchers.isAssignableFrom(View::class.java))
        }

        override fun getDescription(): String {
            return "Wait for $millis milliseconds."
        }

        override fun perform(uiController: UiController, view: View) {
            uiController.loopMainThreadForAtLeast(millis)
        }
    }
}

fun waitForElement(matcher: Matcher<View>,
                   maxWaitTimeSeconds: Long = 10): ViewInteraction {
    val startDate = Date()
    while (true) {
        try {
            return matcher.isDisplayed()
        } catch (throwable: Throwable) {
            val timePassed = Date().time - startDate.time
            if (timePassed > 1000 * maxWaitTimeSeconds) {
                throw throwable
            }
        }
    }
}