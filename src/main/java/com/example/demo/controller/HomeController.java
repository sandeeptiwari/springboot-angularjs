package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({
			"/home",
			"/schools",
			"/classrooms",
			"/activities",
			"/classroom/{id:\\w+}",
			"/classroom/{id:\\w+}/detail/{month:\\w+}?"
	})
	public String index() {
		return "index";
	}
}
