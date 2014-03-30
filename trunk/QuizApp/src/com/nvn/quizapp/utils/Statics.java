package com.nvn.quizapp.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Statics {
	public static String QUIZ_ID = "1234";
	public static String WS_LINK = "http://effective-task-522.appspot.com/exam_app/api/get_data/";

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
}
