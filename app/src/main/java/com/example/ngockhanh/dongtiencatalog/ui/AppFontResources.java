package com.example.ngockhanh.dongtiencatalog.ui;


import android.content.Context;
import android.graphics.Typeface;

public class AppFontResources {

  private static AppFontResources sInstance;

  private static Typeface[] TYPEFACES;

    private Context mContext;

  public AppFontResources(Context context) {
      mContext = context;
    initTypefaces(mContext);
  }

  public static AppFontResources initResources(Context context) {
    if (sInstance == null) {
      sInstance = new AppFontResources(context);
    }
    return sInstance;
  }

  public static AppFontResources getInstance(Context context) {
    if (sInstance == null) {
      sInstance = initResources(context);
    }
    return sInstance;
  }

  private void initTypefaces(Context context) {
    TYPEFACES = new Typeface[3];
    TYPEFACES[0] = Typeface.createFromAsset(context.getAssets(), "fonts/UTM-AVO.ttf");
    TYPEFACES[1] = Typeface.createFromAsset(context.getAssets(), "fonts/UTM-BRYANT_LG.ttf");
  }

  public Typeface getTypeFace(TextTypeFace textTypeFace) {
    switch (textTypeFace){
      case UTM_AVO:
        return TYPEFACES[0];
      case UTM_BRYANTLG:
        return TYPEFACES[1];
      default:
        return TYPEFACES[0];
    }
  }

  public enum TextTypeFace {
    UTM_BRYANTLG,
    UTM_AVO
  }
}
