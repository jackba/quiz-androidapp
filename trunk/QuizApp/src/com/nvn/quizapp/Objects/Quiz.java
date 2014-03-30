package com.nvn.quizapp.Objects;

import java.util.ArrayList;

public class Quiz {
	private String name;
	private String appIcon;
	private String appImg;
	private boolean isActive;
	ArrayList<Exam> exams;
	
	public Quiz() {
		// TODO Auto-generated constructor stub
	}
	
	public Quiz(String name, String appIcon, String appImg, boolean isActive,
			ArrayList<Exam> exams) {
		this.name = name;
		this.appIcon = appIcon;
		this.appImg = appImg;
		this.isActive = isActive;
		this.exams = exams;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the appIcon
	 */
	public String getAppIcon() {
		return appIcon;
	}
	/**
	 * @param appIcon the appIcon to set
	 */
	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon;
	}
	/**
	 * @return the appImg
	 */
	public String getAppImg() {
		return appImg;
	}
	/**
	 * @param appImg the appImg to set
	 */
	public void setAppImg(String appImg) {
		this.appImg = appImg;
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
	 * @return the exams
	 */
	public ArrayList<Exam> getExams() {
		return exams;
	}
	/**
	 * @param exams the exams to set
	 */
	public void setExams(ArrayList<Exam> exams) {
		this.exams = exams;
	}
	
	
}
