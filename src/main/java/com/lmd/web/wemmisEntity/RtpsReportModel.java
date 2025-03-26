package com.lmd.web.wemmisEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Karunesh
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "RtpsReportModel")
public class RtpsReportModel {
	
	@Id
    private String  nameOfService; 
	
	private Long applications;
	
	private Long withIntime; 
	
	private Long outSideTime; 
	
	private Long withIntime2; 
	
	private Integer outSideTime2;
	
	private Integer avrageTime; 
	
	private Integer minTime; 
	
	private Integer maxTime; 
	
	
	
}
