package com.nvn.quizapp.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Statics {
	// App's configuration
	public static String APP_NAME = "VCA EXAMEN";
	//
	//
	
	
	public static String QUIZ_ID = "1";
	public static String HOST = "http://effective-task-522.appspot.com/";
	public static String WS_EXAMS = HOST + "api/exam/?app_id="+QUIZ_ID;
	public static String WS_EXAM_DETAIL = HOST + "api/subject/?exam_id=";

	public static void showToast(Context ctx, String txt) {
		Toast.makeText(ctx, txt, Toast.LENGTH_SHORT).show();
	}

	public static boolean isNetworkConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if (ni != null && ni.isConnected()) {
			return true;
		}
		return false;
	}

	public static boolean isEmailValid(String email) {
		return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
	}

	public static int PixelFromDp(Context context, int dp) {
		return (int) (dp * context.getResources().getDisplayMetrics().density);
	}

	public static String getString(JSONObject json, String key)
			throws JSONException {
		if (json.has(key)) {
			return json.getString(key);
		}
		return "";
	}

	public static int getInt(JSONObject json, String key) throws JSONException {
		if (json.has(key)) {
			return json.getInt(key);
		}
		return 0;
	}

	public static double getDouble(JSONObject json, String key)
			throws JSONException {
		if (json.has(key)) {
			return json.getDouble(key);
		}
		return 0;
	}

	public static long getLong(JSONObject json, String key)
			throws JSONException {
		if (json.has(key)) {
			return json.getLong(key);
		}
		return 0;
	}

	public static boolean getBoolean(JSONObject json, String key)
			throws JSONException {
		if (json.has(key)) {
			return json.getBoolean(key);
		}
		return false;
	}

	public static JSONObject getJSONObject(JSONObject json, String key)
			throws JSONException {
		if (json.has(key)) {
			return json.getJSONObject(key);
		}
		return new JSONObject();
	}
	
	public static JSONArray getJSONArray(JSONObject json, String key)
			throws JSONException {
		if (json.has(key)) {
			return json.getJSONArray(key);
		}
		return new JSONArray();
	}
	
	public static String time2String(int time){
		String str = "";
		int hour = time/60;
		int min = time%60;
		
		if(hour > 0){
			str += (hour > 1) ? (hour + " hours ") : (hour + " hour ");
		}
		
		if(min > 0){
			str += (min > 1) ? (min + " minutes ") : (min + " minute ");
		}
		
		return str;
	}
}
