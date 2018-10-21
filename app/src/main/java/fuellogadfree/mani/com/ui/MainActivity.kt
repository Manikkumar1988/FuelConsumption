package fuellogadfree.mani.com.ui

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentActivity
import fuellogadfree.mani.com.R
import fuellogadfree.mani.com.R.id
import fuellogadfree.mani.com.R.layout
import fuellogadfree.mani.com.ui.fragment.DashboardFragment
import fuellogadfree.mani.com.ui.fragment.LogEntryFragment
import fuellogadfree.mani.com.ui.fragment.LogsFragment
import kotlinx.android.synthetic.main.activity_main.navigation

class MainActivity : FragmentActivity() {

  private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
      id.navigation_home -> {
        showFragment(DashboardFragment.newInstance("", ""))
        return@OnNavigationItemSelectedListener true
      }
      id.navigation_dashboard -> {
        showFragment(LogsFragment.newInstance("", ""))
        return@OnNavigationItemSelectedListener true
      }
      id.navigation_notifications -> {
        showFragment(LogEntryFragment.newInstance("", ""))
        return@OnNavigationItemSelectedListener true
      }
    }
    false
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    showFragment(DashboardFragment.newInstance("", ""))

  }

  fun showFragment(fragment: Fragment) {
    val fragmentTransition = fragmentManager.beginTransaction().replace(R.id.fragment_container,
        fragment, fragment.javaClass.simpleName)
    fragmentTransition.commit()
  }
}
