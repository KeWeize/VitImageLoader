package com.meiquick.imageload.loader;

import android.content.Context;

import com.meiquick.imageload.config.ImageConfig;
import com.meiquick.imageload.config.LoadInitConfig;

/**
 * <p> 定义加载器 <p/>
 *
 * @author kewz
 */

public interface ILoader {

    /**
     * 初始化缓存目录、大小
     *
     * @param context
     * @param loadInitConfig
     */
    void init(Context context, LoadInitConfig loadInitConfig);

    /**
     * 请求加载
     *
     * @param config 加载配置
     */
    void request(ImageConfig config);

    /**
     * 清理所有的缓存
     */
    void clearAllCaches(Context context);

}
