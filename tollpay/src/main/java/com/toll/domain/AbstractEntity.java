package com.toll.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.joda.time.DateTime;

@MappedSuperclass
public class AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	//private DateTime createdDate;
	
	/*@PrePersist
    private void onCreate() {
        this.setCreatedDate(new DateTime());
    }*/
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "idgen")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/*public DateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
		
}
