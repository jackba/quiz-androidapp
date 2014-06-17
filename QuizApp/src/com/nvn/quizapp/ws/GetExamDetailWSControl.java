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

import com.nvn.quizapp.Objects.Answer;
import com.nvn.quizapp.Objects.Question;
import com.nvn.quizapp.Objects.Subject;
import com.nvn.quizapp.utils.NetworkUtils;
import com.nvn.quizapp.utils.Statics;

@SuppressLint("SimpleDateFormat")
public class GetExamDetailWSControl extends BaseWSControl {
	private int examId;
	public GetExamDetailWSControl(Context context,
			WebServiceCommunicatorListener listener, int examId) {
		super(context, listener, WebServiceFlag.GET_EXAM_DETAIL);
		this.examId = examId;
	}

	@Override
	protected Object doInBackground(Void... params) {
		// Get local database

		String url = Statics.WS_EXAM_DETAIL + examId;
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

	public ArrayList<Subject> getDataFromJSONArray(
			JSONArray subjectJSONArray) throws JSONException {
		
		// Set Subjects
		ArrayList<Subject> subjects = new ArrayList<Subject>();
		for (int j = 0; j < subjectJSONArray.length(); j++) {
			JSONObject jobSub = subjectJSONArray.getJSONObject(j);
			Subject subject = new Subject();
			
			subject.setID(Statics.getInt(jobSub, "id"));
			subject.setTitle(Statics.getString(jobSub, "title"));
			
			// Set Questions
			JSONArray questionJSONArray = Statics.getJSONArray(jobSub, "questions");
			ArrayList<Question> questions = new ArrayList<Question>();
			for (int k = 0; k < questionJSONArray.length(); k++) {
				JSONObject jobQuest = questionJSONArray.getJSONObject(k);
				Question quest = new Question();
				
				quest.setID(Statics.getInt(jobQuest, "id"));
				quest.setType(Statics.getInt(jobQuest, "type"));
				quest.setActive(Statics.getBoolean(jobQuest, "is_active"));
				quest.setText(Statics.getString(jobQuest, "question"));
				quest.setUrl(Statics.HOST + Statics.getString(jobQuest, "question_attribute_url"));
				quest.setCreatedDate(Statics.getString(jobQuest, "created"));
				
				// Set Answers
				JSONArray answerJSONArray = Statics.getJSONArray(jobQuest, "answers");
				ArrayList<Answer> answers = new ArrayList<Answer>();
				for (int l = 0; l < answerJSONArray.length(); l++) {
					JSONObject jobAnswer = answerJSONArray.getJSONObject(l);
					Answer answer = new Answer();
					
					answer.setID(Statics.getInt(jobAnswer, "id"));
					answer.setActive(Statics.getBoolean(jobAnswer, "is_active"));
					answer.setCorrect(Statics.getBoolean(jobAnswer, "is_correct"));
					quest.setText(Statics.getString(jobAnswer, "answer"));
					quest.setCreatedDate(Statics.getString(jobAnswer, "created"));
					
					// Add answer to array answers
					answers.add(answer);
				}
				
				// Add array answer to question
				quest.setAnswers(answers);
				
				// Add question to array questions
				questions.add(quest);
				
			}
			
			// Add array question to subject
			subject.setQuestions(questions);
			
			// Add subject to array subjects
			subjects.add(subject);
				
		}
		
		return subjects;
	}
}
