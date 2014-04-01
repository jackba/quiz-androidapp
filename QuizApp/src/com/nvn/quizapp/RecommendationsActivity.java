package com.nvn.quizapp;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class RecommendationsActivity extends BaseActivity {
	private SeekBar mSbActors, mSbGeography, mSbFastFood;
	int oldProgressBarActors, oldProgressBarGeography, oldProgessBarFastFood;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommendations);
		initViews();
		initProperties();
		initListeners();
	}

	@Override
	public void initViews() {
		mSbActors = (SeekBar) findViewById(R.id.sb_actors);
		mSbGeography = (SeekBar) findViewById(R.id.sb_geography);
		mSbFastFood = (SeekBar) findViewById(R.id.sb_fast_food);
	}

	@Override
	public void initListeners() {
		mSbActors.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				seekBar.setProgress(oldProgressBarActors);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				oldProgressBarActors = seekBar.getProgress();
				seekBar.setProgress(oldProgressBarActors);
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				seekBar.setProgress(oldProgressBarActors);
			}
		});
		mSbGeography.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				seekBar.setProgress(oldProgressBarGeography);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				oldProgressBarGeography = seekBar.getProgress();
				seekBar.setProgress(oldProgressBarGeography);
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				seekBar.setProgress(oldProgressBarGeography);
			}
		});
		mSbFastFood.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				seekBar.setProgress(oldProgessBarFastFood);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				oldProgessBarFastFood = seekBar.getProgress();
				seekBar.setProgress(oldProgessBarFastFood);
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				seekBar.setProgress(oldProgessBarFastFood);
			}
		});
	}

	@Override
	public void initProperties() {

	}

}
