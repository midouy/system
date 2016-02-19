package org.system.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.system.domain.*;
import org.system.dao.UserDao;


@Service("userService")
public class UserService
{
	public static int count = 0;
	@Resource
	private UserDao userDao;
	
	public User getUser(String name)
	{
		return userDao.getUser(name);
	}
	
	public void addUser(User user)
	{
		userDao.addUser(user);
	}
	
	public void deleteUser(int id)
	{
		userDao.deleteUserByID(id);
	}

    public void deleteUser(String name)
    {
        userDao.deleteUser(name);
    }

	public void editUser(int id, User user)
	{
		userDao.editUser(id, user);
	}
	
	public UserService()
	{
		System.out.println("Service construct!"+(++count));	
	}
}
