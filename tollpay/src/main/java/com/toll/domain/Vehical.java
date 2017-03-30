package com.toll.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author dhineshwaranr
 *
 */
@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "vehical_seq")
public class Vehical extends AbstractEntity{

	private String vehicalNo;
	private String manufacturer;
	private boolean isAllowed;
	private boolean isAnyCrimicalCase;
	private RTO rto;
	private VehicalType type;
    private Long totalCapacity;
    private User user;
	
    public boolean isAllowed() {
		return isAllowed;
	}
	public void setAllowed(boolean isAllowed) {
		this.isAllowed = isAllowed;
	}
	public boolean isAnyCrimicalCase() {
		return isAnyCrimicalCase;
	}
	public void setAnyCrimicalCase(boolean isAnyCrimicalCase) {
		this.isAnyCrimicalCase = isAnyCrimicalCase;
	}
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	public RTO getRto() {
		return rto;
	}
	public void setRto(RTO rto) {
		this.rto = rto;
	}
	public VehicalType getType() {
		return type;
	}
	public void setType(VehicalType type) {
		this.type = type;
	}
	public Long getTotalCapacity() {
		return totalCapacity;
	}
	public void setTotalCapacity(Long totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
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
	
	public enum VehicalType {
		
		CAR("Car"),
		BUS("Bus"),
		GOVERMENT_VEHICAL(""),
		OMNI_BUS(""),
		CAB(""),
		LORRY(""),
		JEEP("");

        private final String displayName;

        private VehicalType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
	
}
