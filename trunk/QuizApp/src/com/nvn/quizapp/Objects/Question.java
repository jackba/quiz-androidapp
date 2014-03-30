package com.nvn.quizapp.Objects;

import java.util.ArrayList;

public class Question {
	private String text;
	private boolean isActive;
	private String url;
	private ArrayList<Answer> answers;
	public Question(String text, boolean isActive, String url,
			ArrayList<Answer> answers) {
		this.text = text;
		this.isActive = isActive;
		this.url = url;
		this.answers = answers;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the answers
	 */
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
	
	
}
