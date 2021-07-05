package com.devsuperior.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.learn.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
