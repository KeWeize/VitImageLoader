package com.meiquick.imageload;

import android.content.Context;

import com.meiquick.imageload.config.GlobalConfig;

/**
 * <p> <p/>
 *
 * @author kewz
 */

public class MImageLoader {

    /**
     * 默认缓存大小
     */
    private  static  int CACHE_IMAGE_SIZE=250;


    public static void init(Context context, int cacheSize) {
        GlobalConfig.init(context,cacheSize);
    }

}
