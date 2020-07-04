package Util

import androidx.test.rule.ActivityTestRule
import com.testing.app.MainActivity
import org.junit.AfterClass
import org.junit.Rule

abstract class UiTest(private val autoStart: Boolean = true) {

    companion object {

        @JvmStatic
        @AfterClass
        fun tearDownTest() {
        }
    }

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)
}