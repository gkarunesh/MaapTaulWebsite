/**
 * 
 */
package com.lmd.web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmd.web.entity.RatingsModel;

/**
 * @author karunesh
 *
 */
public interface RatingRepository extends JpaRepository<RatingsModel, Integer>{
	
	public List<RatingsModel> findByStatus(char status);

	//@Transactional
    //@Modifying
	//@Query("update RatingsModel r set r.status = :status where r.rateid=:id")
    //public int update(@Param("id") Integer id, @Param("status") char status);

}
