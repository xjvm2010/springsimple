package com.simple.www.vo;

import java.sql.*;

public class FileVO {
	private int pno;
	private int mno;
	private String oriName;
	private String saveName;
	private long len;
	private String dir;
	
	private Date pDate;
	private Time pTime;
	
	
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	public Time getpTime() {
		return pTime;
	}
	public void setpTime(Time pTime) {
		this.pTime = pTime;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public long getLen() {
		return len;
	}
	public void setLen(long len) {
		this.len = len;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
//		this.dir = dir;
		this.dir = "/resources/upload";
	}
	
	
}
