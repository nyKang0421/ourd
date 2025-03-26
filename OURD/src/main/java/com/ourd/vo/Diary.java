package com.ourd.vo;

public class Diary {
	int num;
	int writer;
	int club;
	String title;
	String content;
	String feel;
	String weather;
	String img;
	String date;
	public Diary(int num, int writer, int club, String title, String content, String feel, String weather, String img,
			String date) {
		this.num = num;
		this.writer = writer;
		this.club = club;
		this.title = title;
		this.content = content;
		this.feel = feel;
		this.weather = weather;
		this.img = img;
		this.date = date;
	}
	public Diary(int writer, int club, String title, String content, String feel, String weather, String img,
			String date) {
		this.writer = writer;
		this.club = club;
		this.title = title;
		this.content = content;
		this.feel = feel;
		this.weather = weather;
		this.img = img;
		this.date = date;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public int getClub() {
		return club;
	}
	public void setClub(int club) {
		this.club = club;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFeel() {
		return feel;
	}
	public void setFeel(String feel) {
		this.feel = feel;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Diary [num=" + num + ", writer=" + writer + ", club=" + club + ", title=" + title + ", content="
				+ content + ", feel=" + feel + ", weather=" + weather + ", img=" + img + ", date=" + date + "]";
	}
	
	
	
	
	
}
