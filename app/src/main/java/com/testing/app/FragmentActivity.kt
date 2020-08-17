package com.testing.app

import com.testing.app.ui.dashboard.DashboardFragment

class FragmentActivity : DashboardFragment() {
    override fun createFragment() = MainFragment.newInstance()
}
