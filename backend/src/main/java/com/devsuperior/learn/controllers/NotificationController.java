package com.devsuperior.learn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.learn.dto.NotificationDTO;
import com.devsuperior.learn.services.NotificationService;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationController {

	@Autowired
	private NotificationService service;
	
	@GetMapping
	public ResponseEntity<Page<NotificationDTO>> notificationsForCurrrentUser(Pageable pageable) {
		
		Page<NotificationDTO> page = service.notificationsForCurrentUser(pageable);
		
		return ResponseEntity.ok().body(page);
	}
}
