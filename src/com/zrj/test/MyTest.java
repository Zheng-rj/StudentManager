package com.zrj.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.zrj.Entity.Student;
import com.zrj.Entity.User;
import com.zrj.utils.HibernateUtils;
public class MyTest {
	@Test
	public void Work1() {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		Query query = session.createQuery("from Student");
		List<Student> list = query.list();
		for(Student s:list) {
			System.out.println(s);
		}
		tr.commit();
		session.close();
		factory.close();
	}
	
	@Test
	public void work2() {
		Student stu = HibernateUtils.get(Student.class, "4b3a238b1f7c41048cfcca2d338d21d4");
		System.out.println(stu);
	}
}
