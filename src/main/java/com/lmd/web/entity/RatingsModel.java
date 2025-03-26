package com.lmd.web.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Karunesh
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ratings")
public class RatingsModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rateid; 
	
	@Column(name="rateondesign")
	private Integer rateOnDesign; 
	
	@Column(name="rateonfriendly")
	private Integer rateOnFriendly; 
	
	@Column(name="rateonperformance")
	private Integer rateOnPerformance; 
	
	@Column(name="rateoncontent")
	private Integer rateOnContent; 
	
	@Column(name="atr")
	private Integer rateOnATR;
	
	@Column(name="overallrating")
	private Integer overallRating; 
	
	private char status; 
	
	private String name; 
	
	private String email; 
	
	private String mobile;
	
	@Column(name="ipaddress")
	private String ipAddress;
	
	@Column(name="date_time")
	private LocalDateTime dateTime;
	
	private String remarks;

	private Integer rate;

	@Override
	public String toString() {
		return "RatingsModel [rateid=" + rateid + ", rateOnDesign=" + rateOnDesign + ", rateOnFriendly="
				+ rateOnFriendly + ", rateOnPerformance=" + rateOnPerformance + ", rateOnContent=" + rateOnContent
				+ ", rateOnATR=" + rateOnATR + ", overallRating=" + overallRating + ", status=" + status + ", name="
				+ name + ", email=" + email + ", mobile=" + mobile + ", ipAddress=" + ipAddress + ", dateTime="
				+ dateTime + ", remarks=" + remarks + ", rate=" + rate + "]";
	}
				
}