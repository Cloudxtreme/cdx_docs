package com.vaannila.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vaannila.domain.User;
import com.vaannila.service.UserService;

@Controller
@RequestMapping("/userRegistration.htm")
@SessionAttributes("hello")
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model)
	{
		User hello = new User();
		model.addAttribute(hello);
		return "userForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("hello") User hello) {
		userService.add(hello);
		return "redirect:userSuccess.htm";
	}
	
}
