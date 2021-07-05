package com.devsuperior.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.learn.entities.Deliver;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver, Long>{

}
