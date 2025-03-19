package com.ourd.vo;

public class User {
	int num;
	String name;
	String nickname;
	String birth;
	String id;
	String pw;
	String email;
	String tel;
	
	public User(int num, String name, String nickname, String birth, String id, String pw, String email, String tel) {
		this.num = num;
		this.name = name;
		this.nickname = nickname;
		this.birth = birth;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.tel = tel;
	}
	public User(String name, String nickname, String birth, String id, String pw, String email, String tel) {
		this.name = name;
		this.nickname = nickname;
		this.birth = birth;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.tel = tel;
	}
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "User [num=" + num + ", name=" + name + ", nickname=" + nickname + ", birth=" + birth + ", id=" + id
				+ ", pw=" + pw + ", email=" + email + ", tel=" + tel + "]";
	}
	

}
