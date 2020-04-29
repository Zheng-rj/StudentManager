package com.zrj.Dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import com.zrj.Entity.Student;

public interface StudentDao {
	public List<Student> selectAll(Query query);
	
	public List<Student> selectByPage(Query query);
	
	public Student selectOne(String id);
	
	public void update(Session session, Student stu);

}
