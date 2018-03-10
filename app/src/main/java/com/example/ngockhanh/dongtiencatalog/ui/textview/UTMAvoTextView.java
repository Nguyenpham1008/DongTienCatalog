package com.example.ngockhanh.dongtiencatalog.ui.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.example.ngockhanh.dongtiencatalog.ui.AppFontResources;
import com.example.ngockhanh.dongtiencatalog.ui.AppFontResources.TextTypeFace;

/**
 * Created by Ngoc Khanh on 3/10/2018.
 */

public class UTMAvoTextView extends AbsTypeFaceTextView {

  public UTMAvoTextView(Context context) {
    super(context);
  }

  public UTMAvoTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public UTMAvoTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected Typeface getAppTypeface()
  {
    return AppFontResources.getInstance(getContext()).getTypeFace(TextTypeFace.UTM_AVO);
  }
}
