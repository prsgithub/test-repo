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
@Table(name="mst_feature")
public class MasterFeature implements Serializable 
{

	private static final long serialVersionUID = 4364279566476248952L;

	@Id
	@Column(name = "feature_id")
	private Integer featureId;


	@Column(name = "feature_name")
	private String featureName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "feature", fetch = FetchType.LAZY)
	private List<FeaturePermissionMapping> featurePermissionMappings;
	
	
	

	

	public List<FeaturePermissionMapping> getFeaturePermissionMappings() {
		return featurePermissionMappings;
	}


	public void setFeaturePermissionMappings(List<FeaturePermissionMapping> featurePermissionMappings) {
		this.featurePermissionMappings = featurePermissionMappings;
	}


	public Integer getFeatureId() {
		return featureId;
	}


	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}


	public String getFeatureName() {
		return featureName;
	}


	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}


	@Override
	public String toString() {
		return "MasterFeature [featureId=" + featureId + ", featureName=" + featureName + "]";
	}


	

	
	
}
