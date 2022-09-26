package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.BookDataService;

@Controller
public class BookController {
	@Autowired
	BookDataService service;
	
	@RequestMapping("\test")
	public String test() {
		System.out.println("test");
		return "index";
	}

}
