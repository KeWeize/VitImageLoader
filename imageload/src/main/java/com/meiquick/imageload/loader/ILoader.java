package com.meiquick.imageload.loader;

import android.content.Context;

import com.meiquick.imageload.config.ImageConfig;

/**
 * <p> 定义加载器 <p/>
 *
 * @author kewz
 */

public interface ILoader {

    void init(Context context, int chacheSizeInMm);

    /**
     * 请求加载
     *
     * @param config 加载配置
     */
    void request(ImageConfig config);

}
