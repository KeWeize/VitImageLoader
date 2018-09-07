package com.meiquick.imageload.config;

import android.content.Context;

import com.meiquick.imageload.loader.GlideLoader;
import com.meiquick.imageload.loader.ILoader;

/**
 * <p> <p/>
 *
 * @author kewz
 */

public class GlobalConfig {

    /**
     * 全局图片加载器
     */
    private static ILoader _GLOBAL_ILOADER;

    public static void init(Context context, int cacheSize) {
        getGlobalIloader().init(context, cacheSize);
    }

    public static ILoader getGlobalIloader(int channel) {
        ILoader iLoader = null;
        switch (channel) {

            case ChannelContants._LOADER_CHANNEL_GLIDE:
                iLoader=new GlideLoader();
                break;

            default:
                break;

        }
        _GLOBAL_ILOADER = iLoader;
        return iLoader;
    }

    public static ILoader getGlobalIloader() {
        return getGlobalIloader(ChannelContants._LOADER_CHANNEL_GLIDE);
    }

}
