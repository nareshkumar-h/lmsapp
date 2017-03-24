package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping
	public List<Holiday> list() {
		return holidayService.list();
	}

	@GetMapping("/{id}")
	public Holiday findById(@PathVariable("id") Long id) {
		return holidayService.findById(id);
	}

	@PostMapping
	public void save(@RequestBody Holiday holiday) {
		holidayService.save(holiday);
	}

	@PutMapping
	public void update(@RequestBody Holiday holiday) {
		holidayService.update(holiday);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		holidayService.delete(id);
	}
}
