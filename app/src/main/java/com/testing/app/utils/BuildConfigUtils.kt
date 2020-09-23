package com.testing.app.utils

import com.testing.app.BuildConfig

object BuildConfigUtils {

    private const val DEBUG_FLAVOR = "debug"


    private const val UI_TEST_BUILD = "espresso"

    @JvmStatic
    val isDebug: Boolean
        get() = BuildConfig.FLAVOR == DEBUG_FLAVOR

    @JvmStatic

    val isUiTest: Boolean
        get() = isDebug && BuildConfig.BUILD_TYPE == UI_TEST_BUILD
}