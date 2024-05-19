package com.jsp.design.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jsp.design.Model.User;
import com.jsp.design.DataAccess.UserDataAccess;

@Controller
public class LoginController {

	@Autowired
	UserDataAccess userdata;

	@GetMapping("/login")
	public String loginpage() {
		return "login";
	}

	@PostMapping("/login")
	public String welcomePage(ModelMap model, @RequestParam String UserId, @RequestParam String Password) {
		User user = userdata.getuserbyid(UserId);

		if (user.getPassword().equals(Password)) {
			model.put("UserId", UserId);
			return "Welcome";
		}
		model.put("errorMsg", "Please provide correct credentials");
		return "login";

	}

	@GetMapping("/register")
	public String registerpage(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam("UserId") String userId, 
	                       @RequestParam("Password") String password,
	                       Model model) {

	    // Create a new User object with the submitted data
	    User user = new User();
	    user.setUserId(userId);
	    user.setPassword(password);

	    // Save the user object to the database
	    int count = userdata.createNewUser(user);
	    if(count!= 1) {
	        model.addAttribute("errorMsg", "Registration failed");
	        return "register";
	    }
	    model.addAttribute("successMsg", "Registration successful");
	    // Redirect the user to the login page
	    return "login";
	}
}