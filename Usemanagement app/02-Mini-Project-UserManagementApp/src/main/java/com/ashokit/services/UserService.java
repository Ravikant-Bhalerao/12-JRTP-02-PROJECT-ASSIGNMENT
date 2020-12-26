package com.ashokit.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ashokit.entity.UserMaster;

@Service
public interface UserService {
	public Map<Integer, String> findCountries();

	public Map<Integer, String> findStates(Integer countryId);

	public Map<Integer, String> findCities(Integer stateId);

	public boolean isEmailUnique(String emailId);

	public boolean saveUser(UserMaster um);

	public String loginCheck(String email, String pwd);

	// Unlock Account Operations
	public boolean isTempPwdValid(String email, String tempPwd);

	public boolean unlockAccount(String email, String newPwd);

	// Forgot Password Operations
	public String forgotPassword(String email);

}
