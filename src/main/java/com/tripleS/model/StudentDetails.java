package com.tripleS.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Student_Entity_Details")
public class StudentDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="Mother_Tongue")
	@NotEmpty(message = "*Please provide mother tongue")
    private String motherTongue;
	
	@Column(name="Religion")
	@NotEmpty(message = "*Please provide religion")
    private String religion;
	
	@Column(name="Describe_Prize_Details")
    private String describePrizeDetails;
	
	@Column(name="Aim_In_Life")
	//@NotEmpty(message = "*Please provide aim in life")
    private String aimInLife;
	
	@Column(name="Describe_Job_Business_Details")
    private String describeJobBusinessDetails;
	
	@Column(name="Describe_Other_Problems_In_Family")
    private String describeOtherProblemsInFamily;
	
	@Column(name="Got_Help_From_Other_Sources")
    private Boolean gotHelpFromOtherSources;
	
	@Column(name="Have_Education_Loan")
    private Boolean haveEducationLoan;
	
	@Column(name="Describe_If_Other_Family_Members_Got_Help")
    private String describeIfOtherFamilyMembersGotHelp;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date_Of_Birth")
	@NotNull(message = "*Please provide date of birth")
    private Date dateOfBirth;
	
	@Column(name="Place_Of_Birth")
	@NotEmpty(message = "*Please provide place of birth")
    private String placeOfBirth;
	
	@OneToOne(mappedBy = "studentDetails")
	private EntityDetails entityDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getDescribePrizeDetails() {
		return describePrizeDetails;
	}

	public void setDescribePrizeDetails(String describePrizeDetails) {
		this.describePrizeDetails = describePrizeDetails;
	}

	public String getAimInLife() {
		return aimInLife;
	}

	public void setAimInLife(String aimInLife) {
		this.aimInLife = aimInLife;
	}

	public String getDescribeJobBusinessDetails() {
		return describeJobBusinessDetails;
	}

	public void setDescribeJobBusinessDetails(String describeJobBusinessDetails) {
		this.describeJobBusinessDetails = describeJobBusinessDetails;
	}

	public String getDescribeOtherProblemsInFamily() {
		return describeOtherProblemsInFamily;
	}

	public void setDescribeOtherProblemsInFamily(String describeOtherProblemsInFamily) {
		this.describeOtherProblemsInFamily = describeOtherProblemsInFamily;
	}

	public Boolean getGotHelpFromOtherSources() {
		return gotHelpFromOtherSources;
	}

	public void setGotHelpFromOtherSources(Boolean gotHelpFromOtherSources) {
		this.gotHelpFromOtherSources = gotHelpFromOtherSources;
	}

	public Boolean getHaveEducationLoan() {
		return haveEducationLoan;
	}

	public void setHaveEducationLoan(Boolean haveEducationLoan) {
		this.haveEducationLoan = haveEducationLoan;
	}

	public String getDescribeIfOtherFamilyMembersGotHelp() {
		return describeIfOtherFamilyMembersGotHelp;
	}

	public void setDescribeIfOtherFamilyMembersGotHelp(String describeIfOtherFamilyMembersGotHelp) {
		this.describeIfOtherFamilyMembersGotHelp = describeIfOtherFamilyMembersGotHelp;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public EntityDetails getEntityDetails() {
		return entityDetails;
	}

	public void setEntityDetails(EntityDetails entityDetails) {
		this.entityDetails = entityDetails;
	}
}
