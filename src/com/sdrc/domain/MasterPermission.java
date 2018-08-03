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
@Table(name="mst_permission")
public class MasterPermission implements Serializable 
{

	private static final long serialVersionUID = 4364279566476248952L;

	@Id
	@Column(name = "permission_id")
	private Integer permissionId;


	@Column(name = "permission_name")
	private String permissionName;
	
	@JsonIgnore
	@OneToMany(mappedBy="permission",fetch=FetchType.LAZY)
	private List<FeaturePermissionMapping> featurePermissionMappings;

	

	public List<FeaturePermissionMapping> getFeaturePermissionMappings() {
		return featurePermissionMappings;
	}


	public void setFeaturePermissionMappings(List<FeaturePermissionMapping> featurePermissionMappings) {
		this.featurePermissionMappings = featurePermissionMappings;
	}


	public Integer getPermissionId() {
		return permissionId;
	}


	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}


	public String getPermissionName() {
		return permissionName;
	}


	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}


	@Override
	public String toString() {
		return "MasterPermission [" + (permissionId != null ? "permissionId=" + permissionId + ", " : "")
				+ (permissionName != null ? "permissionName=" + permissionName : "") + "]";
	}


	

	
	
}
