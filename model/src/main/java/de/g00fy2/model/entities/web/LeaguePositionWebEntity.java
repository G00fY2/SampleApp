package de.g00fy2.model.entities.web;

/**
 * Created by Thomas Wirth on 06.12.2017.
 */

public class LeaguePositionWebEntity {

  public String rank;
  public String queueType;
  public Boolean hotStreak;
  public String leagueName;
  public Integer wins;
  public Boolean veteran;
  public Integer losses;
  public Boolean freshBlood;
  public String leagueId;
  public String playerOrTeamName;
  public Boolean inactive;
  public String playerOrTeamId;
  public String tier;
  public Integer leaguePoints;

  @Override public String toString() {
    return "LeaguePositionWebEntity{"
        + "rank='"
        + rank
        + '\''
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
