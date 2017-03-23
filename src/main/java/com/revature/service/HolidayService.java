package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.HolidayDAO;
import com.revature.model.Holiday;

@Service
public class HolidayService {

	@Autowired
	private HolidayDAO holidayDao;

	public List<Holiday> list() {

		return holidayDao.list();
	}

	public void save(Holiday holiday) {
		holidayDao.addHoliday(holiday);
	}

	public void delete(Long holidayId) {
		holidayDao.delete(holidayId);
	}

	public void update(Holiday holiday) {
		holidayDao.update(holiday);
	}

	public Holiday findById(Long id) {

		return holidayDao.findById(id);
	}
}
