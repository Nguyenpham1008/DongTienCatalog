package com.example.ngockhanh.dongtiencatalog.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.example.ngockhanh.dongtiencatalog.fragment.base.BaseFragment;
import com.example.ngockhanh.dongtiencatalog.R;

/**
 * Created by Ngoc Khanh on 3/10/2018.
 */

public class SampleFaceCakeFragment extends BaseFragment {

  public static SampleFaceCakeFragment newInstance() {
    Bundle args = new Bundle();
    SampleFaceCakeFragment fragment = new SampleFaceCakeFragment();
    fragment.setArguments(args);
    return fragment;
  }
  @Override
  protected int setLayoutResourceID() {
    return R.layout.fragment_mold_shaping;
  }
}
