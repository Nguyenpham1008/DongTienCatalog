package com.example.ngockhanh.dongtiencatalog.fragment.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.ngockhanh.dongtiencatalog.R;

/**
 * Created by Ngoc Khanh on 3/10/2018.
 */

public abstract class BaseFragment extends Fragment {

  protected Context context;
  protected Unbinder unbinder;

  protected static boolean shouldAskPermission() {
    return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M);
  }

  @Override
  public Context getContext() {
    return context;
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    this.context = context;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    if (setLayoutResourceID() != 0) {
      return inflater.inflate(setLayoutResourceID(), container, false);
    } else {
      return super.onCreateView(inflater, container, savedInstanceState);
    }
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    unbinder = ButterKnife.bind(this, view);
  }

  protected abstract
  @LayoutRes
  int setLayoutResourceID();

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }


  protected void toFragment(Fragment toFragment) {
    getFragmentManager().beginTransaction().add(R.id.fragment, toFragment,
        toFragment.getClass().getSimpleName()).addToBackStack(toFragment.getClass().getSimpleName())
        .commit();
  }
}
