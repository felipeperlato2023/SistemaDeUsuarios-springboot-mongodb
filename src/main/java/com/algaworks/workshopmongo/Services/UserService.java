package com.algaworks.workshopmongo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.workshopmongo.Repositories.UserRepository;
import com.algaworks.workshopmongo.domain.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

}
