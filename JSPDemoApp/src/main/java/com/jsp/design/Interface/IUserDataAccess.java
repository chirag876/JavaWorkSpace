package com.jsp.design.Interface;

import com.jsp.design.Model.User;

public interface IUserDataAccess {

	User getuserbyid(String UserId);

	int createNewUser(User user);
}
