package com.wh.mvcdemo.interceptor;

import com.wh.mvcdemo.model.Course;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Whiker on 2016/1/22.
 */
public class CourseInterceptor implements HandlerInterceptor {

	// Handler调用前
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		System.out.println("\n>>> preHandler\n");
		String courseIdStr = request.getParameter("courseId");
		if (courseIdStr == null) {
			return true;
		}

		try {
			if (Integer.valueOf(courseIdStr) <= 0) {
				PrintWriter out = response.getWriter();
				out.println("courseId <= 0");
				out.close();
				return false;
			}
		}
		catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("parse courseId error");
			out.close();
			return false;
		}
		return true;
	}

	// Handler调用后
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("\n>>> postHandle\n");
		if (modelAndView != null && !modelAndView.isEmpty()) {
			Map<String, Object> models = modelAndView.getModel();
			String modelName = "course";
			if (models.containsKey(modelName)) {
				Course course = (Course) models.get(modelName);
				course.setInfo("postHandler");
			}
		}
	}

	// 请求完成后
	public void afterCompletion(
			HttpServletRequest request,	HttpServletResponse response,
			Object handler, Exception e) throws Exception {
		System.out.println("\n>>> afterCompletion\n");
	}
}
