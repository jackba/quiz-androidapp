package com.nvn.quizapp.Objects;

import java.util.ArrayList;

public class Exam {
	private int ID;
	private String title;
	private int timeExam, timeQuestion, noCorrectAnswer;
	private double price;
	private boolean isActive;
	private String imgUrl;
	private String firstBadgeName;
	private String firstBadgeImg;
	private String secondBadgeName;
	private String secondBadgeImg;
	private String thirdBadgeName;
	private String thirdBadgeImg;
	private ArrayList<Subject> subjects;
	
	public Exam() {
		// TODO Auto-generated constructor stub
	}

	
	
	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTimeExam() {
		return timeExam;
	}

	public void setTimeExam(int timeExam) {
		this.timeExam = timeExam;
	}

	public int getTimeQuestion() {
		return timeQuestion;
	}

	public void setTimeQuestion(int timeQuestion) {
		this.timeQuestion = timeQuestion;
	}

	public int getNoCorrectAnswer() {
		return noCorrectAnswer;
	}

	public void setNoCorrectAnswer(int noCorrectAnswer) {
		this.noCorrectAnswer = noCorrectAnswer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getFirstBadgeName() {
		return firstBadgeName;
	}

	public void setFirstBadgeName(String firstBadgeName) {
		this.firstBadgeName = firstBadgeName;
	}

	public String getFirstBadgeImg() {
		return firstBadgeImg;
	}

	public void setFirstBadgeImg(String firstBadgeImg) {
		this.firstBadgeImg = firstBadgeImg;
	}

	public String getSecondBadgeName() {
		return secondBadgeName;
	}

	public void setSecondBadgeName(String secondBadgeName) {
		this.secondBadgeName = secondBadgeName;
	}

	public String getSecondBadgeImg() {
		return secondBadgeImg;
	}

	public void setSecondBadgeImg(String secondBadgeImg) {
		this.secondBadgeImg = secondBadgeImg;
	}

	public String getThirdBadgeName() {
		return thirdBadgeName;
	}

	public void setThirdBadgeName(String thirdBadgeName) {
		this.thirdBadgeName = thirdBadgeName;
	}

	public String getThirdBadgeImg() {
		return thirdBadgeImg;
	}

	public void setThirdBadgeImg(String thirdBadgeImg) {
		this.thirdBadgeImg = thirdBadgeImg;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
}
