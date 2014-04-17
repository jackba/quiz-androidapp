package com.nvn.quizapp.element;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ScaledImageView extends ImageView {

	public ScaledImageView(Context context) {
		super(context);
	}

	public ScaledImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ScaledImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int width = getMeasuredWidth();
		int height = (int) (width * 0.726f);
		setMeasuredDimension(width, height);
	}
}
