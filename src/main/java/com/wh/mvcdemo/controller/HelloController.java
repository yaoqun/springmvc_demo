package com.wh.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Whiker on 2016/1/21.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "hello_index";
	}

}
