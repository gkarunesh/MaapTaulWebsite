package com.lmd.web.ctrl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmd.web.entity.EstbDistrict;
import com.lmd.web.entity.Student;
import com.lmd.web.service.DistrictService;
import com.lmd.web.service.StudentService;
@RestController
@RequestMapping("/api-test")
@CrossOrigin("*")
public class DatabaseController {
	
	private final DataSource dataSource;
	
	@Autowired
	private StudentService studentService;
	
	//private final StudentService studentService;
	
	private final DistrictService distServ;
	
	public DatabaseController(DataSource dataSource, StudentService studentService, DistrictService distServ) {
		this.dataSource = dataSource;
		//this.studentService = studentService;
		this.distServ = distServ;
	}

	/*@GetMapping("/index-page")
	public String indexPage() {
		return "index";
	}*/
		
	@GetMapping("/connection")
	public ResponseEntity<?> checkConnection() {
	    try (Connection connection = dataSource.getConnection()) {
	        DatabaseMetaData metaData = connection.getMetaData();
	        String url = metaData.getURL();
	        return ResponseEntity.ok("Connected to: " + url);
	    } catch (SQLException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("Database connection failed: " + e.getMessage());
	    }
	}
	
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    
    @GetMapping("/districts")
    public List<EstbDistrict> getDistricts(){
		return distServ.getAllDistrictsList();		
	}
	
}
