package com.algaworks.workshopmongo.Resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class userResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {

		User maria = new User("1", "Maria Brown", "Maria@gmail.com");
		User alex = new User("2", "Alex Brown", "Alex@gmail.com");

		List<User> list = new ArrayList<>();

		list.add(alex);
		list.add(maria);

		return ResponseEntity.ok().body(list);
	}

}
