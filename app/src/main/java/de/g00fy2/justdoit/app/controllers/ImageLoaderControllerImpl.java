package de.g00fy2.justdoit.app.controllers;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import de.g00fy2.justdoit.app.activities.BaseActivity;
import de.g00fy2.model.utils.Constants;
import de.g00fy2.model.utils.LeagueAPIUtils;
import io.reactivex.Completable;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 29.11.2017.
 */

public class ImageLoaderControllerImpl implements ImageLoaderController {

  private final BaseActivity baseActivity;
  private final String BASE_URL = "http://ddragon.leagueoflegends.com/cdn/";
  private String latestVersion = Constants.fallbackDataVersion;

  @Inject public ImageLoaderControllerImpl(BaseActivity baseActivity) {
    this.baseActivity = baseActivity;
  }

  @Override public Completable setLatestVersion(String latestVersion) {
    return Completable.create(emitter -> {
      this.latestVersion = latestVersion;
      emitter.onComplete();
    });
  }

  @Override
  public void loadProfileIcon(int profileIconId, ImageView imageView, Boolean circleCrop) {
    if (imageView != null) {
      String url = generateProfileImageUrl(profileIconId);
      if (circleCrop) {
        loadCircleTransformed(url).into(imageView);
      } else {
        load(url).into(imageView);
      }
    }
  }

  @Override
  public void loadChampionIcon(String championKey, ImageView imageView, Boolean circleCrop) {
    if (imageView != null && championKey != null) {
      String url = generateChampionImageUrl(championKey);
      if (circleCrop) {
        loadCircleTransformed(url).into(imageView);
      } else {
        load(url).into(imageView);
      }
    }
  }

  @Override public void loadSpellIcon(String spellKey, ImageView imageView, Boolean circleCrop) {
    if (imageView != null && spellKey != null) {
      String url = generateSpellImageUrl(spellKey);
      if (circleCrop) {
        loadCircleTransformed(url).into(imageView);
      } else {
        load(url).into(imageView);
      }
    }
  }

  @Override public void loadDivisionIcon(String tier, int rank, ImageView imageView) {
    int drawableId = getIconRessourceForPosition(tier, rank);
    if (imageView != null && drawableId != 0) {
      Glide.with(baseActivity).load(drawableId).into(imageView);
    }
  }

  private RequestBuilder<Drawable> load(String url) {
    return Glide.with(baseActivity).load(url);
  }

  private RequestBuilder<Drawable> loadCircleTransformed(String url) {
    return Glide.with(baseActivity).load(url).apply(RequestOptions.circleCropTransform());
  }

  private String generateProfileImageUrl(int iconId) {
    String url = BASE_URL + latestVersion + "/img/profileicon/";
    return url + String.valueOf(iconId) + ".png";
  }

  private String generateChampionImageUrl(String name) {
    String url = BASE_URL + latestVersion + "/img/champion/";
    return url + name + ".png";
  }

  private String generateSpellImageUrl(String name) {
    String url = BASE_URL + latestVersion + "/img/spell/";
    return url + name + ".png";
  }

  private int getIconRessourceForPosition(String tier, int rank) {
    tier = tier.toLowerCase();
    String imagename = tier + "_" + LeagueAPIUtils.transformRankToString(rank).toLowerCase();
    Resources res = baseActivity.getResources();
    int resId = res.getIdentifier(imagename, "drawable", baseActivity.getPackageName());

    if (resId != 0) {
      return resId;
    } else {
      return res.getIdentifier(tier, "drawable", baseActivity.getPackageName());
    }
  }
}
