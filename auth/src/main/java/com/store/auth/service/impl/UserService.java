package com.store.auth.service.impl;

import com.store.auth.domain.User;
import com.store.auth.repository.UserRepository;
import com.store.auth.service.IUserService;

public class UserService extends GenericService<User,	Long, UserRepository> implements IUserService{

	public UserService(UserRepository repository) {
		super(repository);
	}

	
}
