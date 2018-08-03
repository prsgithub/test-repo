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
@Table(name="role_feature_permission_scheme")
public class RoleFeaturePermissionScheme implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_feature_permission_scheme_id")
	private Integer roleFeaturePermissionSchemeId;
	
		
	@ManyToOne
	@JoinColumn(name="role_id_fk", nullable = false)
	private MasterRole role;
	
	@ManyToOne
	@JoinColumn(name="feature_permission_id_fk")
	private FeaturePermissionMapping featurePermissionMapping;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy="roleFeaturePermissionScheme",fetch=FetchType.LAZY)
	private List<UserRoleFeaturePermissionMapping> userRoleFeaturePermissionMappings;



	public Integer getRoleFeaturePermissionSchemeId() {
		return roleFeaturePermissionSchemeId;
	}



	public void setRoleFeaturePermissionSchemeId(Integer roleFeaturePermissionSchemeId) {
		this.roleFeaturePermissionSchemeId = roleFeaturePermissionSchemeId;
	}



	public MasterRole getRole() {
		return role;
	}



	public void setRole(MasterRole role) {
		this.role = role;
	}



	public FeaturePermissionMapping getFeaturePermissionMapping() {
		return featurePermissionMapping;
	}



	public void setFeaturePermissionMapping(FeaturePermissionMapping featurePermissionMapping) {
		this.featurePermissionMapping = featurePermissionMapping;
	}



	public List<UserRoleFeaturePermissionMapping> getUserRoleFeaturePermissionMappings() {
		return userRoleFeaturePermissionMappings;
	}



	public void setUserRoleFeaturePermissionMappings(
			List<UserRoleFeaturePermissionMapping> userRoleFeaturePermissionMappings) {
		this.userRoleFeaturePermissionMappings = userRoleFeaturePermissionMappings;
	}



	@Override
	public String toString() {
		return "RoleFeaturePermissionScheme ["
				+ (roleFeaturePermissionSchemeId != null
						? "roleFeaturePermissionSchemeId=" + roleFeaturePermissionSchemeId + ", " : "")
				+ (role != null ? "role=" + role + ", " : "")
				+ (featurePermissionMapping != null ? "featurePermissionMapping=" + featurePermissionMapping + ", "
						: "")
				+ (userRoleFeaturePermissionMappings != null
						? "userRoleFeaturePermissionMappings=" + userRoleFeaturePermissionMappings : "")
				+ "]";
	}

	
	
	

}
