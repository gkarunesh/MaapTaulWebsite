/**
 * 
 */
package com.lmd.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmd.web.entity.Division;

/**
 * @author sudhakar
 *
 */
//@NoRepositoryBean
public interface DivisionRepository extends JpaRepository<Division, Integer>{

}
