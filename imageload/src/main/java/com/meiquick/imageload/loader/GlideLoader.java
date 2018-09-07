package com.meiquick.imageload.loader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.RequestOptions;
import com.meiquick.imageload.R;
import com.meiquick.imageload.config.ImageConfig;
import com.meiquick.imageload.config.CropMode;
import com.meiquick.imageload.config.LoadInitConfig;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * <p> Glide 加载器 <p/>
 *
 * @author kewz
 */

public class GlideLoader implements ILoader {

    private static String TAG = GlideLoader.class.getSimpleName();

    @Override
    public void init(Context context, LoadInitConfig loadInitConfig) {
        Glide.get(context).setMemoryCategory(MemoryCategory.NORMAL);
        GlideBuilder builder = new GlideBuilder();
        if (loadInitConfig.isExternalCacheDiskCache()) {
            builder.setDiskCache(new ExternalPreferredCacheDiskCacheFactory(context,
                    loadInitConfig.getDiskCacheName(), loadInitConfig.getDiskCacheSize()));
        } else {
            builder.setDiskCache(new InternalCacheDiskCacheFactory(context,
                    loadInitConfig.getDiskCacheName(), loadInitConfig.getDiskCacheSize()));
        }
    }

    @Override
    public void request(final ImageConfig config) {

        RequestBuilder requestBuilder
                = generateRequestBuilder(config, Glide.with(config.getContext()));
        if (requestBuilder == null) {
            Log.e(TAG, "requestBuilder is null");
        }
        // 添加请求选项
        requestBuilder = requestBuilder.apply(generateRequestOptions(config));
        if (config.isAsBitmap()) {
            // 下载 bitmap 图片
        } else {


            if (config.isAsGif()) {
                // 加载为 gif
            }
            // 加载到 ImageView 上
            if (config.getTarget() instanceof ImageView) {
                requestBuilder.into((ImageView) config.getTarget());
            }
        }

    }

    /**
     * 获取设置了请求源的 Glide RequestBuilder
     *
     * @param config
     * @param requestManager
     * @return
     */
    private RequestBuilder<Drawable> generateRequestBuilder(ImageConfig config, RequestManager requestManager) {
        RequestBuilder requestBuilder = null;
        if (!TextUtils.isEmpty(config.getUrl())) {
            // 请求来源为网络图片
            requestBuilder = requestManager.load(config.getUrl());
        } else if (!TextUtils.isEmpty(config.getFilePath())) {
            // 请求来源为文件路径
            requestBuilder = requestManager.load(config.getFilePath());
        } else if (config.getFile() != null) {
            // 请求来源为文件对象
            requestBuilder = requestManager.load(config.getFile());
        } else if (config.getResId() > 0) {
            // 请求来源为资源 id
            requestBuilder = requestManager.load(config.getResId());
        } else if (!TextUtils.isEmpty(config.getAssertspath())) {
            // 请求来源为 assert
            requestBuilder = requestManager.load(config.getAssertspath());
        } else if (!TextUtils.isEmpty(config.getRawPath())) {
            // 请求来源为 raw
            requestBuilder = requestManager.load(config.getRawPath());
        }
        return requestBuilder;
    }

    /**
     * 获取请求选项
     *
     * @return
     */
    private RequestOptions generateRequestOptions(ImageConfig config) {
        RequestOptions requestOptions = new RequestOptions();
        // 设置加载占位符
        if (config.getPlaceholderId() > 0) {
            requestOptions.placeholder(config.getPlaceholderId());
        }
        if (config.getErrorId() > 0) {
            requestOptions.error(config.getErrorId());
        }
        if (config.getFallbackId() > 0) {
            requestOptions.fallback(config.getFallbackId());
        }
        Transformation[] transformations = new Transformation[calculateExtendedTransformCount(config) + 1];
        // 加载图片剪切模式
        switch (config.getCropMode()) {
            case CropMode.CROP_FIT_CENTER:
                transformations[0] = new FitCenter();
                break;

            case CropMode.CROP_ROUND:
                transformations[0] = new RoundedCornersTransformation(config.getRadius(),
                        0, RoundedCornersTransformation.CornerType.ALL);
                break;

            case CropMode.CROP_CIRCLE:
                transformations[0] = new CircleCrop();
                break;

            case CropMode.CROP_CENTER_CROP:
            default:
                transformations[0] = new CenterCrop();
                break;
        }
        int count = 1;
        // 其他转换效果
        if (config.getBlur() > 0) {
            transformations[count] = new BlurTransformation(config.getBlur());
        }
        requestOptions.transforms(transformations);
        return requestOptions;
    }

    /**
     * 计算其他转换效果的数量
     *
     * @param config
     * @return
     */
    private int calculateExtendedTransformCount(ImageConfig config) {
        int count = 0;
        if (config.getBlur() > 0) {
            count++;
        }
        return count;
    }

}
