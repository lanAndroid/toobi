package com.netease.nim.uikit.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.netease.nim.uikit.NimUIKit;
import com.netease.nim.uikit.common.util.log.LogUtil;

import java.io.File;

/**
 * Created by huangjun on 2017/4/1.
 */
@SuppressWarnings("deprecation")
public class NIMGlideModule implements com.bumptech.glide.module.GlideModule {
    private static final String TAG = "NIMGlideModule";

    private static final int M = 1024 * 1024;
    private static final int MAX_DISK_CACHE_SIZE = 256 * M;
    private static DiskCache diskCache = null;

    /**
     * ************************ Disk Cache ************************
     */
    @SuppressWarnings("deprecation")
    private static synchronized DiskCache getDiskCache() {
        if (diskCache == null) {
            diskCache = createDiskCache();
        }
        return diskCache;
    }
    @SuppressWarnings("deprecation")
    private static synchronized DiskCache createDiskCache() {
        final Context context = NimUIKit.getContext();
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, context.getPackageName() + "/cache/image/");
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return DiskLruCacheWrapper.get(cacheDir, MAX_DISK_CACHE_SIZE);
    }

    /**
     * ************************ Memory Cache ************************
     */
    @SuppressWarnings("deprecation")
    static void clearMemoryCache(Context context) {
        Glide.get(context).clearMemory();
    }

    /**
     * ************************ GlideModule override ************************
     */
    @Override
    @SuppressWarnings("deprecation")
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDiskCache(new DiskCache.Factory() {
            @Override
            public DiskCache build() {
                return getDiskCache();
            }
        });

        LogUtil.i(TAG, "NIMGlideModule apply options");
    }

    @Override
    @SuppressWarnings("deprecation")
    public void registerComponents(Context context, Glide glide, Registry registry) {

    }
}
