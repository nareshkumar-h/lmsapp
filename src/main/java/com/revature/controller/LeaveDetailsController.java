package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.LeaveDetail;
import com.revature.service.LeaveDetailService;

@CrossOrigin
@RestController
@RequestMapping("/leavedetails")
public class LeaveDetailsController {
	
	@Autowired
	private LeaveDetailService leaveDetailService;
	
	
	@PostMapping("/save")
	public void save(@RequestBody LeaveDetail leaveDetail) {

		leaveDetailService.save(leaveDetail);
	}

	@PutMapping("/update")
	public void update(@RequestBody LeaveDetail leaveDetail) {

		leaveDetailService.update(leaveDetail);
	}

	@GetMapping("/{id}")
	public List<LeaveDetail> list(@PathVariable Long id) {
		return leaveDetailService.list(id);
}

}
