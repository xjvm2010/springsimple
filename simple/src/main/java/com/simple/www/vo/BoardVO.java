package com.simple.www.vo;

import java.sql.*;
import java.text.SimpleDateFormat;

public class BoardVO {
	private int bno;
	private int mno;
	private String id;
	private String title;
	private String bbody;
	private Date bdate;
	private String sdate;
	private Time btime;
	private String stime;
	private String isshow;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBbody() {
		return bbody;
	}
	public void setBbody(String bbody) {
		this.bbody = bbody;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
		setSdate();
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	public void setSdate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		this.sdate = form.format(bdate);
	}
	
	public Time getBtime() {
		return btime;
	}
	public void setBtime(Time btime) {
		this.btime = btime;
		setStime();
	}
	public String getStime() {
		return stime;
		
	}
	
	public void setStime(String stime) {
		this.stime = stime;
	}
	
	public void setStime() {
		SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
		this.stime = form.format(btime);
	}
	
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	
	
}
