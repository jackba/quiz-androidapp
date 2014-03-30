package com.nvn.quizapp.Objects;

import java.util.ArrayList;

public class Exam {
	private String title;
	private String limitTime;
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
	
	public Exam(String title, String limitTime, double price, boolean isActive,
			String imgUrl, String firstBadgeName, String firstBadgeImg,
			String secondBadgeName, String secondBadgeImg,
			String thirdBadgeName, String thirdBadgeImg,
			ArrayList<Subject> subjects) {
		this.title = title;
		this.limitTime = limitTime;
		this.price = price;
		this.isActive = isActive;
		this.imgUrl = imgUrl;
		this.firstBadgeName = firstBadgeName;
		this.firstBadgeImg = firstBadgeImg;
		this.secondBadgeName = secondBadgeName;
		this.secondBadgeImg = secondBadgeImg;
		this.thirdBadgeName = thirdBadgeName;
		this.thirdBadgeImg = thirdBadgeImg;
		this.subjects = subjects;
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
	 * @return the limitTime
	 */
	public String getLimitTime() {
		return limitTime;
	}

	/**
	 * @param limitTime the limitTime to set
	 */
	public void setLimitTime(String limitTime) {
		this.limitTime = limitTime;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
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
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * @param imgUrl the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	/**
	 * @return the firstBadgeName
	 */
	public String getFirstBadgeName() {
		return firstBadgeName;
	}

	/**
	 * @param firstBadgeName the firstBadgeName to set
	 */
	public void setFirstBadgeName(String firstBadgeName) {
		this.firstBadgeName = firstBadgeName;
	}

	/**
	 * @return the firstBadgeImg
	 */
	public String getFirstBadgeImg() {
		return firstBadgeImg;
	}

	/**
	 * @param firstBadgeImg the firstBadgeImg to set
	 */
	public void setFirstBadgeImg(String firstBadgeImg) {
		this.firstBadgeImg = firstBadgeImg;
	}

	/**
	 * @return the secondBadgeName
	 */
	public String getSecondBadgeName() {
		return secondBadgeName;
	}

	/**
	 * @param secondBadgeName the secondBadgeName to set
	 */
	public void setSecondBadgeName(String secondBadgeName) {
		this.secondBadgeName = secondBadgeName;
	}

	/**
	 * @return the secondBadgeImg
	 */
	public String getSecondBadgeImg() {
		return secondBadgeImg;
	}

	/**
	 * @param secondBadgeImg the secondBadgeImg to set
	 */
	public void setSecondBadgeImg(String secondBadgeImg) {
		this.secondBadgeImg = secondBadgeImg;
	}

	/**
	 * @return the thirdBadgeName
	 */
	public String getThirdBadgeName() {
		return thirdBadgeName;
	}

	/**
	 * @param thirdBadgeName the thirdBadgeName to set
	 */
	public void setThirdBadgeName(String thirdBadgeName) {
		this.thirdBadgeName = thirdBadgeName;
	}

	/**
	 * @return the thirdBadgeImg
	 */
	public String getThirdBadgeImg() {
		return thirdBadgeImg;
	}

	/**
	 * @param thirdBadgeImg the thirdBadgeImg to set
	 */
	public void setThirdBadgeImg(String thirdBadgeImg) {
		this.thirdBadgeImg = thirdBadgeImg;
	}

	/**
	 * @return the subjects
	 */
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
}
