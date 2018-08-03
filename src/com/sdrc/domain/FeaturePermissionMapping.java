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
@Table(name="feature_permission_mapping")
public class FeaturePermissionMapping implements Serializable
{
	
	
	private static final long serialVersionUID = -2071160936110885287L;


	@Id
	@Column(name="feature_permission_mapping_id")
	private Integer featurePermissionMappingId;
	
	
	@ManyToOne
	@JoinColumn(name="feature_id_fk")
	private MasterFeature feature;
	
	
	@ManyToOne
	@JoinColumn(name="permission_id_fk")
	private MasterPermission permission;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="featurePermissionMapping",fetch=FetchType.LAZY)
	private List<RoleFeaturePermissionScheme> roleFeaturePermissionSchemes;

	
	
	public Integer getFeaturePermissionMappingId() {
		return featurePermissionMappingId;
	}


	public void setFeaturePermissionMappingId(Integer featurePermissionMappingId) {
		this.featurePermissionMappingId = featurePermissionMappingId;
	}


	public MasterFeature getFeature() {
		return feature;
	}


	public void setFeature(MasterFeature feature) {
		this.feature = feature;
	}


	public MasterPermission getPermission() {
		return permission;
	}


	public void setPermission(MasterPermission permission) {
		this.permission = permission;
	}


	public List<RoleFeaturePermissionScheme> getRoleFeaturePermissionSchemes() {
		return roleFeaturePermissionSchemes;
	}


	public void setRoleFeaturePermissionSchemes(List<RoleFeaturePermissionScheme> roleFeaturePermissionSchemes) {
		this.roleFeaturePermissionSchemes = roleFeaturePermissionSchemes;
	}


	@Override
	public String toString() {
		return "FeaturePermissionMapping ["
				+ (featurePermissionMappingId != null
						? "featurePermissionMappingId=" + featurePermissionMappingId + ", " : "")
				+ (feature != null ? "feature=" + feature + ", " : "")
				+ (permission != null ? "permission=" + permission + ", " : "") + (roleFeaturePermissionSchemes != null
						? "roleFeaturePermissionSchemes=" + roleFeaturePermissionSchemes : "")
				+ "]";
	}


	

	

	
	
	
}
