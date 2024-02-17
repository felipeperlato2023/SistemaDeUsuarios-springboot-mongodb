package com.algaworks.workshopmongo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.workshopmongo.Repositories.PostRepository;
import com.algaworks.workshopmongo.Services.Exceptions.ObjectNotFoundException;
import com.algaworks.workshopmongo.domain.Post;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;


	public Post findById(String id) {
		java.util.Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado: " + id));
	}

	
}


