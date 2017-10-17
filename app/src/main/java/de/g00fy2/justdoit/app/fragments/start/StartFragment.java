package de.g00fy2.justdoit.app.fragments.start;

import android.widget.TextView;
import butterknife.BindView;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.annotations.Layout;
import de.g00fy2.justdoit.app.annotations.Title;
import de.g00fy2.justdoit.app.fragments.base.BaseFragment;
import de.g00fy2.justdoit.app.fragments.base.BasePresenter;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@Layout(R.layout.fragment_start) @Title(R.string.app_name) public class StartFragment
    extends BaseFragment implements StartContract.StartView {

  @Inject StartContract.StartPresenter presenter;

  @BindView(R.id.start_hello_world_textview) TextView helloWorldTextView;

  @Override protected void initializeViews() {

  }

  @Override protected BasePresenter registerPresenter() {
    return presenter;
  }
}