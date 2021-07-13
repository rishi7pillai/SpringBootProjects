package com.smartmanager.smartmanager.dao;

import com.smartmanager.smartmanager.config.MyUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import com.smartmanager.smartmanager.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoDao extends JpaRepository<UserInfo,Integer> {
	
	@Query("select u from UserInfo u where u.email=:email")
	public UserInfo getUserByUserName(@Param("email") String email);

}
