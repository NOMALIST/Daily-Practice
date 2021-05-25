package com.sample.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.hr.vo.Job;
import com.sample.utils.ConnectionUtil;

public class JobDao {

	public List<Job> getAllJob() throws SQLException{
		List<Job> jobs = new ArrayList<Job>();
		
		String sql = "select * "
				   + "from jobs ";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Job job = new Job();
			
			job.setJobId(rs.getString("job_id"));
			job.setJobTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalary(rs.getInt("max_salary"));
			
			jobs.add(job);
		}
		
		rs.close();
		pstmt.close();
		
		return jobs;
	}
}
