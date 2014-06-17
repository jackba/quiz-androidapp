package com.nvn.quizapp.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nvn.quizapp.R;
import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.utils.Statics;

public class ExamsAdapter extends ArrayAdapter<Exam> {

	private Activity activity;
	private List<Exam> items;
	private int row;
	private DisplayImageOptions options;

	public ExamsAdapter(Activity act, int resource, List<Exam> arrayList) {
		super(act, resource, arrayList);
		this.activity = act;
		this.row = resource;
		this.items = arrayList;
		
		options = new DisplayImageOptions.Builder()
		.showImageOnLoading(R.drawable.no_image)
		.showImageForEmptyUri(R.drawable.no_image)
		.showImageOnFail(R.drawable.no_image).cacheInMemory(true)
		.cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).build();
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(row, null);
			holder = new ViewHolder();
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		Exam objBean = items.get(position);

		holder.imgExams = (ImageView) view.findViewById(R.id.imv_exams);
		holder.tvTitleExams = (TextView) view.findViewById(R.id.tv_title_exams);
		holder.tvNumberQuestion = (TextView) view
				.findViewById(R.id.tv_number_question);
		holder.tvTimeLimit = (TextView) view.findViewById(R.id.tv_time_exams);
		holder.layoutPurchased = view.findViewById(R.id.layout_purchase);
		holder.layoutPreview = view.findViewById(R.id.layout_preview);
		
		
		holder.tvTitleExams.setText(objBean.getTitle());
		holder.tvNumberQuestion.setText(objBean.getNoCorrectAnswer()+" questions");
		holder.tvTimeLimit.setText(Statics.time2String(objBean.getTimeExam()));
		ImageLoader.getInstance().displayImage(objBean.getImgUrl(), holder.imgExams, options);
		
		if(objBean.isActive()){
			holder.layoutPurchased.setVisibility(View.VISIBLE);
			holder.layoutPreview.setVisibility(View.GONE);
		}else{
			holder.layoutPurchased.setVisibility(View.GONE);
			holder.layoutPreview.setVisibility(View.VISIBLE);
		}
		
		return view;
	}

	@Override
	public int getCount() {
		return items.size();
	}
	
	public class ViewHolder {
		public TextView tvTitleExams, tvNumberQuestion, tvTimeLimit;
		public ImageView imgExams;
		public View layoutPurchased, layoutPreview;
	}
}