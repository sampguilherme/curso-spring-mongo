package com.sampguilherme.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampguilherme.workshopmongo.domain.Post;
import com.sampguilherme.workshopmongo.repository.PostRepository;
import com.sampguilherme.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll() {
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		if (post.isEmpty()) {
	        throw new ObjectNotFoundException("Objeto não encontrado.");
	    }
		
		return post.get();
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
}
