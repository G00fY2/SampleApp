package de.g00fy2.model.entities.web;

/**
 * Created by Thomas Wirth on 16.11.2017.
 */

public class PlayerWebEntity {

  public String currentPlatformId;
  public String summonerName;
  public String matchHistoryUri;
  public String platformId;
  public Long currentAccountId;
  public Integer profileIcon;
  public Long summonerId;
  public Long accountId;

  @Override public String toString() {
    return "PlayerWebEntity{"
        + "currentPlatformId='"
        + currentPlatformId
        + '\''
        + ", summonerName='"
        + summonerName
        + '\''
        + ", matchHistoryUri='"
        + matchHistoryUri
        + '\''
        + ", platformId='"
        + platformId
        + '\''
        + ", currentAccountId="
        + currentAccountId
        + ", profileIcon="
        + profileIcon
        + ", summonerId="
        + summonerId
        + ", accountId="
        + accountId
        + '}';
  }
}
