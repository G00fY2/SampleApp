package de.g00fy2.justdoit.app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import butterknife.BindView;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.annotations.Layout;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@Layout(R.layout.activity_main) public class MainActivity extends BaseActivity {

  @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.fragment_container) View fragmentContainer;
  @BindView(R.id.navigation_view) NavigationView navigationView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setSupportActionBar(toolbar);
    ActionBarDrawerToggle drawerToggle =
        new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
    drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    drawerLayout.addDrawerListener(drawerToggle);
    final ActionBar ab = getSupportActionBar();
    ab.setDisplayHomeAsUpEnabled(true);
    ab.setHomeButtonEnabled(true);
    drawerToggle.syncState();
  }

  @Override protected void onResume() {
    super.onResume();
    getNavigator().showStartFragment();
  }

  @Override protected void onStop() {
    super.onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }

  @Override public void onBackPressed() {
    if (drawerLayout.isDrawerOpen(Gravity.START)) {
      drawerLayout.closeDrawer(Gravity.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override public int getFragmentContainerId() {
    return R.id.fragment_container;
  }

  @Override public View getFragmentContainer() {
    return fragmentContainer;
  }
}
