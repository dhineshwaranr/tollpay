package com.toll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class Order extends AbstractEntity{

	private User user;
	private Frequency frequency;
	private Status status = Status.PENDING;
        
    public enum Status {
		PENDING,
		PAID,
		FAILED,
		CANCELLED
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

   	
}
