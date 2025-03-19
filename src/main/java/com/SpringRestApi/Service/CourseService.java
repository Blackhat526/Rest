package com.SpringRestApi.Service;

import java.util.List;

import com.SpringRestApi.binding.Course;

public interface CourseService {
	
	public String upsert(Course course);
	//Upsert for both insert and update together
	public Course getById(Integer cid);
	
	public List<Course> getAllCourses();
	
	public String deleteById(Integer cid);
	
}
