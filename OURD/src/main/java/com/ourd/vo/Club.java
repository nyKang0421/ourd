package com.ourd.vo;

public class Club {
	int num;
	String name;
	int keeper;
	
	public Club(String name, int keeper) {
		this.name = name;
		this.keeper = keeper;
	}
	public Club(int num, String name, int keeper) {
		this.num = num;
		this.name = name;
		this.keeper = keeper;
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
	public int getKeeper() {
		return keeper;
	}
	public void setKeeper(int keeper) {
		this.keeper = keeper;
	}

	@Override
	public String toString() {
		return "Club [num=" + num + ", name=" + name + ", keeper=" + keeper + "]";
	}
	
}
