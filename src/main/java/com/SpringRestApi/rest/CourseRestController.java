package com.SpringRestApi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRestApi.Service.CourseService;
import com.SpringRestApi.binding.Course;

@RestController
public class CourseRestController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course)
	{
		System.out.println(course.getName());
		System.out.println(course.getPrice());
		String status=courseService.upsert(course);
		System.out.println(HttpStatus.CREATED);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/courses/{cid}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer cid)
	{
		Course course = courseService.getById(cid);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses(@RequestBody Course course){
		List<Course> allCourses = courseService.getAllCourses();
		return new ResponseEntity<>(allCourses, HttpStatus.OK);
	}
	
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course)
	{
		String status= courseService.upsert(course);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@DeleteMapping("/course/{cid}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer cid)
	{
		String status = courseService.deleteById(cid);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
}
