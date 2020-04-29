package com.zrj.service.imp;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zrj.Dao.imp.StudentDaoImp;
import com.zrj.Entity.Student;
import com.zrj.service.StudentService;
import com.zrj.utils.HibernateUtils;

public class StudentServiceImp implements StudentService {

	@Override
	public List<Student> selectAll() {
		System.out.println("Hibernate SelectAll");
		return new StudentDaoImp().selectAll(HibernateUtils.getQuery("from Student"));
	}

	@Override
	public List<Student> selectByPage(int page) {
		System.out.println("Hibernate SelectByPage");
		Query query = HibernateUtils.getQuery("from Student");
		query.setFirstResult((page - 1) * 6);
		query.setMaxResults(6);
		return new StudentDaoImp().selectByPage(query);
	}

//	@Override
//	public Student selectOneByQuery(String id) {
//		System.out.println("Hibernate SelectOneByQuery");
//		Query query = HibernateUtils.getQuery("from Student where sid = :sid");
//		query.setString("sid", id);
//		return new StudentDaoImp().selectOne(query);
//	}
	@Override
	public Student selectOneByQuery(String id) {
		System.out.println("Hibernate SelectOneByQuery");
		return new StudentDaoImp().selectOne(id);
	}
	
	public Student selectOneByGet(String id) {
		System.out.println("Hibernate SelectOneByGet");
		return HibernateUtils.get(Student.class, id);
	}

	@Override
	public void update(String ssex, String sphone, String smajor, String sid) {

		System.out.println("Hibernate Update");
		Student stu = new Student(ssex, sphone, smajor, sid);

		Session session = HibernateUtils.Query();
		new StudentDaoImp().update(session, stu);
		session.getTransaction().commit();
	}

	@Override
	public void delete(String id) {
		System.out.println("Hibernate Delete");
		Student stu = new Student();
		stu.setSid(id);
		
		Session session = HibernateUtils.Query();
		new StudentDaoImp().delete(session, stu);
		session.getTransaction().commit();
	}

	@Override
	public void insert(String sid, String sname, String ssex, String sphone, String smajor) {
		System.out.println("Hibernate Insert");
		Student stu = new Student(sid,sname,ssex,sphone,smajor);
		
		Session session = HibernateUtils.Query();
		new StudentDaoImp().insert(session,stu);
		session.getTransaction().commit();
	}


}
