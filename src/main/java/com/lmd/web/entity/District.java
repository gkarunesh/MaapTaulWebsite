package com.lmd.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "adm_district")
public class District {
	
	@Id
	@Column(name = "dist_id")
	private Integer distId;
	
	@Column(name = "dist_name")
	private String distName;
	
	@Column(name = "dist_name_hn")
	private String distNameHindi;
	
	@Column(name = "estb_dist_id")
	private Integer estbDistId;
	
	@Column(name = "state_id")
	private Integer stateId;

}
