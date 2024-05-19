package com.jsp.design.DataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.design.DAO.UserDao;
import com.jsp.design.Interface.IUserDataAccess;
import com.jsp.design.Model.User;

@Service
public class UserDataAccess implements IUserDataAccess {

	@Autowired
	UserDao userdao;

	@Override
	public User getuserbyid(String UserId) {
		User user = userdao.getuserbyid(UserId);
		return user;
	}

	@Override
	public int createNewUser(User user) {
		// TODO Auto-generated method stub
		return userdao.createNewUser(user);
	}

}
