package com.toll.dto;

public class RfIdDto {

	private Long id;
	private String rfId;
	private String vehicalId;
	private Long userId;
	
	public RfIdDto(Long id, String rfId, String vehicalId, Long userId) {
		this.id = id;
		this.rfId = rfId;
		this.vehicalId = vehicalId;
		this.userId = userId;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
