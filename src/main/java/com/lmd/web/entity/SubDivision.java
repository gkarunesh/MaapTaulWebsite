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
@Table(name = "estb_subdivision")
public class SubDivision{
	
	@Id
	@Column(name = "sub_div_id")
	private Integer subDivId;
	
	@Column(name="dist_id")
	private Integer distId;
	
	@Column(name="sub_div_name")
	private String subDivName;
	
	@Column(name="sub_div_name_hin")
	private String subDivNameHin;
	
	@Column(name="adm_dist_id")
	private Integer admDistId;

}