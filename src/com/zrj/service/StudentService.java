package com.zrj.service;

import java.util.List;

import com.zrj.Entity.Student;

public interface StudentService {
	public List<Student> selectAll();
	
	public List<Student> selectByPage(int page);
	
	public Student selectOneByQuery(String id);
	
	public void update(String ssex, String sphone, String smajor, String sid);
	
	public void delete(String id);
	
	public void insert(String sid, String sname, String ssex, String sphone, String smajor);
}
