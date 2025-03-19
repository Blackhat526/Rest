package com.SpringRestApi.Repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringRestApi.binding.Course;


//Jpa repository is a predifined repo in data jpa 
//@Repository
public interface CourseRepository extends JpaRepository<Course, Serializable>{
	
}
