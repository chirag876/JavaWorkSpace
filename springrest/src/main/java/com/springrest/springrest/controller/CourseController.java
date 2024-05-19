//package com.springrest.springrest.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.springrest.springrest.Entity.Course;
//import com.springrest.springrest.services.CourseService;
//
//@RestController
//public class CourseController {
//	@Autowired
//	private CourseService courseService;
//	@GetMapping("/Home")
//	public String Home() {
//		return "This is Home Page";
//	}
//	@GetMapping("/GetAll")
//	public List<Course> GetAllCourse(){
//		return this.courseService.GetAllCourse();
//		
//	}
//	@GetMapping("/GetCourseById/{courseId}")
//	public Course GetCourseById(@PathVariable String courseId ) {
//		return this.courseService.GetCourseById(Integer.parseInt(courseId));
//	} 
//	
//	@PostMapping("/AddCourse")
//	public Course AddCourse(@RequestBody Course course) {
//		return this.courseService.AddCourse(course);
//	}
//	
//	@DeleteMapping("/DeleteCourse")
//	public ResponseEntity<HttpStatus> DeleteCourse(@PathVariable String courseId){
//		
//		try {
//		this.courseService.DeleteCourse(Integer.parseInt(courseId));
//		return new ResponseEntity<>(HttpStatus.OK);
//		}
//		catch(Exception ex) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	
//}
//	
//
//
