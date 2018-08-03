package com.sdrc.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="mst_role")
public class MasterRole implements Serializable 
{

	private static final long serialVersionUID = 4364279566476248952L;

	@Id
	@Column(name = "role_id")
	private Integer roleId;


	@Column(name = "role_name")
	private String roleName;
	
	


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	@Override
	public String toString() {
		return "MasterRole [" + (roleId != null ? "roleId=" + roleId + ", " : "")
				+ (roleName != null ? "roleName=" + roleName : "") + "]";
	}


	


	

	
	
}
