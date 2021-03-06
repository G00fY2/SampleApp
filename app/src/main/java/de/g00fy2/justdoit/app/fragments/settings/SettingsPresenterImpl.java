package de.g00fy2.justdoit.app.fragments.settings;

import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.controllers.ErrorController;
import de.g00fy2.justdoit.app.controllers.SnackbarController;
import de.g00fy2.justdoit.app.fragments.base.BasePresenterImpl;
import de.g00fy2.justdoit.app.fragments.settings.interactors.GetDataVersionInteractor;
import de.g00fy2.justdoit.app.navigation.NavigationDrawer;
import de.g00fy2.model.api.APIKeyInterceptor;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 08.12.2017.
 */

public class SettingsPresenterImpl extends BasePresenterImpl
    implements SettingsContract.SettingsPresenter {

  @Inject SettingsContract.SetingsView view;

  @Inject APIKeyInterceptor apiKeyInterceptor;
  @Inject NavigationDrawer navigationDrawer;
  @Inject GetDataVersionInteractor getDataVersionInteractor;
  @Inject SnackbarController snackbarController;
  @Inject ErrorController errorController;

  @Inject public SettingsPresenterImpl() {

  }

  @Override public void onResume() {
    super.onResume();
    navigationDrawer.setCheckedItem(R.id.settings);
    bind(getDataVersionInteractor.execute()
        .subscribe(currentVersion -> view.setPatchversionPreference(currentVersion),
            errorController::onError));
  }

  @Override public void showNotAvailableNotice() {
    snackbarController.showError("Setting currently not available.");
  }

  @Override public void changeAPIKey(String newAPIKey) {
    apiKeyInterceptor.setApiKey(newAPIKey);
  }
}
