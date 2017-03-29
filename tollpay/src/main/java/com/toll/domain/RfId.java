package com.toll.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "rfid_seq")
public class RfId extends AbstractEntity{

	private String rfId;
	private Vehical vehical;
	
	public String getRfId() {
		return rfId;
	}
	public void setRfId(String rfId) {
		this.rfId = rfId;
	}
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	public Vehical getVehical() {
		return vehical;
	}
	public void setVehical(Vehical vehical) {
		this.vehical = vehical;
	}
		
}
