package com.meiquick.vitimageload;

import android.app.Application;

import com.meiquick.imageload.MImageLoader;

/**
 * <p> <p/>
 *
 * @author kewz
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MImageLoader.init(getBaseContext());
    }
}
