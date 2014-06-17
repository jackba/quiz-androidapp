package com.nvn.quizapp.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.content.Context;

import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.utils.NetworkUtils;
import com.nvn.quizapp.utils.Statics;

@SuppressLint("SimpleDateFormat")
public class GetExamDataWSControl extends BaseWSControl {

	public GetExamDataWSControl(Context context,
			WebServiceCommunicatorListener listener) {
		super(context, listener, WebServiceFlag.GET_EXAM_DATA);
	}

	@Override
	protected Object doInBackground(Void... params) {
		// Get local database

		String url = Statics.WS_EXAMS;
		LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();

		try {
			String respone = NetworkUtils.doRequest(url, headers);
			try {
				JSONArray jsonArray = new JSONArray(respone);
				return getDataFromJSONArray(jsonArray);

			} catch (JSONException e) {
				mError = e.getMessage();
			}

		} catch (ClientProtocolException e) {
			mError = "Cannot connect to network";
			e.printStackTrace();
		} catch (IOException e) {
			mError = "Cannot connect to network";
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Exam> getDataFromJSONArray(
			JSONArray examJSONArray) throws JSONException {
		
		ArrayList<Exam> exams = new ArrayList<Exam>();
		for (int i = 0; i < examJSONArray.length(); i++) {
			JSONObject job = examJSONArray.getJSONObject(i);
			Exam exam = new Exam();
			
			exam.setID(Statics.getInt(job, "id"));
			exam.setActive(Statics.getBoolean(job, "is_active"));
			exam.setFirstBadgeImg(Statics.HOST + Statics.getString(job, "badge_1_image"));
			exam.setFirstBadgeName(Statics.getString(job, "bagde_1_name"));
			exam.setSecondBadgeImg(Statics.HOST + Statics.getString(job, "badge_2_image"));
			exam.setSecondBadgeName(Statics.getString(job, "bagde_2_name"));
			exam.setThirdBadgeImg(Statics.HOST + Statics.getString(job, "badge_3_image"));
			exam.setThirdBadgeName(Statics.getString(job, "bagde_3_name"));
			exam.setImgUrl(Statics.HOST + Statics.getString(job, "exam_image_url"));
			exam.setTimeExam(Statics.getInt(job, "time_limit_exam"));
			exam.setNoCorrectAnswer(Statics.getInt(job, "no_correct_answers"));
			exam.setTimeQuestion(Statics.getInt(job, "time_limit_questions"));
			exam.setPrice(Statics.getDouble(job, "exam_price_google"));
			exam.setTitle(Statics.getString(job, "title"));
			
			// Add exam to array exams
			exams.add(exam);
		}
		
		return exams;
	}
	
	
}
