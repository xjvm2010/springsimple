package com.simple.www.vo;

import java.sql.Date;
import java.sql.Time;

import org.springframework.web.multipart.MultipartFile;

public class GalleryVO {
	private int gno;
	private int gmno;
	private String oriName;
	private String saveName;
	private long len;
	private String dir;
	
	private String id;
	
	private String title;
	private String body;
	
	private Date gdate;
	private Time gtime;
	
	private String gisshow;
	
	private MultipartFile sFile;
	private MultipartFile[] file;
	
	@Override
	public String toString() {
		return "GalleryVO -"
				+"\n oriname : " + oriName
				+"\n savename : "+ saveName
				+"\n len : " + len
				+"\n dir : " + dir
				+"\n id : "+ id
				+"\n title : "+ title
				+"\n body : "+ body;
	}
	
	
	public MultipartFile getsFile() {
		return sFile;
	}
	public void setsFile(MultipartFile sFile) {
		this.sFile = sFile;
	}
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFile(MultipartFile[] file) {
		this.file = file;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getGisshow() {
		return gisshow;
	}
	public void setGisshow(String gisshow) {
		this.gisshow = gisshow;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public int getGmno() {
		return gmno;
	}
	public void setGmno(int gmno) {
		this.gmno = gmno;
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
	public Date getGdate() {
		return gdate;
	}
	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	public Time getGtime() {
		return gtime;
	}
	public void setGtime(Time gtime) {
		this.gtime = gtime;
	}
	
	
}
