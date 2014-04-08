package com.nvn.quizapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AsImageView extends ImageView {

	public AsImageView(Context context) {
		super(context);
	}

	public AsImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AsImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int width = getMeasuredWidth();
		// int height = (int) (width * 0.726f);
		setMeasuredDimension(width, width * 2 / 3);
	}

}
