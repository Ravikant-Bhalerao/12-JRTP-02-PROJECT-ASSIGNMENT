package com.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_MASTER")
public class UserMaster {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue
	private Integer userId;
	@Column(name = "FNAME")
	private String fname;
	@Column(name = "LNAME")
	private String lname;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHNO")
	private String phno;
	@Column(name = "DOB")
	private String dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "COUNTRY")
	private Integer country;
	@Column(name = "STATE")
	private Integer state;
	@Column(name = "CITY")
	private Integer city;
	@Column(name = "PWD")
	private String pwd;
	@Column(name = "ACC_STATUS ")

	private String accstatus;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAccstatus() {
		return accstatus;
	}

	public void setAccstatus(String accstatus) {
		this.accstatus = accstatus;
	}

	@Override
	public String toString() {
		return "UserMaster [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", phno="
				+ phno + ", dob=" + dob + ", gender=" + gender + ", country=" + country + ", state=" + state + ", city="
				+ city + ", pwd=" + pwd + ", accstatus=" + accstatus + "]";
	}

}
