/**
 * Copyright © NIC. All rights reserved.


 *
 * This software is the confidential and proprietary information 
 * of NIC.You shall not disclose such Confidential Information and 
 * shall use it only in accordance with the terms and conditions 
 * entered into with NIC.
 *
 * Id: LoginAuthenticationService.java,v 1.1
 *
 * Date Author Changes
 * Jul 29, 2017, 11:25:30 PM  prakash Created
 */
package com.sdrc.security;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sdrc.domain.MasterUser;
import com.sdrc.domain.RoleFeaturePermissionScheme;
import com.sdrc.domain.UserAreaMapping;
import com.sdrc.domain.UserRoleFeaturePermissionMapping;
import com.sdrc.repository.UserManagementRepository;
 
@Service("loginAuthenticationService")
public class LoginAuthenticationService implements UserDetailsService 
{
	@Autowired
	UserManagementRepository userRepo;
	
	@Override
    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
 	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException 
    {
    	if(userName == null || userName.isEmpty())
    	{
    		throw new UsernameNotFoundException("User Id is empty.");
    	}
    	Integer userId=Integer.parseInt(userName);
    	
    	MasterUser user=userRepo.findByUserId(userId);
    	//System.out.println("user----------------------------------------------------"+user);
    	
    	if(user == null )
    	{
    		throw new UsernameNotFoundException("User not found.");
    	}
    	
       /* List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+user.getRoleId().toUpperCase());
        grantList.add(authority);*/
 
        Boolean acNonExpired = user.getIsActive();
        Boolean credentialsNonExpired = user.getIsActive();
        Boolean enabled = user.getIsActive();
        Boolean acNonLocked = !(user.getIsLocked());
        String  dbPassword=user.getPassword();
        
        
        
        Collection<UserAreaMapping> areaMappings = user.getUserAreaMappings();
        
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (UserAreaMapping userAreaMapping : areaMappings) {	
			List<UserRoleFeaturePermissionMapping> featureAndPermissions = userAreaMapping.getUserRoleFeaturePermissionSchemes();
			
			for (UserRoleFeaturePermissionMapping userRoleFeaturePermissionMapping : featureAndPermissions) {
				
				RoleFeaturePermissionScheme roleFeaturePermissionScheme = userRoleFeaturePermissionMapping.getRoleFeaturePermissionScheme();
				
				grantedAuthorities.add(new SimpleGrantedAuthority(
						
						roleFeaturePermissionScheme.getRole().getRoleName().concat(":").
						
						concat(roleFeaturePermissionScheme.getFeaturePermissionMapping().getFeature().getFeatureName()).concat(",")
						
						.concat(roleFeaturePermissionScheme.getFeaturePermissionMapping().getPermission().getPermissionName())));
				
				System.out.println();
				System.out.println("Granted Authorities To User=====                       "+roleFeaturePermissionScheme.getRole().getRoleName().toUpperCase().concat(":").
							concat(roleFeaturePermissionScheme.getFeaturePermissionMapping().getFeature().getFeatureName())
							.concat(",").concat(roleFeaturePermissionScheme.getFeaturePermissionMapping().getPermission().getPermissionName()));
				System.out.println();
			}
        } 
 
        return (UserDetails) new User(userName, dbPassword, enabled,acNonExpired, credentialsNonExpired, acNonLocked, grantedAuthorities);
   	}
 
}