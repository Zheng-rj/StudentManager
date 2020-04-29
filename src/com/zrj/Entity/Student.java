package com.zrj.Entity;


public class Student{
	private String sid;
	private String sname;
	private String ssex;
	private String sphone;
	private String smajor;
	
	public Student() {
		super();
	}

	public Student(String sname, String ssex, String sphone, String smajor) {
		super();
		this.sname = sname;
		this.ssex = ssex;
		this.sphone = sphone;
		this.smajor = smajor;
	}

	public Student(String sid, String sname, String ssex, String sphone,String smajor) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.ssex = ssex;
		this.sphone = sphone;
		this.smajor = smajor;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getSmajor() {
		return smajor;
		
	}
	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", ssex=" + ssex + ", sphone=" + sphone + ", smajor="
				+ smajor + "]";
	}

	
}
