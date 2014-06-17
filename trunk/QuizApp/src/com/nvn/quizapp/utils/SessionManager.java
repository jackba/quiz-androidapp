package com.nvn.quizapp.utils;

import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.Objects.Quiz;

public class SessionManager {
	private static SessionManager mSessionManager;
	private static final String PREFS_FILE = "com.nvn.quizapp";
	private ArrayList<Exam> exams = new ArrayList<Exam>();
	private Exam curExam = new Exam();
	
	public static SessionManager getSessionManager() {
		if (mSessionManager == null) {
			mSessionManager = new SessionManager();
		}
		return mSessionManager;
	}

	public static void destroySession() {
		mSessionManager = null;
	}

	public static void clear(Context context) {
		SharedPreferences pref = context.getSharedPreferences(PREFS_FILE,
				Context.MODE_PRIVATE);
		Editor editor = pref.edit();
		editor.clear();
		editor.commit();
	}

	

	public ArrayList<Exam> getExams() {
		return exams;
	}

	public void setExams(ArrayList<Exam> exams) {
		this.exams = exams;
	}

	/**
	 * @return the curExam
	 */
	public Exam getCurExam() {
		return curExam;
	}

	/**
	 * @param curExam the curExam to set
	 */
	public void setCurExam(Exam curExam) {
		this.curExam = curExam;
	}

	
	
}
