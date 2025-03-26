package com.lmd.web.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.lmd.web.entity.Student;

@Service
public class StudentService {
	private final JdbcTemplate jdbcTemplate;
	
	public StudentService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Student> getAllStudents() {
		String query ="SELECT * FROM student";
		
		return jdbcTemplate.query(query, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int ronNum) throws SQLException {
				Student student = new Student();
				student.setRoll(rs.getInt("roll"));
				student.setName(rs.getString("name"));
				student.setArrdess(rs.getString("address"));
				student.setContact(rs.getString("contact"));
				return student;
			}
		});
	}	
}
