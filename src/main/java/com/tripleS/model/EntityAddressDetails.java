package com.tripleS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Entity_Address_Details")
public class EntityAddressDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="Address_Type")
    private String type;
	
	@Column(name="Address_Line1")
	@NotEmpty(message = "*Please provide Address Line 1")
    private String addressLine1;
	
	@Column(name="Address_Line2")
    private String addressLine2;
	
	@Column(name="City")
	@NotEmpty(message = "*Please provide City")
    private String city;
	
	@Column(name="State")
	@NotEmpty(message = "*Please provide State")
    private String state;
	
	@Column(name="Country")
	@NotEmpty(message = "*Please provide Country")
    private String country;
	
	@Column(name="Pincode")
	@Pattern(regexp="(^$|[0-9]{6})", message = "*Pincode must be exactly 6 digits")
	@NotEmpty(message = "*Please provide Pincode")
    private String pincode;
	
	@OneToOne(mappedBy = "entityAddressDetails")
	private EntityDetails entityDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public EntityDetails getEntityDetails() {
		return entityDetails;
	}

	public void setEntityDetails(EntityDetails entityDetails) {
		this.entityDetails = entityDetails;
	}
	
}
