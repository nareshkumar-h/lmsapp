package com.revature.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.model.Holiday;

@Repository  
public class HolidayDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Holiday> list() {

		String sql = "SELECT ID, HOLIDAY_DATE, REASON FROM HOLIDAYS";

		List<Holiday> list = jdbcTemplate.query(sql, new Object[] {}, (rs, rowNo) -> {

			Holiday holiday = new Holiday();
			holiday.setId(rs.getLong("ID"));
			holiday.setHolidayDate(rs.getDate("HOLIDAY_DATE").toLocalDate());
			holiday.setStatus(rs.getString("REASON"));
			return holiday;
		});
		return list;
	}

	public void addHoliday(Holiday holiday) {

		String sql = "INSERT INTO HOLIDAYS ( HOLIDAY_DATE, REASON)" + "VALUES ( ?, ? )";

		int rows = jdbcTemplate.update(sql, holiday.getHolidayDate(), holiday.getStatus());

		System.out.println("No of rows inserted:" + rows);
	}

	public void update(Holiday holiday) {

		String sql = "UPDATE HOLIDAYS SET HOLIDAY_DATE=?,REASON=? WHERE ID = ?";

		int rows = jdbcTemplate.update(sql, holiday.getHolidayDate(), holiday.getStatus(), holiday.getId());

		System.out.println("No of rows updated:" + rows);

	}

	public Holiday findById(Long id) {

		String sql = "SELECT ID, HOLIDAY_DATE, REASON FROM HOLIDAYS WHERE ID=?";

		Holiday list = jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rowNo) -> {

			Holiday holiday = new Holiday();
			holiday.setId(rs.getLong("ID"));
			holiday.setHolidayDate(rs.getDate("HOLIDAY_DATE").toLocalDate());
			holiday.setStatus(rs.getString("REASON"));
			return holiday;
		});
		return list;
	}

	public void delete(Long id) {

		String sql = "UPDATE FROM HOLIDAYS SET ACTIVE=0 WHERE ID= ? ";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted:" + rows);

	}
}
