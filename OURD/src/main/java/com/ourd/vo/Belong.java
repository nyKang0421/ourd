package com.ourd.vo;

public class Belong {
	int num;
	int club;
	int keeper;
	int member;
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
	public int getKeeper() {
		return keeper;
	}
	public void setKeeper(int keeper) {
		this.keeper = keeper;
	}
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "Belong [num=" + num + ", club=" + club + ", keeper=" + keeper + ", member=" + member + "]";
	}
	
	
	
}
