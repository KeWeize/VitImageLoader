package com.meiquick.imageload.config;

/**
 * <p> 加载图片缩放模式  <p/>
 *
 * @author kewz
 */

public interface CropMode {

    /**
     * center crop
     */
    int CROP_CENTER_CROP = 0;

    /**
     * fit center
     */
    int CROP_FIT_CENTER = 1;

    /**
     * 圆角矩形
     */
    int CROP_ROUND = 2;

    /**
     * 圆形
     */
    int CROP_CIRCLE = 3;

}
