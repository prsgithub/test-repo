package com.sdrc.domain;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="url_feature_permission_scheme")
public class UrlFeaturePermissionScheme implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="url_id")
	private Integer urlId;
	
		
	@Column(name="url_name")
	private String urlName;
	
	@OneToOne
	@JoinColumn(name="feature_permission_id_fk")
	private FeaturePermissionMapping featurePermissionMapping;

	public Integer getUrlId() {
		return urlId;
	}

	public void setUrlId(Integer urlId) {
		this.urlId = urlId;
	}

	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

	public FeaturePermissionMapping getFeaturePermissionMapping() {
		return featurePermissionMapping;
	}

	public void setFeaturePermissionMapping(FeaturePermissionMapping featurePermissionMapping) {
		this.featurePermissionMapping = featurePermissionMapping;
	}

	@Override
	public String toString() {
		return "RoleFeaturePermissionScheme [" + (urlId != null ? "urlId=" + urlId + ", " : "")
				+ (urlName != null ? "urlName=" + urlName + ", " : "")
				+ (featurePermissionMapping != null ? "featurePermissionMapping=" + featurePermissionMapping : "")
				+ "]";
	}
	
	
	
	
}
