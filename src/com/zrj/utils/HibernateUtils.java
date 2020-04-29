package com.zrj.utils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	private static ThreadLocal<Session> tl = new ThreadLocal<Session>();

	static {
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			sf = cfg.buildSessionFactory();
		} catch (ExceptionInInitializerError e) {
			throw new ExceptionInInitializerError("初始化工厂类失败!");
		}
	}

	public static Session openSession() {
		return sf.openSession();

	}

	/**
	 * @return 获得线程绑定的Session
	 */
	public static Session getCurrentSession() {
		return sf.getCurrentSession();// 只有配置了把线程和session绑定之后才能使用该方法,否则返回null

	}

	/**
	 * @param hql Hibernate查询语句
	 * @return 用于获得查询操作的Query
	 */
	public static Query getQuery(String hql) {
		System.out.println("HibernateUtils Select");
		Session session = HibernateUtils.getCurrentSession();
		session.beginTransaction();
		return session.createQuery(hql);
	}
	
	/**
	 * 获得进行查询单个结果时的对象
	 * @param cl
	 * 需要查询的类类型
	 * @param id
	 * 数据库中该类所映射的表的列主键
	 * @return
	 * 返回给定数据类型的对象
	 */
	public static <E> E get(Class<E> cl, String id) {
		System.out.println("Hibernate getObj");
		Session session = getCurrentSession();
		session.beginTransaction();
		return session.get(cl, id);
	}

	public static Session Query() {
		System.out.println("Hibernate Query");
		Session session = HibernateUtils.getCurrentSession();
		session.beginTransaction();
		return session;
	}
//	public static <E> void Delete(E obj) {
//		System.out.println("Hibernate Delete");
//		String sql = "delete student from student where sid = ?";
//		Session session = HibernateUtils.getCurrentSession();
//		Transaction tr = session.beginTransaction();
//		Student student = new Student();
//		tr.commit();
//		new StudentDaoImp().Delete(session,obj);
//	}
}
