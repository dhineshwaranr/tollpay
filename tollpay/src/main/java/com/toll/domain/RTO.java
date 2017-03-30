package com.toll.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "rto_seq")
public class RTO extends AbstractEntity{

	private Address address;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
