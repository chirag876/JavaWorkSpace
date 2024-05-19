//package com.springrest.springrest.services;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.springrest.springrest.Dao.CourseDAO;
//import com.springrest.springrest.Entity.Course;
//
//@Service
//public class CourseServiceImpl implements CourseService {
//
//	
//	
//	@Autowired
//	private CourseDAO courseDao;
//	
//	//List<Course> list;
//	
////	public CourseServiceImpl() {
////		list = new ArrayList<>();
////		list.add(new Course(1001,"Java","Beginer to Addvace",999));
////		list.add(new Course(1002,"python","Beginer to Addvace",1999));
////		list.add(new Course(1003,"C#","Beginer to Addvace",2999));
////	}
//	
//	
//	public List<Course> GetAllCourse() {
//		
//		return courseDao.findAll();
//	}
//	
//	public Course GetCourseById(int courseId) {
////		Course c  = null;
////		for(Course course: list) {
////			if(course.getCourseId()==courseId) {
////				c = course;
////			}
////		}
//		
//		return courseDao.getOne(courseId);
//				
//	}
//	
//	public Course AddCourse(Course course) {
////		 list.add(course);
//		courseDao.save(course);
//		 return course;
//	}
//	public int DeleteCourse(int CourseId) {
////		Course c  = null;
////		for(Course course: list) {
////			if(course.getCourseId()==CourseId) {
////				c = course;
////				list.remove(course);
////			}
////		}
//		 courseDao.deleteById(CourseId);
//		 return CourseId;
//		
//	}
//	
//
//}
