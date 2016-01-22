package com.wh.mvcdemo.service;

import com.wh.mvcdemo.model.Course;
import org.springframework.stereotype.Service;

/**
 * Created by Whiker on 2016/1/21.
 */
@Service
public interface QueryCourseService {

	public Course queryCourse(Integer courseId);

}
