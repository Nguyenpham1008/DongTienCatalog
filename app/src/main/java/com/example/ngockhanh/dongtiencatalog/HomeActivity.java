package com.example.ngockhanh.dongtiencatalog;

import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.ngockhanh.dongtiencatalog.fragment.SampleFaceCakeFragment;

public class HomeActivity extends AppCompatActivity {
  @BindView(R.id.tab_layout)
  TabLayout tabHome;
  @BindView(R.id.fragment)
  FrameLayout mContentLayout;
  private String[] tabTitle;
  private int[] tabIconUnselected = new int[]
      {R.drawable.ic_teddy_bear,
      R.drawable.ic_coffee_machine,
      R.drawable.ic_idea};
  private int[] tabIconSelected = new int[]
      {R.drawable.ic_teddy_bear_selected,
          R.drawable.ic_coffee_machine_selected,
          R.drawable.ic_idea_selected};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);
    initTabName();
    setupTab();
    setDefaultTabWhenLoad();
  }


  private void initTabName() {

    tabTitle = new String[]{getResources().getString(R.string.sample),
        getResources().getString(R.string.machine), getResources().getString(R.string.other)
    };
  }

  private void setupTab() {

    for (int i = 0; i < tabTitle.length; i++) {
      TabLayout.Tab tab = tabHome.newTab();
      tab.setCustomView(getTabView(i,false));
      tabHome.addTab(tab);
    }
  }

  private View getTabView(int position,boolean isSelected) {
    View v = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
    TextView tvTitle = (TextView) v.findViewById(R.id.tab_title);
    ImageView ivIcon = (ImageView) v.findViewById(R.id.tab_icon);
    ivIcon.setImageResource(isSelected==true? tabIconSelected[position]: tabIconUnselected[position]);
    tvTitle.setText(tabTitle[position]);
    return v;
  }

  void setDefaultTabWhenLoad() {
    tabHome.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        tab.getCustomView().setSelected(true);
        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        setCurrentTabFragment(tab.getPosition());
        ImageView ivIcon = (ImageView) tab.getCustomView().findViewById(R.id.tab_icon);
        ivIcon.setImageResource(tabIconSelected[tab.getPosition()]);
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {
        ImageView ivIcon = (ImageView) tab.getCustomView().findViewById(R.id.tab_icon);
        ivIcon.setImageResource(tabIconUnselected[tab.getPosition()]);
      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {
        tab.getCustomView().setSelected(true);
        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        setCurrentTabFragment(tab.getPosition());
        ImageView ivIcon = (ImageView) tab.getCustomView().findViewById(R.id.tab_icon);
        ivIcon.setImageResource(tabIconSelected[tab.getPosition()]);
      }
    });
    tabHome.getTabAt(0).getCustomView().setSelected(true);
    ImageView ivIcon = (ImageView)   tabHome.getTabAt(0).getCustomView().findViewById(R.id.tab_icon);
    ivIcon.setImageResource(tabIconSelected[0]);
    tabHome.getTabAt(0).select();

  }

  private void setCurrentTabFragment(int tabPosition) {
    switch (tabPosition) {
      case 0:
        replaceFragment(SampleFaceCakeFragment.newInstance());
        break;

    }
  }

  public void replaceFragment(Fragment fragment) {

    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.fragment, fragment, fragment.getClass().getSimpleName());
    ft.commit();
  }
}
