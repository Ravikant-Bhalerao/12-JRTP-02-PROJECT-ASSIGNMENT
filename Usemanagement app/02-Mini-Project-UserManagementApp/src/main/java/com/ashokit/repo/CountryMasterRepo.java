package com.ashokit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.CountryMaster;

public interface CountryMasterRepo extends JpaRepository<CountryMaster, Serializable> {

}
