package com.wh.mvcdemo.controller;

import com.wh.mvcdemo.model.Course;
import com.wh.mvcdemo.model.UserFile;
import com.wh.mvcdemo.service.QueryCourseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Whiker on 2016/1/21.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

	private static Logger log = Logger.getLogger(CourseController.class);

	private QueryCourseService queryCourse;

	@Autowired
	public void setFindCourseService(QueryCourseService queryCourse) {
		this.queryCourse = queryCourse;
	}

	// 处理请求: /course/query?courseId=123
	@RequestMapping(value="/query", method=RequestMethod.GET)
	public String queryCourseByUrlQquery(
			@RequestParam("courseId") Integer courseId, Model model) {
		Course course = queryCourse.queryCourse(courseId);
		model.addAttribute(course);
		return "course";
	}

	// 处理请求: /course/query/123
	// 需要返回多个Model时, 用Map
	@RequestMapping(value="/query/{courseId}", method=RequestMethod.GET)
	public String queryCourseByUrlPpath(
			@PathVariable("courseId") Integer courseId, Map<String, Object> model) {
		Course course = queryCourse.queryCourse(courseId);
		model.put("course", course);
		return "course";
	}

	// 处理请求: /course/query-servlet?courseId=123
	@RequestMapping("/query-servlet")
	public String queryCourseFromServlet(HttpServletRequest request) {
		Integer courseId = Integer.valueOf(request.getParameter("courseId"));
		Course course = queryCourse.queryCourse(courseId);
		request.setAttribute("course", course);
		return "course";
	}

	// 处理请求: /course/query/json/${courseId}
	@RequestMapping(value="/query/json/{courseId}", method=RequestMethod.GET)
	public @ResponseBody Course queryCourseReturnJson(
			@PathVariable("courseId") Integer courseId) {
		return queryCourse.queryCourse(courseId);
	}

	// 处理请求: /course/query/json2/${courseId}
	@RequestMapping(value="/query/json2/{courseId}", method=RequestMethod.GET)
	public ResponseEntity<Course> queryCourseReturnJson2(
			@PathVariable("courseId") Integer courseId) {
		Course course = queryCourse.queryCourse(courseId);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	// 返回页面: 添加课程表单
	@RequestMapping("/add")
	public String getAddPage() {
		return "add_course";
	}

	// 处理添加课程表单
	@RequestMapping(value="/do_add", method=RequestMethod.POST)
	public String doAdd(@ModelAttribute Course course) {
		return "redirect:query/" + course.getId();  // 请求重定向
	}

	// 返回页面: 上传文件
	@RequestMapping("/upload")
	public String getUploadFilePage() {
		return "upload_file";
	}

	// 处理文件上传
	@RequestMapping(value="/do_upload", method=RequestMethod.POST)
	public String doUpload(@RequestParam("userfile") MultipartFile file, Model model) {
		UserFile userFile = new UserFile();
		if (!file.isEmpty()) {
			userFile.setName(file.getOriginalFilename());
			userFile.setSize(file.getSize());
		}
		model.addAttribute(userFile);
		return "userfile";
	}
}
