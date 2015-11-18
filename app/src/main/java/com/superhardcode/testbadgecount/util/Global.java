package com.superhardcode.testbadgecount.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Thanisak Piyasaksiri on 11/18/15 AD.
 */
public class Global {

    public static final int MUIFlag_HOMESCREEN = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    public static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    public static void setSystemUiVisibility(final Context context) {

        if(Global.isKitKat()) {

            ((Activity)context).getWindow().getDecorView().setSystemUiVisibility(Global.MUIFlag_HOMESCREEN);
            ((Activity)context).getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                @Override
                public void onSystemUiVisibilityChange(int visibility) {

                    if(visibility == 0) {

                        new Handler().postDelayed(new Runnable(){
                            @Override
                            public void run() {

                                ((AppCompatActivity)context).getWindow().getDecorView().setSystemUiVisibility(Global.MUIFlag_HOMESCREEN);
                            }
                        }, Global.AUTO_HIDE_DELAY_MILLIS);
                    }
                }
            });
        } else {
            ((Activity)context).getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    public static int getTopPadding(Context context, Toolbar toobar) {

        TypedValue tv = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true);
        int actionBarHeight = context.getResources().getDimensionPixelSize(tv.resourceId);
        int toppadding = toobar.getLayoutParams().height - actionBarHeight;

        return toppadding;
    }

    public static boolean isKitKat() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return true;
        } else {
            return false;
        }
    }


}
