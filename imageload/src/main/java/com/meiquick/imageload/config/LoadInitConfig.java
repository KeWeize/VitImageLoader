package com.meiquick.imageload.config;

import android.support.annotation.NonNull;

/**
 * <p> 缓存配置类 <p/>
 *
 * @author kewz
 */

public class LoadInitConfig {

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

    private LoadInitConfig(Builder builder) {
        this.chancel = builder.chancel;
        this.diskCacheName = builder.diskCacheName;
        this.diskCacheSize = builder.diskCacheSize;
        this.isExternalCacheDiskCache = builder.isExternalCacheDiskCache;
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
            this.diskCacheName = diskCacheName;
            return this;
        }

        /**
         * 硬盘缓存大小
         *
         * @param diskCacheSize
         * @return
         */
        public Builder diskCacheSize(@NonNull int diskCacheSize) {
            this.diskCacheSize = diskCacheSize;
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

        public LoadInitConfig builder() {
            return new LoadInitConfig(this);
        }
    }

}
