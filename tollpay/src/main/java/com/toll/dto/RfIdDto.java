package com.toll.dto;

public class RfIdDto {

	private Long id;
	private String rfId;
	private String vehicalId;
	
	public RfIdDto(Long id, String rfId, String vehicalId) {
		this.id = id;
		this.rfId = rfId;
		this.vehicalId = vehicalId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRfId() {
		return rfId;
	}
	public void setRfId(String rfId) {
		this.rfId = rfId;
	}
	public String getVehicalId() {
		return vehicalId;
	}
	public void setVehicalId(String vehicalId) {
		this.vehicalId = vehicalId;
	}
	
	
	
}
