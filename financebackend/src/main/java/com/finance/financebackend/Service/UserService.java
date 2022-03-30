package com.finance.financebackend.Service;

import java.util.List;

import com.finance.financebackend.Beans.User;

public interface UserService {
	public boolean addUser(User user);
	public User findUserByUname(String uname);
	public List<User> getAllUsers();

}
