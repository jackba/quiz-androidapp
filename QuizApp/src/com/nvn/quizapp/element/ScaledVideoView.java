package com.nvn.quizapp.element;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class ScaledVideoView extends VideoView {

	public ScaledVideoView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public ScaledVideoView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public ScaledVideoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int width = getMeasuredWidth();
		setMeasuredDimension(width, width * 2 / 3);
	}

}
