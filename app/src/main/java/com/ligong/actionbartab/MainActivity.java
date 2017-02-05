package com.ligong.actionbartab;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private View mCustomView;
    private static String[] titles = new String[]{"首页","订阅","黄石","娱乐","全运动","生活","科技","财经"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomView = getLayoutInflater().inflate(R.layout.action_bar_display_options_custom, null);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("人民日报");
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setCustomView(mCustomView);

        addTabItem(bar);

    }

    private void addTabItem(ActionBar bar) {
        bar.addTab(bar.newTab().setText("首页").setTabListener( new TabListener(getTabContentFragment(titles[0]))));
        bar.addTab(bar.newTab().setText("订阅").setTabListener(new TabListener(getTabContentFragment(titles[1]))));
        bar.addTab(bar.newTab().setText("黄石").setTabListener(new TabListener(getTabContentFragment(titles[2]))));
        bar.addTab(bar.newTab().setText("娱乐").setTabListener(new TabListener(getTabContentFragment(titles[3]))));
        bar.addTab(bar.newTab().setText("全运动").setTabListener(new TabListener(getTabContentFragment(titles[4]))));
        bar.addTab(bar.newTab().setText("生活").setTabListener(new TabListener(getTabContentFragment(titles[5]))));
        bar.addTab(bar.newTab().setText("科技").setTabListener(new TabListener(getTabContentFragment(titles[6]))));
        bar.addTab(bar.newTab().setText("财经").setTabListener(new TabListener(getTabContentFragment(titles[7]))));
    }

    //创建一个fragment并传入值
    private TabContentFragment getTabContentFragment(String s) {
        TabContentFragment fragment = new TabContentFragment();
        Bundle b = new Bundle();
        b.putString("content",s);
        fragment.setArguments(b);
        return fragment;
    }



    public void clickme(View view) {
        if (getSupportActionBar() != null && getSupportActionBar().isShowing()) {
            getSupportActionBar().hide();
        } else {
            getSupportActionBar().show();
        }
    }

    //选项卡点击事件
    public class TabListener implements ActionBar.TabListener {
        private TabContentFragment mFragment;

        public TabListener(TabContentFragment fragment) {
            mFragment = fragment;
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            if (!mFragment.isAdded()) {
                ft.add(R.id.fragment_content, mFragment, titles[tab.getPosition()]);
            } else {
                ft.show(mFragment);
            }

        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            //ft.remove(mFragment);
            ft.hide(mFragment);
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            Toast.makeText(MainActivity.this, "Reselected!", Toast.LENGTH_SHORT).show();
        }
    }








}
