package com.meiquick.imageload.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.meiquick.imageload.contants.ChannelContants;

/**
 * <p> 图片加载初始化配置类 <p/>
 *
 * @author kewz
 */

public class LoadInitConfig {

    private static final String DEFAULT_DISK_CACHE_NAME = "imageCacheDir";

    private static final int DEFAULT_DISK_CACHE_SIZE = 256 * 1024 * 1024;

    /**
     * 图片加载渠道
     */
    private int chancel = ChannelContants._LOADER_CHANNEL_GLIDE;

    /**
     * 缓存目录名
     */
    private String diskCacheName = DEFAULT_DISK_CACHE_NAME;

    /**
     * 磁盘缓存大小
     */
    private int diskCacheSize = DEFAULT_DISK_CACHE_SIZE;

    /**
     * 是否缓存至外部磁盘
     */
    private boolean isExternalCacheDiskCache = false;

    /**
     * 全局默认图片加载配置
     */
    private ImageConfig defaultImageConfig;

    private LoadInitConfig(Builder builder) {
        this.chancel = builder.chancel;
        this.diskCacheName = builder.diskCacheName;
        this.diskCacheSize = builder.diskCacheSize;
        this.isExternalCacheDiskCache = builder.isExternalCacheDiskCache;
        this.defaultImageConfig = builder.defaultImageConfig;
    }

    public int getChancel() {
        return chancel;
    }

    public String getDiskCacheName() {
        return diskCacheName;
    }

    public int getDiskCacheSize() {
        return diskCacheSize;
    }

    public boolean isExternalCacheDiskCache() {
        return isExternalCacheDiskCache;
    }

    public ImageConfig getDefaultImageConfig() {
        return defaultImageConfig;
    }

    public static class Builder {
        /**
         * 图片加载渠道
         */
        private int chancel;

        /**
         * 缓存目录名
         */
        private String diskCacheName;

        /**
         * 磁盘缓存大小
         */
        private int diskCacheSize;

        /**
         * 是否缓存至外部磁盘
         */
        private boolean isExternalCacheDiskCache;

        /**
         * 全局默认图片加载配置
         */
        private ImageConfig defaultImageConfig;

        /**
         * 加载器
         *
         * @param chancel
         * @return
         */
        public Builder chancel(@ChannelContants.Prop int chancel) {
            this.chancel = chancel;
            return this;
        }

        /**
         * 硬盘缓存目录名
         *
         * @param diskCacheName
         * @return
         */
        public Builder diskCacheName(@NonNull String diskCacheName) {
            if (!TextUtils.isEmpty(diskCacheName)) {
                this.diskCacheName = diskCacheName;
            }
            return this;
        }

        /**
         * 硬盘缓存大小
         *
         * @param diskCacheSize
         * @return
         */
        public Builder diskCacheSize(@NonNull int diskCacheSize) {
            if (diskCacheSize > 0) {
                this.diskCacheSize = diskCacheSize;
            }
            return this;
        }

        /**
         * 外部硬盘缓存
         *
         * @return
         */
        public Builder asExternalCacheDiskCache() {
            isExternalCacheDiskCache = true;
            return this;
        }

        /**
         * 内部硬盘缓存
         *
         * @return
         */
        public Builder asInternalCacheDiskCache() {
            isExternalCacheDiskCache = false;
            return this;
        }

        /**
         * 默认全局加载配置
         *
         * @param defaultImageConfig
         * @return
         */
        public Builder defaultImageConfig(ImageConfig defaultImageConfig) {
            this.defaultImageConfig = defaultImageConfig;
            return this;
        }

        public LoadInitConfig builder() {
            return new LoadInitConfig(this);
        }
    }

}
