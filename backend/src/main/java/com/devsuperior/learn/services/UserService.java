package com.devsuperior.learn.services;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.learn.dto.UserDTO;
import com.devsuperior.learn.entities.User;
import com.devsuperior.learn.repositories.UserRepository;
import com.devsuperior.learn.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> optional = repository.findById(id);
		
		User entity = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
		
		return new UserDTO(entity);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByEmail(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Email not found");
		}
		
		return user;
	}

}
