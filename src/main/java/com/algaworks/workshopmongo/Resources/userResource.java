package com.algaworks.workshopmongo.Resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.workshopmongo.Dtos.userDTO;
import com.algaworks.workshopmongo.Services.UserService;
import com.algaworks.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<userDTO>> findAll() {

		List<User> list = service.findAll();
		
		List<userDTO> listDto = list.stream().map(x -> new userDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
