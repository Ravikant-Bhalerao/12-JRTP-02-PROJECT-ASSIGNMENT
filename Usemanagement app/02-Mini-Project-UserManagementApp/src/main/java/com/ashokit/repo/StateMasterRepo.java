package com.ashokit.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.StateMaster;

public interface StateMasterRepo extends JpaRepository<StateMaster, Serializable> {
	public List<StateMaster> findByCountryId(Integer countryId);

}
