package com.devsuperior.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.learn.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
