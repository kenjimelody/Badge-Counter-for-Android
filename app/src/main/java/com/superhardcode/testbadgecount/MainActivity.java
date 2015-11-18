package com.superhardcode.testbadgecount;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.superhardcode.testbadgecount.util.Global;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar home_toolbar;
    private RelativeLayout viewBadge;
    private ImageView toolbar_badge_icon;

    private TextView viewTextBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    protected void onResume() {

        super.onResume();
        Global.setSystemUiVisibility(this);
    }

    private void init() {

        home_toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(home_toolbar);

        home_toolbar.setTitle("Home");
        home_toolbar.setNavigationIcon(R.mipmap.icon_top_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);

        MenuItemCompat.setActionView(((MenuItem) menu.findItem(R.id.action_home_inbox)), R.layout.view_toolbar_badge);
        viewBadge = (RelativeLayout) MenuItemCompat.getActionView(((MenuItem) menu.findItem(R.id.action_home_inbox)));
        toolbar_badge_icon = (ImageView) viewBadge.findViewById(R.id.toolbar_badge_icon);
        toolbar_badge_icon.setOnClickListener(this);

        viewTextBadge = (TextView) viewBadge.findViewById(R.id.toolbar_badge_count);
        viewTextBadge.setText("10");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.toolbar_badge_icon:
                break;
            default:
                break;
        }
    }
}
