package com.ashokit.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.CityMaster;

public interface CityMasterRepo extends JpaRepository<CityMaster, Serializable> {
	public List<CityMaster> findByStateId(Integer sid);

}
