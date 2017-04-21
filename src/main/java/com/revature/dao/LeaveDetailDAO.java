package com.revature.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.revature.model.Employee;
import com.revature.model.LeaveDetail;
import com.revature.model.LeaveStatus;
import com.revature.model.LeaveType;

@Repository
public class LeaveDetailDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	public void applyLeave(LeaveDetail ld) {

		String sql = "INSERT INTO EMPLOYEE_LEAVE_DETAILS ( EMP_ID , FROM_DATE, TO_DATE, NO_OF_DAYS, LEAVE_TYPE,  STATUS_ID, APPLIED_DATE, MODIFIED_DATE, MODIFIED_BY,PURPOSE)"
				+ "VALUES ( ?, ?, ?, ?, ?, ?, NOW(), NOW(),?,? )";

		int rows = jdbcTemplate.update(sql, ld.getEmployee().getId(), ld.getFromDate(), ld.getToDate(),
				ld.getNoOfDays(), ld.getLeaveType().getId(), ld.getStatus().getId(),ld.getEmployee().getId(),ld.getPurpose());

	}
	
	/*public void applyLeave(LeaveDetail ld)
	{
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)

				.withProcedureName("PR_APPLY_LEAVE");

				Map<String, Object> inParamMap = new HashMap<String, Object>();
				inParamMap.put("p_eid", ld.getEmployee().getId());
				inParamMap.put("p_from_date",ld.getFromDate());
				inParamMap.put("p_to_date", ld.getToDate());
				inParamMap.put("p_no_of_days",ld.getNoOfDays());
				inParamMap.put("p_leave_type",ld.getLeaveType().getId());
				SqlParameterSource in = new MapSqlParameterSource(inParamMap);


				Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
				System.out.println(simpleJdbcCallResult);
	}*/

	public void update(LeaveDetail ld) {

		String sql = "UPDATE EMPLOYEE_LEAVE_DETAILS SET STATUS_ID = ? , MODIFIED_BY = ? , MODIFIED_DATE= NOW() WHERE ID = ?";

		int rows = jdbcTemplate.update(sql, ld.getStatus().getId(), ld.getModifiedBy().getId(), ld.getId());

		

}
	public Map<String, Double> calculateRemainingDays(Long empId){
		
		Map<String,Double>remainingDays=new HashMap<>();
		
		double totCL=0,noCL=0,remCL=0;
		double totPL=0,noPL=0,remPL=0;
		double totSL=0,noSL=0,remSL=0;
		double totMATL=0,noMATL=0,remMATL=0;
		double totPATL=0,noPATL=0,remPATL=0;
		double totPRL=0,noPRL=0,remPRL=0;
		
		totSL=(Double)jdbcTemplate.queryForObject("SELECT SICK_LEAVE FROM ROLE_LEAVES WHERE ROLE_ID=(SELECT ROLE_ID FROM EMPLOYEES WHERE ID=?)", new Object[]{empId},Double.class);
		totCL=(Double)jdbcTemplate.queryForObject("SELECT CASUAL_LEAVE FROM ROLE_LEAVES WHERE ROLE_ID=(SELECT ROLE_ID FROM EMPLOYEES WHERE ID=?)", new Object[]{empId},Double.class);
		totPL=(Double)jdbcTemplate.queryForObject("SELECT PAID_LEAVE FROM ROLE_LEAVES WHERE ROLE_ID=(SELECT ROLE_ID FROM EMPLOYEES WHERE ID=?)", new Object[]{empId},Double.class);
		totMATL=(Double)jdbcTemplate.queryForObject("SELECT MATERNITY_LEAVE FROM ROLE_LEAVES WHERE ROLE_ID=(SELECT ROLE_ID FROM EMPLOYEES WHERE ID=?)", new Object[]{empId},Double.class);
		totPATL=(Double)jdbcTemplate.queryForObject("SELECT PATERNITY_LEAVE FROM ROLE_LEAVES WHERE ROLE_ID=(SELECT ROLE_ID FROM EMPLOYEES WHERE ID=?)", new Object[]{empId},Double.class);
		totPRL=(Double)jdbcTemplate.queryForObject("SELECT PRIVILEGED_LEAVE FROM ROLE_LEAVES WHERE ROLE_ID=(SELECT ROLE_ID FROM EMPLOYEES WHERE ID=?)", new Object[]{empId},Double.class);
		
		noCL=getUsedDays(empId,1);
		noSL=getUsedDays(empId,2);
		noPL=getUsedDays(empId,3);
		noMATL=getUsedDays(empId,4);
		noPATL=getUsedDays(empId,5);
		noPRL=getUsedDays(empId,6);
		
		remCL=totCL-noCL;
		remSL=totSL-noSL;
		remPL=totPL-noPL;
		remPATL=totPATL-noPATL;
		remMATL=totMATL-noMATL;
		remPRL=totPRL-noPRL;
		
		remainingDays.put("casual_leave", remCL);
		remainingDays.put("sick_leave", remSL);
		remainingDays.put("paid_leave", remPL);
		remainingDays.put("maternity_leave", remMATL);
		remainingDays.put("paternity_leave", remPATL);
		remainingDays.put("privileged_leave", remPRL);
		
		return remainingDays;
		
	}
	private double getUsedDays(Long empId,int leaveTypeId){
		double days=0;
		String temp="SELECT NO_OF_DAYS FROM EMPLOYEE_LEAVE_DETAILS WHERE EMP_ID=? AND LEAVE_TYPE=? AND (STATUS_ID=? OR STATUS_ID=?)";
		List<Map<String, Object>>rows=jdbcTemplate.queryForList(temp,new Object[]{empId,leaveTypeId,1,2});
		for(Map row:rows){
			double day=((BigDecimal)row.get("NO_OF_DAYS")).floatValue();
			days+=day;
			
		}
		return days;
	}
	public List<LeaveDetail> list(Long empId) {

		String sql = "SELECT e.NAME, ld.ID, ld.EMP_ID, FROM_DATE,TO_DATE, NO_OF_DAYS, LEAVE_TYPE AS LEAVE_TYPE_ID, ( SELECT LEAVE_TYPE FROM LEAVE_TYPES WHERE ID = ld.LEAVE_TYPE) LEAVE_TYPE , STATUS_ID, ( SELECT CODE FROM LEAVE_STATUS WHERE ID = STATUS_ID ) LEAVE_STATUS, ld.APPLIED_DATE, ld.MODIFIED_BY, ld.MODIFIED_DATE,ld.PURPOSE FROM EMPLOYEE_LEAVE_DETAILS ld , EMPLOYEES e WHERE ld.EMP_ID = e.ID AND EMP_ID=? order by FROM_DATE DESC";

		// List<LeaveDetail> list = jdbcTemplate.query(sql, new Object[] { empId
		// }, new LeaveDetailRowMapper());

		List<LeaveDetail> list = jdbcTemplate.query(sql, new Object[] { empId }, (rs, rowNo) -> {
			Employee emp = new Employee();
			
			emp.setId(rs.getLong("EMP_ID"));
			emp.setName(rs.getString("NAME"));
			
			Employee modifiedBy = new Employee();
			modifiedBy=employeeDAO.findById(rs.getLong("MODIFIED_BY"));

			LeaveStatus ls = new LeaveStatus();
			ls.setId(rs.getLong("STATUS_ID"));
			ls.setStatus(rs.getString("LEAVE_STATUS"));

			LeaveType lt = new LeaveType();
			lt.setId(rs.getLong("LEAVE_TYPE_ID"));
			lt.setType(rs.getString("LEAVE_TYPE"));

			LeaveDetail ld = new LeaveDetail();
			ld.setId(rs.getLong("ID"));
			ld.setEmployee(emp);
			ld.setFromDate(rs.getDate("FROM_DATE").toLocalDate());
			ld.setToDate(rs.getDate("TO_DATE").toLocalDate());
			ld.setNoOfDays(rs.getFloat("NO_OF_DAYS"));
			ld.setLeaveType(lt);
			ld.setStatus(ls);
			ld.setAppliedDate(rs.getDate("APPLIED_DATE").toLocalDate());
			ld.setModifiedBy(modifiedBy);
			ld.setModifiedDate(rs.getDate("MODIFIED_DATE").toLocalDate());
			ld.setPurpose(rs.getString("PURPOSE"));
			return ld;
		});
		return list;

}
	public List<LeaveDetail> teamRequests(Long mgrId) {
		System.out.println("Inside Team Requests");
		List<Integer>emps = new LinkedList<>();
		List<LeaveDetail> list=new LinkedList<>();
		String temp="SELECT emp_id FROM EMPLOYEE_HIERARCHY WHERE MGR_ID=?";
		List<Map<String, Object>>rows=jdbcTemplate.queryForList(temp,new Object[]{mgrId});
		for(Map row:rows){
			Integer employee=(Integer) row.get("EMP_ID");
			System.out.println(employee);
			emps.add(employee);
		}
		for(long empId:emps)
		{		
			List<LeaveDetail>templist=list(empId);
			for(LeaveDetail tld:templist){
			list.add(tld);
		}
		}
		return list;
}
	
	

}
