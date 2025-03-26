/**
 * 
 */
package com.lmd.web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmd.web.entity.SubDivision;

/**
 * @author karunesh
 *
 */
public interface SubDivisionRepo extends JpaRepository<SubDivision, Integer>{
	
	List<SubDivision> findByDistId(Integer distId);
}
