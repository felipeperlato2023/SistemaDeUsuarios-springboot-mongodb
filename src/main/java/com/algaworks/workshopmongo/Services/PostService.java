package com.algaworks.workshopmongo.Services;

import java.util.Date;
import java.util.List;

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
	
	public List<Post> findByTitle(String Text){
		return repository.serachTitle(Text);
	}
	
	public List<Post> fullSearch(String Text, Date minDate, Date maxDate){
		
		maxDate = new Date(maxDate.getTime()+24 * 60 * 60 * 1000);
		
		return repository.fullSearch(Text, minDate, maxDate);
	}
	
}


