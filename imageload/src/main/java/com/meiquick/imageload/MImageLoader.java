package com.meiquick.imageload;

import android.content.Context;

import com.meiquick.imageload.config.ImageConfig;
import com.meiquick.imageload.config.LoadInitConfig;
import com.meiquick.imageload.contants.ChannelContants;
import com.meiquick.imageload.config.GlobalConfig;

/**
 * <p> 图片加载中间件 <p/>
 *
 * @author kewz
 */

public class MImageLoader {

    /**
     * 缓存大小
     */
    private static int DEFAULT_DISK_CACHE_SIZE = 250 * 1024 * 1024;

    /**
     * 缓存目录名
     */
    private static final String DEFAULT_DISK_CACHE_NAME = "imageCacheDir";

    /**
     * 默认图片加载器
     */
    private static final int DEFAULT_LOADER_CANCEL = ChannelContants._LOADER_CHANNEL_GLIDE;

    /***************************
     *      初始化加载配置     *
     * ************************/
    public static void init(Context context) {
        init(context, generateDefaultImageConfig(context));
    }

    public static void init(Context context, ImageConfig defaultImageConfig) {
        init(context, DEFAULT_LOADER_CANCEL, defaultImageConfig);
    }

    public static void init(Context context, @ChannelContants.Prop int channel, ImageConfig defaultImageConfig) {
        init(context, channel, DEFAULT_DISK_CACHE_NAME, DEFAULT_DISK_CACHE_SIZE, false, defaultImageConfig);
    }

    public static void init(Context context, @ChannelContants.Prop int channel, String disCacheName,
                            int disCacheSize, boolean isExternalCacheDiskCache,
                            ImageConfig defaultImageConfig) {
        LoadInitConfig.Builder builder = new LoadInitConfig.Builder()
                .chancel(channel)
                .diskCacheName(disCacheName)
                .diskCacheSize(disCacheSize)
                .defaultImageConfig(defaultImageConfig);
        if (isExternalCacheDiskCache) {
            builder.asExternalCacheDiskCache();
        } else {
            builder.asInternalCacheDiskCache();
        }
        init(context, builder.builder());
    }

    public static void init(Context context, LoadInitConfig loadInitConfig) {
        GlobalConfig.init(context, loadInitConfig);
    }

    /**
     * 默认图片加载配置
     */
    private static ImageConfig generateDefaultImageConfig(Context context) {
        return new ImageConfig.Builder(context)
                .placeholder(R.drawable.default_img_placeholder)
                .errorId(R.drawable.default_img_placeholder)
                .placeholder(R.drawable.default_img_placeholder)
                .centerCrop()
                .build();
    }

    public static ImageConfig.Builder with(Context context) {
        return new ImageConfig.Builder(context);
    }

}
