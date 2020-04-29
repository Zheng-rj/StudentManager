package com.zrj.Dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zrj.Entity.User;

public interface UserDao {
	public void addUser(Session session,User user);
	
	public User selectUserByNamePwd(Query query);
}
