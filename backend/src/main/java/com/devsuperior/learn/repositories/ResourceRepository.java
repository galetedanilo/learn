package com.devsuperior.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.learn.entities.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long>{

}
