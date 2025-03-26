package com.lmd.web.restServices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmd.web.dto.OfficersDtoInterface;
import com.lmd.web.entity.OfficersDto;
import com.lmd.web.service.StaffService;
import com.lmd.web.utilities.Http;
import com.lmd.web.utilities.MyResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/staff")
@Slf4j
public class StaffWs {
	
	@Autowired
	StaffService staffService;
	
	private final JdbcTemplate jdbcTemplate;
	
	public StaffWs(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@GetMapping("/getAllOfficersHQR")
	public MyResponse<?> getAllOfficersHq() throws Exception {
		try {
			//List<OfficersDtoInterface> data = staffService.officersByHQ();
			List<OfficersDtoInterface> hdData = staffService.officersByHQ();
			return MyResponse.builder().statusCode(Http.OK).size(hdData.size()).data(hdData).build();	
		}
		catch (Exception e) {
			log.error("Error from hqr api::"+e.getStackTrace());
			return MyResponse.builder().statusCode(Http.EXCEPTION).status(Http.FAILURE).data(e.getMessage()).build();
		}
	}
	
	@GetMapping("/getAllOfficersDIV")
	public MyResponse<?> getAllOfficersDiv() throws Exception {
		try {
			//List<OfficersDtoInterface> data = staffService.officersByDiv();
			List<OfficersDtoInterface> divData = staffService.officersByDiv();
			return MyResponse.builder().statusCode(Http.OK).size(divData.size()).data(divData).build();
		}catch (Exception e) {
			log.error("Error from div api::"+e.getStackTrace());
			return MyResponse.builder().statusCode(Http.EXCEPTION).status(Http.FAILURE).data(e.getMessage()).build();
		}	
	}
	
	@GetMapping("/getAllOfficersDIS")
	public MyResponse<?> GetAllOfficersDis() throws Exception {
		try {
			 List<OfficersDtoInterface> data = staffService.officersByDis();
			 //List<OfficersDto> data = staffService.officersByDis();
			 return MyResponse.builder().statusCode(Http.OK).size(data.size()).data(data).build();
		}
		catch (Exception e) {
			log.error("Error from dist api"+e.getStackTrace());
			return MyResponse.builder().statusCode(Http.EXCEPTION).status(Http.FAILURE).data(e.getMessage()).build();
		}
	}
	
	@GetMapping("/getAllOfficersSUB")
	public MyResponse<?> GetAllOfficersSub() throws Exception {
		try { 
			 //List<OfficersDtoInterface> data = staffService.officersBySub();
			 List<OfficersDtoInterface> subData = staffService.officersBySub();
			 return MyResponse.builder().statusCode(Http.OK).size(subData.size()).data(subData).build();
		}catch (Exception e) {
			log.error("Error from subdiv api"+e.getStackTrace());
			return MyResponse.builder().statusCode(Http.EXCEPTION).status(Http.FAILURE).data(e.getMessage()).build();
		}		
	}
	
	/*@GetMapping("/all-officers-dis")
	public MyResponse<?> getAllOfficersDis() throws Exception {
		try {
			 log.info("Calling All Officers District Data...");
			 List<OfficersDtoInterface> data = staffService.officersByDis();
			 return MyResponse.builder().statusCode(Http.OK).size(data.size()).data(data).build();
		}
		catch (Exception e) {
			log.error(e.getMessage());
			return MyResponse.builder().statusCode(Http.EXCEPTION).status(Http.FAILURE).data(e.getMessage()).build();
		}
	}*/
	
	@GetMapping("/getAllOfficersSubDivApi")
	public List<OfficersDto> getOfficerBySub() {
		try {
			log.info("Enter in subdiv api :jdbc");
			String query ="select r.designation, ed.dist_name, es.sub_div_name, s.name,s.contact, s.email from role r inner join staff_assignment sa on r.role=sa.role_id inner join staff s on s.staff_id=sa.staff_id inner join estb_subdivision es on sa.office_code = es.sub_div_id inner join adm_district ed ON es.adm_dist_id = ed.dist_id where r.location_id='SUB' order by r.priority,ed.dist_name, es.sub_div_name";
			return jdbcTemplate.query(query, new RowMapper<OfficersDto>() {
				@Override
				public OfficersDto mapRow(ResultSet rs, int ronNum) throws SQLException {
					OfficersDto officersDto = new OfficersDto();
					officersDto.setDesignation(rs.getString("designation"));
					officersDto.setDist_name(rs.getString("dist_name"));
					officersDto.setSub_div_name(rs.getString("sub_div_name"));
					officersDto.setName(rs.getString("name"));
					officersDto.setContact(rs.getString("contact"));
					officersDto.setEmail(rs.getString("email"));
					return officersDto;
				}
			});
		}
		catch (Exception e) {
		log.error("Error from subdiv api:jdbc"+e.getStackTrace());
		return null;
		}		
	}
	
	@GetMapping("/getAllOfficersDisApi")
	public List<OfficersDto> getAllOfficerByDis() {
		try {
			log.info("Enter in dis api :jdbc");
			String query ="select r.designation, ediv.div_name, ed.dist_name, s.name,s.contact, s.email from role r inner join staff_assignment sa on r.role=sa.role_id inner join staff s on s.staff_id=sa.staff_id inner join estb_district ed on sa.office_code = ed.dist_id inner join estb_division ediv on ed.div_id=ediv.div_id where r.location_id='DIS' order by r.priority, ed.dist_name";
			
			return jdbcTemplate.query(query, new RowMapper<OfficersDto>() {
				@Override
				public OfficersDto mapRow(ResultSet rs, int ronNum) throws SQLException {
					OfficersDto officersDto = new OfficersDto();
					officersDto.setDesignation(rs.getString("designation"));
					officersDto.setDist_name(rs.getString("dist_name"));
					officersDto.setDiv_name(rs.getString("div_name"));
					officersDto.setName(rs.getString("name"));
					officersDto.setContact(rs.getString("contact"));
					officersDto.setEmail(rs.getString("email"));
					return officersDto;
				}
			});
		}
		catch (Exception e) {
			log.error("Error from dis api:jdbc"+e.getStackTrace());
			return null;
		}
	}
	
	@GetMapping("/getAllOfficersHqrApi")
	public List<OfficersDto> getAllOfficerByHQR() {
		try {
			log.info("Enter in HQ api :jdbc");
			String query ="select s.name, s.contact, s.email, r.designation from role r inner join staff_assignment sa on r.role=sa.role_id inner join staff s on s.staff_id=sa.staff_id where r.location_id='HQR' AND r.designation!='ADMIN' order by r.priority";
			
			return jdbcTemplate.query(query, new RowMapper<OfficersDto>() {
				@Override
				public OfficersDto mapRow(ResultSet rs, int ronNum) throws SQLException {
					OfficersDto officersDto = new OfficersDto();
					officersDto.setName(rs.getString("name"));
					officersDto.setContact(rs.getString("contact"));
					officersDto.setEmail(rs.getString("email"));
					officersDto.setDesignation(rs.getString("designation"));
					return officersDto;
				}
			});
		}
		catch (Exception e) {
			log.error("Error from dis api:jdbc"+e.getStackTrace());
			return null;
		}
	}
}
