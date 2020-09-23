package com.testing.app.Util

import androidx.test.rule.ActivityTestRule
import com.testing.app.UiTestLauncherActivity
import org.junit.Rule

abstract class UiTest {

    @get:Rule
    val rule = ActivityTestRule(UiTestLauncherActivity::class.java)


}