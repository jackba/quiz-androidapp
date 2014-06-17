package com.nvn.quizapp.applications;

import java.io.File;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

public class QuizApplication extends Application {

	public static int SCREEN_WIDTH = 0;
	public static int SCREEN_HEIGHT = 0;

	@Override
	public void onCreate() {
		super.onCreate();
		
		WindowManager windowManager = (WindowManager) getApplicationContext()
				.getSystemService(Context.WINDOW_SERVICE);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			Point size = new Point();
			windowManager.getDefaultDisplay().getSize(size);
			SCREEN_WIDTH = size.x;
			SCREEN_HEIGHT = size.y;
		} else {
			Display d = windowManager.getDefaultDisplay();
			SCREEN_WIDTH = d.getWidth();
			SCREEN_HEIGHT = d.getHeight();
		}
		
		File cacheDir = StorageUtils.getCacheDirectory(getApplicationContext());
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext())
				.memoryCacheExtraOptions(SCREEN_WIDTH, SCREEN_HEIGHT)
				.discCacheExtraOptions(SCREEN_WIDTH * 2, SCREEN_HEIGHT * 2,
						CompressFormat.JPEG, 100, null)
				.threadPoolSize(3)
				.threadPriority(Thread.NORM_PRIORITY - 1)
				.denyCacheImageMultipleSizesInMemory()
				.memoryCache(new LruMemoryCache(2 * 1024 * 1024))
				.memoryCacheSize(2 * 1024 * 1024)
				.discCache(new UnlimitedDiscCache(cacheDir))
				.discCacheSize(100 * 1024 * 1024)
				.discCacheFileCount(1000)
				.discCacheFileNameGenerator(new HashCodeFileNameGenerator())
				.imageDownloader(
						new BaseImageDownloader(getApplicationContext())) // default
				.tasksProcessingOrder(QueueProcessingType.FIFO) // default
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
				.writeDebugLogs().build();
		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
	}

	@Override
	public void onLowMemory() {
		ImageLoader.getInstance().clearMemoryCache();
		super.onLowMemory();
	}
}
