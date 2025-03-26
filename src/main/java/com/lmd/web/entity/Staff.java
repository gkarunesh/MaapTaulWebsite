package com.lmd.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author sudhakar
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Setter
@Getter
@Table(name = "staff")
public class Staff implements Serializable {

	private static final long serialVersionUID = -7881586222122973718L;
	
	@Id
	@Column(name = "staff_id")
	private String staffId;
	
	@Column(name = "login_id")
	private String userId;	
	
	@Column(name = "emp_code")
	private String empCode;
	
	private String name;
	
	@Column(name = "is_active")
	private String active;
	
	private String address;
	
	private String contact;
	
	private String email;
	
	private String remarks;
	
	private String designation;
	
	private String sex;	
	
}
