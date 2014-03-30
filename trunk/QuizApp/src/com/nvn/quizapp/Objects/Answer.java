package com.nvn.quizapp.Objects;

public class Answer {
	private String text;
	private boolean isCorrect;
	private boolean isActive;
	
	public Answer() {
		// TODO Auto-generated constructor stub
	}
	
	public Answer(String text, boolean isCorrect, boolean isActive) {
		this.text = text;
		this.isCorrect = isCorrect;
		this.isActive = isActive;
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
	 * @return the isCorrect
	 */
	public boolean isCorrect() {
		return isCorrect;
	}
	/**
	 * @param isCorrect the isCorrect to set
	 */
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
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
	
	
}
