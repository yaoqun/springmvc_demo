package com.wh.mvcdemo.service.impl;

import com.wh.mvcdemo.model.Course;
import com.wh.mvcdemo.service.QueryCourseService;
import org.springframework.stereotype.Service;

/**
 * Created by Whiker on 2016/1/21.
 */
@Service("simpleQueryCourse")
public class SimpleQueryCourseService implements QueryCourseService {

	public Course queryCourse(Integer courseId) {
		Course course = new Course();
		course.setId(courseId);
		course.setName("course-"+courseId);
		course.setDuration(100L);
		course.setImagePath("res/img/course.jpg");
		return course;
	}

}
