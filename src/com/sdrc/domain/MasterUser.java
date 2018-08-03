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
@Table(name="mst_user")
public class MasterUser implements Serializable 
{

	private static final long serialVersionUID = 4364279566476248952L;

	@Id
	@Column(name = "user_id")
	private Integer userId;


	@Column(name = "user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="is_locked")
	private Boolean isLocked=false;
	
	@Column(name="is_active")
	private Boolean isActive=true;
	
	@JsonIgnore
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private List<UserAreaMapping> userAreaMappings;

	
	

	

	

	public List<UserAreaMapping> getUserAreaMappings() {
		return userAreaMappings;
	}

	public void setUserAreaMappings(List<UserAreaMapping> userAreaMappings) {
		this.userAreaMappings = userAreaMappings;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "MasterUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", isLocked="
				+ isLocked + ", isActive=" + isActive + "]";
	}


	

	

	
	
}
