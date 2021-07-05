package com.devsuperior.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.learn.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
