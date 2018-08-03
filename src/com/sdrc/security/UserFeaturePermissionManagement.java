package com.sdrc.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.sdrc.repository.UserManagementRepository;

@Component(value="userFeaturePermissionManagement")
public class UserFeaturePermissionManagement 
{

	@Autowired
	UserManagementRepository repo;
	
	public boolean userHasPermissionForURL(final Authentication auth, String url) 
	{
		
		List<String> userRoles=new ArrayList<String>();
		List<String> userFeatures=new ArrayList<String>();
		List<String> userPermissions=new ArrayList<String>();
		
    	User user = (User) auth.getPrincipal();
    	Collection<GrantedAuthority> authorities=user.getAuthorities();
    	Iterator<GrantedAuthority> itr=authorities.iterator();
    	while(itr.hasNext())
    	{
    		GrantedAuthority grantAuth=itr.next();
    		String rfp=grantAuth.getAuthority();
        	String userRole=rfp.split(":")[0];
        	String userFeature=rfp.split(":")[1].split(",")[0];
        	String userPermission=rfp.split(":")[1].split(",")[1];
        	userRoles.add(userRole);
        	userFeatures.add(userFeature);
        	userPermissions.add(userPermission);
    	}
    	
		Object[] objArr=repo.getFeaturePermissionByUrlName(url).get(0);
		Integer featurePermissionId=Integer.parseInt(objArr[0].toString());
		List<String> urlRoles=repo.getRolesByFeaturePermissionId(featurePermissionId);
		String urlFeature=objArr[1].toString();
		String urlPermission=objArr[2].toString();
    	
        userRoles.retainAll(urlRoles);
        if(userRoles.size() > 0 && userFeatures.contains(urlFeature)
    							&& userPermissions.contains(urlPermission))
    	{
    		return true;
    	}
    	
    	else
    	{
    		return false;
    	}
        
		
	}
}
