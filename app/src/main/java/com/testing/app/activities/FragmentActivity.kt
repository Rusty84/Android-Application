package com.testing.app.activities

import com.testing.app.MainFragment
import com.testing.app.ui.dashboard.DashboardFragment

class FragmentActivity : DashboardFragment() {
    override fun createFragment() =
        MainFragment.newInstance()
}
