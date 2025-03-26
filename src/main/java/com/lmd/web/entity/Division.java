package com.lmd.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author karunesh
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "estb_division")
public class Division{
	/**
	 * 
	 */
	
	@Id
	@Column(name="div_id")
	private Integer divId;
	
	@Column(name="div_name")
	private String divName;
	
	@Column(name="state_id")
	private Integer stateId;

	/*
	 * @Override public String toString() { return "Division [divId=" + divId +
	 * ", divName=" + divName + ", stateId=" + stateId + "]"; }
	 */
	
}
