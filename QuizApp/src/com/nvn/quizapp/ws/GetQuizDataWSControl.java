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
import android.location.Address;

import com.nvn.quizapp.Objects.Answer;
import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.Objects.Question;
import com.nvn.quizapp.Objects.Quiz;
import com.nvn.quizapp.Objects.Subject;
import com.nvn.quizapp.utils.NetworkUtils;
import com.nvn.quizapp.utils.Statics;

@SuppressLint("SimpleDateFormat")
public class GetQuizDataWSControl extends BaseWSControl {
	private String quizId;

	public GetQuizDataWSControl(Context context,
			WebServiceCommunicatorListener listener, String quizId) {
		super(context, listener, WebServiceFlag.GET_QUIZ_DATA);
		this.quizId = quizId;

	}

	@Override
	protected Object doInBackground(Void... params) {
		// Get local database

		String url = Statics.WS_LINK + quizId;
		LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();

		try {
			String respone = NetworkUtils.doRequest(url, headers);
			try {
				JSONObject jsonObject = new JSONObject(respone);
				return getDataFromJSONObject(jsonObject);

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

	public Quiz getDataFromJSONObject(
			JSONObject jsonObject) throws JSONException {
		Quiz quiz = new Quiz();
		
		quiz.setActive(Statics.getBoolean(jsonObject, "is_active"));
		quiz.setAppIcon(Statics.getString(jsonObject, "application_icon"));
		quiz.setAppImg(Statics.getString(jsonObject, "application_image"));
		quiz.setName(Statics.getString(jsonObject, "name"));
		
		// Set Exams
		JSONArray examJSONArray = Statics.getJSONArray(jsonObject, "exams");
		ArrayList<Exam> exams = new ArrayList<Exam>();
		for (int i = 0; i < examJSONArray.length(); i++) {
			JSONObject job = examJSONArray.getJSONObject(i);
			Exam exam = new Exam();
			
			exam.setActive(Statics.getBoolean(job, "is_active"));
			exam.setFirstBadgeImg(Statics.getString(job, "badge_1_image"));
			exam.setFirstBadgeName(Statics.getString(job, "bagde_1_name"));
			exam.setImgUrl(Statics.getString(job, "exam_image_url"));
			exam.setLimitTime(Statics.getString(job, "time_limit_exam"));
			exam.setPrice(Statics.getDouble(job, "exam_price_google"));
			exam.setSecondBadgeImg(Statics.getString(job, "badge_2_image"));
			exam.setSecondBadgeName(Statics.getString(job, "bagde_2_name"));
			exam.setThirdBadgeImg(Statics.getString(job, "badge_3_image"));
			exam.setThirdBadgeName(Statics.getString(job, "bagde_3_name"));
			exam.setTitle(Statics.getString(job, "title"));
			
			// Set Subjects
			JSONArray subjectJSONArray = Statics.getJSONArray(job, "subjects");
			ArrayList<Subject> subjects = new ArrayList<Subject>();
			for (int j = 0; j < subjectJSONArray.length(); j++) {
				JSONObject jobSub = subjectJSONArray.getJSONObject(j);
				Subject subject = new Subject();
				
				subject.setActive(Statics.getBoolean(jobSub, "is_active"));
				subject.setTitle(Statics.getString(jobSub, "title"));
				// Set Questions
				JSONArray questionJSONArray = Statics.getJSONArray(jobSub, "questions");
				ArrayList<Question> questions = new ArrayList<Question>();
				for (int k = 0; k < questionJSONArray.length(); k++) {
					JSONObject jobQuest = questionJSONArray.getJSONObject(k);
					Question quest = new Question();
					
					quest.setActive(Statics.getBoolean(jobQuest, "is_active"));
					quest.setText(Statics.getString(jobQuest, "question"));
					quest.setUrl(Statics.getString(jobQuest, "question_attribute_url"));
					
					// Set Answers
					JSONArray answerJSONArray = Statics.getJSONArray(jobQuest, "answers");
					ArrayList<Answer> answers = new ArrayList<Answer>();
					for (int l = 0; l < answerJSONArray.length(); l++) {
						JSONObject jobAnswer = answerJSONArray.getJSONObject(l);
						Answer answer = new Answer();
						
						answer.setActive(Statics.getBoolean(jobAnswer, "is_active"));
						answer.setCorrect(Statics.getBoolean(jobAnswer, "is_correct"));
						quest.setText(Statics.getString(jobAnswer, "answer"));
						
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
			
			// Add array subject to exam
			exam.setSubjects(subjects);
			
			// Add exam to array exams
			exams.add(exam);
		}
		
		// Add array exams to quiz
		quiz.setExams(exams);
		
		
		return quiz;
	}
}
