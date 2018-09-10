package com.meiquick.imageload.contants;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <p> 定义加载器名称 <p/>
 *
 * @author kewz
 */

public class ChannelContants {

    @IntDef({_LOADER_CHANNEL_GLIDE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Prop{}

    public final static int _LOADER_CHANNEL_GLIDE = 1;

}
