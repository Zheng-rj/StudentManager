package com.zrj.service;

import com.zrj.Entity.User;

public interface UserService {
	public void addUser(User user);

	public User selectUserByNamePwd(String uname, String upwd);
}
