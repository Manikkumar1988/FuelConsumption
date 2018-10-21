package fuellogadfree.mani.com;

import android.app.Activity;
import android.app.Fragment;
import fuellogadfree.mani.com.ui.MainActivity;
import fuellogadfree.mani.com.ui.fragment.DashboardFragment;
import fuellogadfree.mani.com.ui.fragment.LogEntryFragment;
import fuellogadfree.mani.com.ui.fragment.LogsFragment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

  private Fragment fragmentInView;
  private Activity activity;

  @Before
  public void setUp() {
    activity = Robolectric.setupActivity(MainActivity.class);
  }

  @Test
  public void appLaunchSuccess() {
    fragmentInView = activity.getFragmentManager().findFragmentById(R.id.fragment_container);

    assertEquals(fragmentInView.getClass().getSimpleName(),
        DashboardFragment.class.getSimpleName());
  }


  @Test
  public void appNavigateToDashboard() {
    activity.findViewById(R.id.navigation_dashboard).performClick();
    fragmentInView = activity.getFragmentManager().findFragmentById(R.id.fragment_container);

    assertEquals(fragmentInView.getClass().getSimpleName(), LogsFragment.class.getSimpleName());
  }

  @Test
  public void appNavigateToNotification() {
    activity.findViewById(R.id.navigation_notifications).performClick();
    fragmentInView = activity.getFragmentManager().findFragmentById(R.id.fragment_container);

    assertEquals(fragmentInView.getClass().getSimpleName(), LogEntryFragment.class.getSimpleName());
  }


  @Test
  public void appNavigateToHome() {
    activity.findViewById(R.id.navigation_home).performClick();
    fragmentInView = activity.getFragmentManager().findFragmentById(R.id.fragment_container);

    assertEquals(fragmentInView.getClass().getSimpleName(),
        DashboardFragment.class.getSimpleName());
  }



}