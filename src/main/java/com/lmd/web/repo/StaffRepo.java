package com.lmd.web.repo;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lmd.web.dto.OfficersDtoInterface;
import com.lmd.web.entity.Staff;

/**
 * @author sudhakar
 *
 */
public interface StaffRepo extends JpaRepository<Staff, String> {
	
	@Transactional
	@Query(value = "select s.name, s.contact, s.email, r.designation from role r inner join staff_assignment sa on r.role=sa.role_id inner join staff s on s.staff_id=sa.staff_id where r.location_id='HQR' AND r.designation!='ADMIN' order by r.priority", nativeQuery = true)
	public List<OfficersDtoInterface> getStaffByHQR();
	
	@Transactional
	@Query(value = "select r.designation, ed.div_name, s.name,s.contact, s.email from role r inner join staff_assignment sa on r.role=sa.role_id inner join staff s on s.staff_id=sa.staff_id inner join estb_division ed on sa.office_code = ed.div_id where r.location_id='DIV' order by r.priority, ed.div_name", nativeQuery = true)
	public List<OfficersDtoInterface> getStaffByDIV();
	
	@Transactional
	@Query(value = "select r.designation, ediv.div_name, ed.dist_name, s.name,s.contact, s.email from role r inner join staff_assignment sa on r.role=sa.role_id inner join staff s on s.staff_id=sa.staff_id inner join estb_district ed on sa.office_code = ed.dist_id inner join estb_division ediv on ed.div_id=ediv.div_id where r.location_id='DIS' order by r.priority, ed.dist_name", nativeQuery = true)
	public List<OfficersDtoInterface> getStaffByDIS();
	
	@Transactional
	@Query(value = "select r.designation, ed.dist_name, es.sub_div_name, s.name,s.contact, s.email from role r inner join staff_assignment sa on r.role=sa.role_id inner join staff s on s.staff_id=sa.staff_id inner join estb_subdivision es on sa.office_code = es.sub_div_id inner join adm_district ed ON es.adm_dist_id = ed.dist_id where r.location_id='SUB' order by r.priority,ed.dist_name, es.sub_div_name", nativeQuery = true)
	public List<OfficersDtoInterface> getStaffBySUB();
}