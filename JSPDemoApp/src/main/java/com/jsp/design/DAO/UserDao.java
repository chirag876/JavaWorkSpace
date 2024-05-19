package com.jsp.design.DAO;

import com.jsp.design.Model.User;

public interface UserDao {

	User getuserbyid(String UserId);

	int createNewUser(User user);
}
