package com.devsuperior.learn.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.learn.entities.User;
import com.devsuperior.learn.repositories.UserRepository;
import com.devsuperior.learn.services.exceptions.ForbiddenException;
import com.devsuperior.learn.services.exceptions.UnauthorizedException;

@Service
public class AuthService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			
			return repository.findByEmail(username);
		}catch(Exception ex) {
			throw new UnauthorizedException("Invalid user");
		}
	}
	
	public void validateSelfOrAdmin(Long userId) {
		User user = authenticated();
		
		if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenException("Access denied");
		}
	}
}
