package com.zrj.Dao.imp;


import org.hibernate.Query;
import org.hibernate.Session;

import com.zrj.Dao.UserDao;
import com.zrj.Entity.User;

public class UserDaoImp implements UserDao{

	
	@Override
	public void addUser(Session session,User user) {
		session.save(user);
	}

	@Override
	public User selectUserByNamePwd(Query query) {
		User user = (User) query.uniqueResult();
		
		return user;
	}

}
