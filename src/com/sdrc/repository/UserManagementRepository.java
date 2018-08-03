package com.sdrc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sdrc.domain.MasterUser;

public interface UserManagementRepository extends JpaRepository<MasterUser, Integer> 
{
	MasterUser findByUserId(Integer uid);
	

	@Query("SELECT ufpm.urlId, ufpm.urlName, mf.featureId, mf.featureName, mp.permissionId,mp.permissionName ,mr.roleId,mr.roleName "
			+ "  FROM UrlFeaturePermissionScheme ufpm "
			+ "  join ufpm.featurePermissionMapping  fpm"
			+ "	 join fpm.feature mf "
			+ "	 join fpm.permission mp "
			+ "  join fpm.roleFeaturePermissionSchemes rfps "
			+ "	 join rfps.role mr "
			+ "WHERE ufpm.urlName=:urlName")
	List<Object[]> getRoleFeaturePermissionByUrlName(@Param("urlName") String urlName);
	
	@Query("SELECT fpm.featurePermissionMappingId, mf.featureName, mp.permissionName  "
			+ "  FROM UrlFeaturePermissionScheme ufpm "
			+ "  join ufpm.featurePermissionMapping  fpm"
			+ "	 join fpm.feature mf "
			+ "	 join fpm.permission mp "
			+ "WHERE ufpm.urlName=:urlName")
	List<Object[]> getFeaturePermissionByUrlName(@Param("urlName") String urlName);
	
	@Query("SELECT mr.roleName  "
			+ "  FROM RoleFeaturePermissionScheme rfps "
			+ "	 join rfps.role mr "
			+ "WHERE rfps.featurePermissionMapping.featurePermissionMappingId=:featurePermissionMappingId")
	List<String> getRolesByFeaturePermissionId(@Param("featurePermissionMappingId") Integer fpId);

}
