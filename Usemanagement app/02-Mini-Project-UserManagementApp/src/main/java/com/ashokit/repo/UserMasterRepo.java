package com.ashokit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.UserMaster;

public interface UserMasterRepo extends JpaRepository<UserMaster,Serializable> {
	public UserMaster findByEmail(String email) ;
    public UserMaster findByEmailAndPwd(String email,String pwd);
}
