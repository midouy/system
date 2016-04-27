package org.system.dao;

import org.system.domain.User;

public interface UserDao
{
	User getUser(String name);
	
	void addUser(User user);
	
	void deleteUserByID(int id);

    void deleteUser(String name);
	
	void editUser(int id, User user);
}
