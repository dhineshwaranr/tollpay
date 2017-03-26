package com.toll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

//@Entity
//@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "payment_seq")
public class PaymentRecords {
	
	private Order order;
	private PaymentMethod paymentMethod;
	private Double amount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private DateTime paymentDate;
	private String paymentReference;
	private PaymentStatus status;
	
	public enum PaymentStatus {
	    NEW,
        PAID,
        REFUNDED,
	    ARCHIVED;
    }

    public enum PaymentMethod {
		CREDITCARD("CreditCard"),
		EFT("EFT");

		private final String displayName;

		private PaymentMethod(String displayName) {
			this.displayName = displayName;
		}

		public String getDisplayName() {
			return displayName;
		}
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Column(nullable = false)
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(DateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentReference() {
		return paymentReference;
	}
	
	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
	public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

}
