package com.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDao;
import com.springrest.entites.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	public CourseServiceImpl() {
	}

	@Override
	public List<Course> getCourses() {

		return this.courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {

		return this.courseDao.getById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		this.courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		this.courseDao.save(course);
		return course;
	}

	@Override
	public Course deleteCourse(long courseId) {

		Course c = this.courseDao.getById(courseId);
		this.courseDao.delete(c);
		return c;
	}

}
