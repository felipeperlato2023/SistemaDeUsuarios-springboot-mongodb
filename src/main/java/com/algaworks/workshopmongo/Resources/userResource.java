package com.algaworks.workshopmongo.Resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.workshopmongo.Dtos.userDTO;
import com.algaworks.workshopmongo.Services.UserService;
import com.algaworks.workshopmongo.domain.Post;
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

	@GetMapping("/{id}")
	public ResponseEntity<userDTO> findById(@PathVariable String id) {

		User obj = service.findById(id);
		return ResponseEntity.ok().body(new userDTO(obj));

	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody userDTO objDto) {

		User obj = service.fromDto(objDto);

		obj = service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable String id, @RequestBody userDTO objDto) {
		
	    User obj = service.fromDto(objDto);
		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> findPost(@PathVariable String id) {

		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts());

	}
}
