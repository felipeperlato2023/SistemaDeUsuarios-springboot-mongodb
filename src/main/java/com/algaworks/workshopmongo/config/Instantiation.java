package com.algaworks.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.algaworks.workshopmongo.Dtos.AuthorDTO;
import com.algaworks.workshopmongo.Dtos.CommentDTO;
import com.algaworks.workshopmongo.Repositories.PostRepository;
import com.algaworks.workshopmongo.Repositories.UserRepository;
import com.algaworks.workshopmongo.domain.Post;
import com.algaworks.workshopmongo.domain.User;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		 userRepository.deleteAll();
		 postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown 2", "maria@gmail2.com");
		User alex = new User(null, "Alex Green 2", "alex@gmail2.com");
		User bob = new User(null, "Bob Grey 2", "bob@gmail2.com");
		
		userRepository.save(maria);
		userRepository.save(alex);
		userRepository.save(bob);
		
		Post p1 = new Post(null,sdf.parse("16/02/2024"), "partiu viagem", "Vou viajar para SP. Abraços.", new AuthorDTO(maria));
		
		Post p2 = new Post(null,sdf.parse("17/02/2024"), "Bom dia", "Hoje acordei feliz!.",new AuthorDTO(maria));
		
		
		
		postRepository.save(p1);
		postRepository.save(p2);
		
		maria.getPosts().add(p2);
		maria.getPosts().add(p1);
		
		userRepository.save(maria);
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano",sdf.parse("17/02/2024"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveita",sdf.parse("18/02/2024"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia",sdf.parse("16/02/2024"), new AuthorDTO(alex));
		
		p1.getList().add(c1);
		p1.getList().add(c2);
		p2.getList().add(c3);
		
		postRepository.save(p1);
		postRepository.save(p2);
		
		
	}

}
