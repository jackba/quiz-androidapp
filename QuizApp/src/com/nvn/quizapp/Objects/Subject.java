package com.nvn.quizapp.Objects;

import java.util.ArrayList;

public class Subject {
	private String title;
	private boolean isActive;
	private ArrayList<Question> questions;
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}
	
	public Subject(String title, boolean isActive, ArrayList<Question> questions) {
		this.title = title;
		this.isActive = isActive;
		this.questions = questions;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the questions
	 */
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	
}
