package com.devsuperior.learn.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.learn.dto.NotificationDTO;
import com.devsuperior.learn.entities.Notification;
import com.devsuperior.learn.entities.User;
import com.devsuperior.learn.repositories.NotificationRepository;

@Service
public class NotificationService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public Page<NotificationDTO> notificationsForCurrentUser(Pageable pageable) {
		
		User user = authService.authenticated();
		
		Page<Notification> page = repository.findByUser(user, pageable);
		
		return page.map(x -> new NotificationDTO(x));
	}

}
