package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Holiday;
import com.revature.service.HolidayService;

@CrossOrigin
@RestController
@RequestMapping("/holidays")
public class HolidayController {

	@Autowired
	private HolidayService holidayService;

	@GetMapping("/")
	public List<Holiday> list() {
		return holidayService.list();
	}

}
