package com.zrj.Dao.imp;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import com.zrj.Dao.StudentDao;
import com.zrj.Entity.Student;
import com.zrj.utils.HibernateUtils;

public class StudentDaoImp implements StudentDao{

	@Override
	public List<Student> selectAll(Query query) {
		List<Student> list = query.list();
		return list;
	}

	@Override
	public List<Student> selectByPage(Query query) {
		List list = query.list();
		return list;
	}

	@Override
	public Student selectOne(String id) {
		return HibernateUtils.get(Student.class, id);
	}

	@Override
	public void update(Session session, Student stu) {
		session.update(stu);
	}

	public void delete(Session session, Student student) {
		session.delete(student);
	}
	
	public void insert(Session session, Student student) {
		session.save(student);
	}

}
