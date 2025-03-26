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
@Table(name = "estb_district")
public class EstbDistrict{
	
	@Id
	@Column(name="dist_id")
	private Integer distId;
	
	//@Column(name="estb_dist_id")
	//private Integer estbDistId;
	
	@Column(name="dist_name")
	private String name;
	
	@Column(name="state_id")
	private Integer stateId;

	@Column(name="dist_name_hn")
	private String distNameHn;
	
	@Column(name="is_div_district")
	private boolean divDistrict;
	
	@Column(name="div_id")
	private Integer divId;

}