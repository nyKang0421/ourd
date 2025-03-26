package com.ourd.vo;

public class Message {
	int num;
	int club;
	int send;
	int take;
	int state;
	// state : 0_신청 1_초대 5_수락 6_거절
	
	public Message(int num, int club, int send, int take, int state) {
		this.num = num;
		this.club = club;
		this.send = send;
		this.take = take;
		this.state = state;
	}
	
	public Message(int club, int send, int take, int state) {
		super();
		this.club = club;
		this.send = send;
		this.take = take;
		this.state = state;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getClub() {
		return club;
	}
	public void setClub(int club) {
		this.club = club;
	}
	public int getSend() {
		return send;
	}
	public void setSend(int send) {
		this.send = send;
	}
	public int getTake() {
		return take;
	}
	public void setTake(int take) {
		this.take = take;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Message [num=" + num + ", club=" + club + ", send=" + send + ", take=" + take + ", state=" + state
				+ "]";
	}
	
}
