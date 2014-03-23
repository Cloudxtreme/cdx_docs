package com.vaannila.service;

import com.vaannila.domain.User;

public class UserServiceImpl implements UserService {

	@Override
	public void add(User hello) {
		//Persist the hello object here. 
		System.out.println("User added successfully");

	}

}
