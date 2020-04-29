package com.zrj.service.imp;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zrj.Dao.imp.UserDaoImp;
import com.zrj.Entity.User;
import com.zrj.service.UserService;
import com.zrj.utils.HibernateUtils;

public class UserServiceImp implements UserService {

	@Override
	public void addUser(User user) {
		System.out.println("hibernate Test Add User:" + user);
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		new UserDaoImp().addUser(session, user);
		tr.commit();
	}

	@Override
	public User selectUserByNamePwd(String uname, String upwd) {
		System.out.println("hibernate Test Select User");
//		Session session = HibernateUtils.getCurrentSession();//获取Session
//		Transaction tr = session.beginTransaction();			
//		Query query = session.createQuery("from User where uname = :uname and upwd = :upwd");
//		query.setString("uname", user.getUname());
//		query.setString("upwd", user.getUpwd());
//		return new UserDaoImp().selectUser(query);
		Query query = HibernateUtils.getQuery("from User where uname = :uname and upwd = :upwd");
		query.setString("uname", uname);
		query.setString("upwd", upwd);
		return new UserDaoImp().selectUserByNamePwd(query);
	}

}
