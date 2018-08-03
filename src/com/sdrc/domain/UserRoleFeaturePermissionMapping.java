package com.sdrc.domain;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="user_role_feature_permission_mapping")
public class UserRoleFeaturePermissionMapping implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_role_feature_permission_id")
	private Integer userRoleFeaturePermissionId;
	
	@ManyToOne
	@JoinColumn(name="role_feature_permission_scheme_id_fk")
	private RoleFeaturePermissionScheme roleFeaturePermissionScheme;
	
	@ManyToOne
	@JoinColumn(name="user_area_mapping_id_fk")
	private UserAreaMapping userAreaMapping;

	public Integer getUserRoleFeaturePermissionId() {
		return userRoleFeaturePermissionId;
	}

	public void setUserRoleFeaturePermissionId(Integer userRoleFeaturePermissionId) {
		this.userRoleFeaturePermissionId = userRoleFeaturePermissionId;
	}

	public RoleFeaturePermissionScheme getRoleFeaturePermissionScheme() {
		return roleFeaturePermissionScheme;
	}

	public void setRoleFeaturePermissionScheme(RoleFeaturePermissionScheme roleFeaturePermissionScheme) {
		this.roleFeaturePermissionScheme = roleFeaturePermissionScheme;
	}

	public UserAreaMapping getUserAreaMapping() {
		return userAreaMapping;
	}

	public void setUserAreaMapping(UserAreaMapping userAreaMapping) {
		this.userAreaMapping = userAreaMapping;
	}

	@Override
	public String toString() {
		return "UserRoleFeaturePermissionMapping ["
				+ (userRoleFeaturePermissionId != null
						? "userRoleFeaturePermissionId=" + userRoleFeaturePermissionId + ", " : "")
				+ (roleFeaturePermissionScheme != null
						? "roleFeaturePermissionScheme=" + roleFeaturePermissionScheme + ", " : "")
				+ (userAreaMapping != null ? "userAreaMapping=" + userAreaMapping : "") + "]";
	}
	
	
	
}
