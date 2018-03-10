package com.example.ngockhanh.dongtiencatalog.ui.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Ngoc Khanh on 3/10/2018.
 */

public abstract class AbsTypeFaceTextView extends TextView {

  protected abstract Typeface getAppTypeface();

  public AbsTypeFaceTextView(Context context) {
    super(context);
    setTypeface(getAppTypeface());
  }

  public AbsTypeFaceTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    setTypeface(getAppTypeface());
  }

  public AbsTypeFaceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    setTypeface(getAppTypeface());
  }
}