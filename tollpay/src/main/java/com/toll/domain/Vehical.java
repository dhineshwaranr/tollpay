package com.toll.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "vehical_seq")
public class Vehical extends AbstractEntity{

	private String vehicalNo;
	private String manufacturer;
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getVehicalNo() {
		return vehicalNo;
	}
	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
	
}
