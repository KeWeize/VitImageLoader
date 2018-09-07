package com.meiquick.imageload.config;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.RawRes;
import android.util.Log;
import android.view.View;

import java.io.File;

/**
 * <p>
 * 配置图片加载所需的相关参数。用于给图片请求框架加载图片
 * <p/>
 *
 * @author kewz
 */

public class ImageConfig {

    private Context context;
    /**
     * 网络请求地址
     */
    private String url;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 文件
     */
    private File file;
    /**
     * 资源 id
     */
    private int resId;
    /**
     * raw 路径
     */
    private String rawPath;
    /**
     * asserts路径
     */
    private String assertspath;

    /**
     * 加载 bitmap
     */
    private boolean asBitmap;
    /**
     * 加载 gif
     */
    private boolean asGif;
    /**
     * 加载图片的 View
     */
    private View target;

    /***######### 占位符 ########*/
    /**
     * 加载中
     */
    private int placeholderId;
    /**
     * 加载失败
     */
    private int errorId;
    /**
     * 加载为 null
     */
    private int fallbackId;

    /**
     * ######### 剪切模式 ##########
     */
    private int cropMode;
    private int radius;

    /**######### 其他常用转换效果 ##########*/
    /**
     * 模糊
     */
    private int blur;

    private ImageConfig(Builder builder) {
        this.context = builder.context;
        this.url = builder.url;
        this.filePath = builder.filePath;
        this.file = builder.file;
        this.resId = builder.resId;
        this.rawPath = builder.rawPath;
        this.assertspath = builder.assertspath;
        this.asBitmap = builder.asBitmap;
        this.asGif = builder.asGif;
        this.target = builder.target;
        this.placeholderId = builder.placeholderId;
        this.errorId = builder.errorId;
        this.fallbackId = builder.fallbackId;
        this.cropMode = builder.cropMode;
        this.radius = builder.radius;
        this.blur = builder.blur;
    }

    public Context getContext() {
        return context;
    }

    public String getUrl() {
        return url;
    }

    public String getFilePath() {
        return filePath;
    }

    public File getFile() {
        return file;
    }

    public int getResId() {
        return resId;
    }

    public String getRawPath() {
        return rawPath;
    }

    public String getAssertspath() {
        return assertspath;
    }

    public boolean isAsBitmap() {
        return asBitmap;
    }

    public boolean isAsGif() {
        return asGif;
    }

    public View getTarget() {
        return target;
    }

    public int getPlaceholderId() {
        return placeholderId;
    }

    public int getErrorId() {
        return errorId;
    }

    public int getFallbackId() {
        return fallbackId;
    }

    public int getCropMode() {
        return cropMode;
    }

    public int getRadius() {
        return radius;
    }

    public int getBlur() {
        return blur;
    }

    private void show() {
        // 将本身配置的加载选项传递给 loader 开始图片加载
        // ...
        GlobalConfig.getGlobalIloader().request(this);
    }

    /**
     * 构造器
     */
    public static class Builder {

        private static String TAG = Builder.class.getSimpleName();

        private Context context;
        /**
         * 网络请求地址
         */
        private String url;
        /**
         * 文件路径
         */
        private String filePath;
        /**
         * 文件
         */
        private File file;
        /**
         * 资源 id
         */
        private int resId;
        /**
         * raw 路径
         */
        private String rawPath;
        /**
         * asserts路径
         */
        private String assertspath;
        /**
         * 加载 bitmap
         */
        private boolean asBitmap;
        /**
         * 加载 gif
         */
        private boolean asGif;
        /**
         * 加载图片的 View
         */
        private View target;

        /***######### 占位符 ########*/
        /**
         * 加载中
         */
        private int placeholderId;
        /**
         * 加载失败
         */
        private int errorId;
        /**
         * 加载为 null
         */
        private int fallbackId;

        /**
         * ######### 剪切模式 ##########
         */
        private int cropMode;
        private int radius;

        /**######### 其他常用转换效果 ##########*/
        /**
         * 模糊
         */
        private int blur;

        public Builder(@NonNull Context context) {
            this.context = context;
        }

        /**
         * 加载网络图片
         *
         * @param url
         * @return
         */
        public Builder url(@NonNull String url) {
            this.url = url;
            if (url.endsWith(ImageContants.CONTANTS_SUFFIX_GIF)) {
                asGif = true;
            }
            return this;
        }

        /**
         * 加载内存中资源
         *
         * @param filePath
         * @return
         */
        public Builder file(@NonNull String filePath) {
            File file = new File(filePath);
            if (!file.exists()) {
                Log.e(TAG, "file not exists");
                return this;
            }
            if (!filePath.startsWith("file://")) {
                filePath += "file://";
            }
            if (filePath.endsWith(ImageContants.CONTANTS_SUFFIX_GIF)) {
                asGif = true;
            }
            this.filePath = filePath;
            return this;
        }

        /**
         * 加载文件定义的图片
         *
         * @param file
         * @return
         */
        public Builder file(@NonNull File file) {
            if (!file.exists()) {
                Log.e(TAG, "file not exists");
            }
            this.file = file;
            return this;
        }

        /**
         * 加载资源 id 图片
         *
         * @param resId
         * @return
         */
        public Builder res(@DrawableRes int resId) {
            this.resId = resId;
            return this;
        }

        /**
         * 加载 raw 图片
         *
         * @param raw
         * @return
         */
        public Builder raw(@RawRes int raw) {
            String path = ImageContants.CONTANTS_PATH_RESOURCE + context.getPackageName()
                    + ImageContants.CONTANTS_PATH_RAW + raw;

            this.rawPath = path;
            if (rawPath.endsWith(ImageContants.CONTANTS_SUFFIX_GIF)) {
                asGif = true;
            }
            return this;
        }

        /**
         * 加载 asserts 资源
         *
         * @param path
         * @return
         */
        public Builder asserts(@NonNull String path) {
            this.assertspath = path;
            if (rawPath.endsWith(ImageContants.CONTANTS_SUFFIX_GIF)) {
                asGif = true;
            }
            return this;
        }

        /**
         * 加载中占位符
         *
         * @param placeholderId
         * @return
         */
        public Builder placeholder(@DrawableRes int placeholderId) {
            this.placeholderId = placeholderId;
            return this;
        }

        /**
         * 加载错误占位符
         *
         * @param errorId
         * @return
         */
        public Builder errorId(@DrawableRes int errorId) {
            this.errorId = errorId;
            return this;
        }

        /**
         * 加载为 null 占位符
         *
         * @param fallbackId
         * @return
         */
        public Builder fallback(@DrawableRes int fallbackId) {
            this.fallbackId = fallbackId;
            return this;
        }

        /**
         * 缩放模式为 fitCenter
         *
         * @return
         */
        public Builder fitCenter() {
            this.cropMode = CropMode.CROP_FIT_CENTER;
            return this;
        }

        /**
         * 缩放模式为 centerCrop
         *
         * @return
         */
        public Builder centerCrop() {
            this.cropMode = CropMode.CROP_CENTER_CROP;
            return this;
        }

        /**
         * 加载形状为：圆角矩形
         *
         * @param radius
         * @return
         */
        public Builder roundCrop(@NonNull int radius) {
            this.radius = radius;
            this.cropMode = CropMode.CROP_ROUND;
            return this;
        }

        /**
         * 加载形状为：椭圆
         *
         * @return
         */
        public Builder asCircle() {
            this.cropMode = CropMode.CROP_CIRCLE;
            return this;
        }

        /**
         * 模糊粒度
         *
         * @param blur
         * @return
         */
        public Builder blur(int blur) {
            this.blur = blur;
            return this;
        }

        public void into(@NonNull View targetView) {
            this.target = targetView;
            // 实例 ImageConfig， 开始调用 loader 加载图片
            new ImageConfig(this).show();
        }

    }

}
