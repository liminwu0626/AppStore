package com.dingzhu.appstore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawerlayout_view)
    DrawerLayout mDrawerlayoutView;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mDrawerlayoutView.addDrawerListener(new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                Logger.d("onDrawerSlide");
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                Logger.d("onDrawerOpened");
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                Logger.d("onDrawerClosed");
//            }
//
//            @Override
//            public void onDrawerStateChanged(int newState) {
//                Logger.d("onDrawerStateChanged");
//            }
//        });
        headerView = mNavigationView.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "侧滑菜单", Toast.LENGTH_SHORT).show();
            }
        });
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.item_setting:
                        Toast.makeText(MainActivity.this, "应用更新", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_message:
                        Toast.makeText(MainActivity.this, "消息中心", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_search:
                        Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        mToolBar.inflateMenu(R.menu.menu_toolbar);
        ActionBarDrawerToggle barDrawerToggle = new ActionBarDrawerToggle(this, mDrawerlayoutView, mToolBar, R.string.open, R.string.close);
        barDrawerToggle.syncState();//同步状态
        mDrawerlayoutView.addDrawerListener(barDrawerToggle);

    }
}
