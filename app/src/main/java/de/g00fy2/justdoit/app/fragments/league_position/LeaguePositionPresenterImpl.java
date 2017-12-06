package de.g00fy2.justdoit.app.fragments.league_position;

import de.g00fy2.justdoit.app.controllers.ErrorController;
import de.g00fy2.justdoit.app.fragments.base.BasePresenterImpl;
import de.g00fy2.justdoit.app.fragments.league_position.interactors.GetLeagueItemsDataInteractor;
import de.g00fy2.justdoit.app.fragments.league_position.interactors.GetLeaguePositionsDataInteractor;
import de.g00fy2.model.models.LeagueItem;
import de.g00fy2.model.models.LeaguePosition;
import de.g00fy2.model.models.Summoner;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.12.2017.
 */

public class LeaguePositionPresenterImpl extends BasePresenterImpl
    implements LeaguePositionContract.LeaguePositionPresenter {

  private List<LeagueItem> leagueItemList = new ArrayList<>();
  private Summoner summoner;

  @Inject LeaguePositionContract.LeaguePositionView view;

  @Inject GetLeaguePositionsDataInteractor getLeaguePositionsDataInteractor;
  @Inject GetLeagueItemsDataInteractor getLeagueItemsDataInteractor;
  @Inject ErrorController errorController;

  @Inject public LeaguePositionPresenterImpl() {

  }

  @Override public void onResume() {
    super.onResume();
    view.setSummonerData(summoner);
    getCurrentLeaguePosition();
  }

  @Override public void setSummoner(Summoner summoner) {
    this.summoner = summoner;
  }

  @Override public LeagueItem getLeaguePositionInPosition(int position) {
    return leagueItemList.get(position);
  }

  @Override public int getDataSize() {
    return leagueItemList.size();
  }

  private void getCurrentLeaguePosition() {
    bind(getLeaguePositionsDataInteractor.execute(Long.toString(summoner.id))
        .subscribe(this::setLeagueData, errorController::onError));
  }

  private void getCurrentLeagueItems(String leagueId) {
    leagueItemList.clear();
    bind(getLeagueItemsDataInteractor.execute(leagueId).subscribe(leagueItems -> {
      leagueItemList = leagueItems;
      view.dataChanged();
    }, errorController::onError));
  }

  private void setLeagueData(Set<LeaguePosition> leaguePositionSet) {
    LeaguePosition rankedPosition = null;
    LeaguePosition flexPosition = null;

    if (leaguePositionSet != null && leaguePositionSet.size() > 0) {
      for (LeaguePosition leaguePosition : leaguePositionSet) {
        if (leaguePosition.queueType.equals("RANKED_SOLO_5x5")) rankedPosition = leaguePosition;
        if (leaguePosition.queueType.equals("RANKED_FLEX_SR") && rankedPosition == null) {
          flexPosition = leaguePosition;
        }
      }
    }
    if (rankedPosition != null) {
      getCurrentLeagueItems(rankedPosition.leagueId);
      view.setLeagueData(rankedPosition);
    } else if (flexPosition != null) {
      getCurrentLeagueItems(rankedPosition.leagueId);
      view.setLeagueData(flexPosition);
    }
  }
}