package com.sdrc.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="mst_area")
public class MasterArea implements Serializable 
{

	private static final long serialVersionUID = 4364279566476248952L;
	
	@Id
	@Column(name = "area_id")
	private Integer areaId;


	@Column(name = "area_name")
	private String areaName;
	
	@JsonIgnore
	@OneToMany(mappedBy="area",fetch=FetchType.LAZY)
	private List<UserAreaMapping> userAreaMappings;

	
	


	public List<UserAreaMapping> getUserAreaMappings() {
		return userAreaMappings;
	}


	public void setUserAreaMappings(List<UserAreaMapping> userAreaMappings) {
		this.userAreaMappings = userAreaMappings;
	}


	public Integer getAreaId() {
		return areaId;
	}


	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}


	public String getAreaName() {
		return areaName;
	}


	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	@Override
	public String toString() {
		return "MasterArea [areaId=" + areaId + ", areaName=" + areaName + "]";
	}


	

	
	
}
