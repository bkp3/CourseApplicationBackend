package com.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.entites.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;

	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(145, "Java", "This is Java course"));
		list.add(new Course(213, "Python", "This is Python course"));
		list.add(new Course(160, "MySQL", "This is MySQL course"));
	}

	@Override
	public List<Course> getCourses() {

		return list;
	}

	@Override
	public Course getCourse(long courseId) {

		for (Course c : list) {
			if (c.getId() == courseId) {
				return c;
			}
		}

		return null;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		int index = -1;
		for (Course c : list) {
			index++;
			if (course.getId() == c.getId()) {
				break;
			}
		}
		list.set(index, course);
		return course;
	}

	@Override
	public Course deleteCourse(long courseId) {
		int index = -1;
		for (Course c : list) {
			index++;
			if (c.getId() == courseId) {
				break;
			}
		}
		Course temp = list.get(index);
		list.remove(index);
		return temp;

	}

}
