package com.ashokit.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.ashokit.entity.CityMaster;
import com.ashokit.entity.CountryMaster;
import com.ashokit.entity.StateMaster;
import com.ashokit.entity.UserMaster;
import com.ashokit.repo.CityMasterRepo;
import com.ashokit.repo.CountryMasterRepo;
import com.ashokit.repo.StateMasterRepo;
import com.ashokit.repo.UserMasterRepo;

public class UserSeviceImpl implements UserService {
	private static final boolean CountryMaster = false;
	private UserMasterRepo userrepo;
	@Autowired
	private CountryMasterRepo countryrepo;
	@Autowired
	private StateMasterRepo staterepo;
	@Autowired
	private CityMasterRepo cityrepo;

	@Override
	public Map<Integer, String> findCountries() {
		List<CountryMaster> countrylist = countryrepo.findAll();
		Map<Integer, String> countries = new HashMap<>();
		for (CountryMaster countryMaster : countrylist) {
			countries.put(countryMaster.getCountryId(), countryMaster.getCountryName());
		}

		return countries;
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId) {
		List<StateMaster> StateList = staterepo.findByCountryId(countryId);
		Map<Integer, String> states = new HashMap<>();
		for (StateMaster stateMaster : StateList) {
			states.put(stateMaster.getStateId(), stateMaster.getStateName());

		}

		return states;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {

		List<CityMaster> citylist = cityrepo.findByStateId(stateId);
		Map<Integer, String> cities = new HashMap<>();
		for (CityMaster cityMaster : citylist) {
			cities.put(cityMaster.getCityId(), cityMaster.getCityName());

		}

		return cities;
	}

	@Override
	public boolean isEmailUnique(String emailId) {
		UserMaster userMaster = userrepo.findByEmail(emailId);

		return userMaster.getUserId() == null;
	}

	@Override
	public boolean saveUser(UserMaster user) {
		user.setPwd(pwdGenerator());
		user.setAccstatus("LOCKED");
		UserMaster userobj = userrepo.save(user);

		return userobj.getUserId() != null;
	}

	private String pwdGenerator() {
		char[] pwd = new char[5];
		String alphaNumeric = "ABCDEFGHabcdefg123456789";
		Random randompwd = new Random();
		for (int i = 0; i < pwd.length; i++) {
			pwd[i] = alphaNumeric.charAt(randompwd.nextInt(alphaNumeric.length()));

		}

		return pwd.toString();

	}

	@Override
	public String loginCheck(String email, String pwd) {
		UserMaster user = userrepo.findByEmailAndPwd(email, pwd);
		if (user != null) {
			if (user.getAccstatus().equals("LOCKED")) {
				return "Account locked";

			} else {
				return "Login Success";
			}

		}
		return "User Does not Exist";
	}

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
		UserMaster user = userrepo.findByEmail(email);
		user.setAccstatus("UNLOCKED");
		if (user.getPwd() == tempPwd) {
			userrepo.save(user);
          return true;
		} else {
			return false;
			
		}
	}

	@Override
	public boolean unlockAccount(String email, String newPwd) {
		             UserMaster user = userrepo.findByEmail(email);
		             user.setPwd(newPwd);
		             if (user.getAccstatus().equals("UNLOCKED")) {
		            	 userrepo.save(user );
		            	return true;
						
					}else {
						return false;
					}
		            
		           
	}

	@Override
	public String forgotPassword(String email) {
		
		return null;
	}

}
