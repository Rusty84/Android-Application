package com.testing.app

import android.app.Activity
import android.os.Bundle

class UiTestLauncherActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_test_launcher)
    }
}