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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="user_area_mapping")
public class UserAreaMapping implements Serializable
{
	
	
	private static final long serialVersionUID = -2071160936110885287L;


	@Id
	@Column(name="user_area_mapping_id")
	private Integer userAreaMappingId;
	
	
	@ManyToOne
	@JoinColumn(name="user_id_fk")
	private MasterUser user;
	
	
	@ManyToOne
	@JoinColumn(name="area_id_fk")
	private MasterArea area;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="roleFeaturePermissionScheme",fetch=FetchType.LAZY)
	private List<UserRoleFeaturePermissionMapping> userRoleFeaturePermissionSchemes;

	
	public List<UserRoleFeaturePermissionMapping> getUserRoleFeaturePermissionSchemes() {
		return userRoleFeaturePermissionSchemes;
	}


	public void setUserRoleFeaturePermissionSchemes(
			List<UserRoleFeaturePermissionMapping> userRoleFeaturePermissionSchemes) {
		this.userRoleFeaturePermissionSchemes = userRoleFeaturePermissionSchemes;
	}


	public Integer getUserAreaMappingId() {
		return userAreaMappingId;
	}


	public void setUserAreaMappingId(Integer userAreaMappingId) {
		this.userAreaMappingId = userAreaMappingId;
	}


	public MasterUser getUser() {
		return user;
	}


	public void setUser(MasterUser user) {
		this.user = user;
	}


	public MasterArea getArea() {
		return area;
	}


	public void setArea(MasterArea area) {
		this.area = area;
	}


	


	@Override
	public String toString() {
		return "UserAreaMapping [userAreaMappingId=" + userAreaMappingId + ", user=" + user + ", area=" + area + "]";
	}


	
	

	
	
	
}
