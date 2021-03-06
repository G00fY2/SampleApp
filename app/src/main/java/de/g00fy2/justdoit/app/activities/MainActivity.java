package de.g00fy2.justdoit.app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.BindView;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.annotations.Layout;
import timber.log.Timber;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@Layout(R.layout.activity_main) public class MainActivity extends BaseActivity {

  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.fragment_container) View fragmentContainer;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    activityComponent.staticDataVersionController()
        .setupStaticData()
        .subscribe(() -> Timber.d("Static data set up"),
            activityComponent.errorController()::onError);

    setSupportActionBar(toolbar);
    final ActionBar ab = getSupportActionBar();
    if (ab != null) {
      ab.setDisplayHomeAsUpEnabled(true);
      ab.setHomeButtonEnabled(true);
    }
    getNavigationDrawer().setDrawerLayout(toolbar);
  }

  @Override protected void onResume() {
    super.onResume();
    getNavigator().showStartFragment();
  }

  @Override protected void onStop() {
    super.onStop();
    //getNavigationDrawer().unbind();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }

  @Override public void onBackPressed() {
    if (!getNavigationDrawer().closeWhenOpened()) {
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
