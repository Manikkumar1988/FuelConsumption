package fuellogadfree.mani.com;

import android.app.Activity;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

  private TextView passwordView;
  Activity activity;

  @Before
  public void setUp() {
    activity = Robolectric.setupActivity(MainActivity.class);
    passwordView =  activity.findViewById(R.id.message);
  }

  @Test
  public void appLaunchSuccess() {
    assertThat(passwordView.getText().toString()).isEqualTo("Home");
  }


  @Test
  public void appNavigateToDashboard() {
    activity.findViewById(R.id.navigation_dashboard).performClick();
    assertThat(passwordView.getText().toString()).isEqualTo("Dashboard");
  }

  @Test
  public void appNavigateToNotification() {
    activity.findViewById(R.id.navigation_notifications).performClick();
    assertThat(passwordView.getText().toString()).isEqualTo("Notifications");
  }


  @Test
  public void appNavigateToHome() {
    activity.findViewById(R.id.navigation_home).performClick();
    assertThat(passwordView.getText().toString()).isEqualTo("Home");
  }



}