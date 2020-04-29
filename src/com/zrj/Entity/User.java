package com.zrj.Entity;

public class User {
	private int uid;
	private String uname;
	private String uimg;
	private String uphone;
	private String usex;
	private String upwd;
	
	public User() {
		super();
	}

	public User(String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}

	public User(String uname, String uimg, String uphone, String usex, String upwd) {
		super();
		this.uname = uname;
		this.uimg = uimg;
		this.uphone = uphone;
		this.usex = usex;
		this.upwd = upwd;
	}

	public User(int uid, String uname, String uimg, String uphone, String usex, String upwd) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uimg = uimg;
		this.uphone = uphone;
		this.usex = usex;
		this.upwd = upwd;
		
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUimg() {
		return uimg;
	}

	public void setUimg(String uimg) {
		this.uimg = uimg;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uimg=" + uimg + ", uphone=" + uphone + ", usex=" + usex
				+ ", upwd=" + upwd + "]";
	}
}
