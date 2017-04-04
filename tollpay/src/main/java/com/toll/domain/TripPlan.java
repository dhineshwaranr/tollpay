package com.toll.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "trip_seq")
public class TripPlan extends AbstractEntity{

	private String destinationFrom;
	private String destinationTo;
	private DateTime travelDate;
	private PassType passType;
	private User user;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDestinationFrom() {
		return destinationFrom;
	}

	public void setDestinationFrom(String destinationFrom) {
		this.destinationFrom = destinationFrom;
	}

	public String getDestinationTo() {
		return destinationTo;
	}

	public void setDestinationTo(String destinationTo) {
		this.destinationTo = destinationTo;
	}

	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(DateTime travelDate) {
		this.travelDate = travelDate;
	}

	public PassType getPassType() {
		return passType;
	}

	public void setPassType(PassType passType) {
		this.passType = passType;
	}

	public enum PassType{
		SINGLE("Single"),
		DOUBLE("Double");
		
		private PassType(String displayName){
			this.displayName = displayName;
		}
		
		private String displayName;

		public String getDisplayName() {
			return displayName;
		}
		
	}
	
}
