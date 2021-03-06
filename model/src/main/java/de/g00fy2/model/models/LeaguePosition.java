package de.g00fy2.model.models;

/**
 * Created by Thomas Wirth on 06.12.2017.
 */

public class LeaguePosition {

  public int rank;
  public String queueType;
  public boolean hotStreak;
  public String leagueName;
  public int wins;
  public boolean veteran;
  public int losses;
  public boolean freshBlood;
  public String leagueId;
  public String playerOrTeamName;
  public boolean inactive;
  public String playerOrTeamId;
  public String tier;
  public int leaguePoints;

  @Override public String toString() {
    return "LeaguePosition{"
        + "rank="
        + rank
        + ", queueType='"
        + queueType
        + '\''
        + ", hotStreak="
        + hotStreak
        + ", leagueName='"
        + leagueName
        + '\''
        + ", wins="
        + wins
        + ", veteran="
        + veteran
        + ", losses="
        + losses
        + ", freshBlood="
        + freshBlood
        + ", leagueId='"
        + leagueId
        + '\''
        + ", playerOrTeamName='"
        + playerOrTeamName
        + '\''
        + ", inactive="
        + inactive
        + ", playerOrTeamId='"
        + playerOrTeamId
        + '\''
        + ", tier='"
        + tier
        + '\''
        + ", leaguePoints="
        + leaguePoints
        + '}';
  }
}
