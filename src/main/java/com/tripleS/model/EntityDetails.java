package com.tripleS.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Entity_Details")
public class EntityDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="Entity_Type")
    private String type;
	
	@Column(name="Entity_Category")
    private String category;
	
	@Column(name="First_Name")
    private String firstName;
	
	@Column(name="Middle_Name")
    private String middleName;
	
	@Column(name="Last_Name")
    private String lastName;
	
	@Column(name="Full_Name")
    private String fullName;
	
	@Column(name="Telephone_No")
    private String telephoneNo;
	
	@Column(name="Mobile_No")
    private String mobileNo;
	
	@Column(name="Alternate_Contact_No")
    private String alternateContactNo;
	
	@Column(name="Salary_Per_Month")
    private BigDecimal salaryPerMonth;
	
	@Column(name="Occupation_Profession")
    private String occupationProfession;
	
	@Column(name="Education_Loan_Amount")
    private BigDecimal educationLoanAmount;
	
	@Column(name="Help_Amount")
    private BigDecimal helpAmount;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="Reference_Entity_ID")
    private EntityDetails applicant;
	
	@OneToOne(mappedBy = "entityDetails")
	private StudentFile studentFile;
	
	public StudentFile getStudentFile() {
		return studentFile;
	}
	public void setStudentFile(StudentFile studentFile) {
		this.studentFile = studentFile;
	}
	@OneToMany(mappedBy="applicant")
    private Set<EntityDetails> relatives = new HashSet<EntityDetails>();
    
    public EntityDetails getApplicant() {
		return applicant;
	}
	public void setApplicant(EntityDetails applicant) {
		this.applicant = applicant;
	}
	
	public Set<EntityDetails> getRelatives() {
		return relatives;
	}
	public void setRelatives(Set<EntityDetails> relatives) {
		this.relatives = relatives;
	}
	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAlternateContactNo() {
		return alternateContactNo;
	}
	public void setAlternateContactNo(String alternateContactNo) {
		this.alternateContactNo = alternateContactNo;
	}
	public BigDecimal getSalaryPerMonth() {
		return salaryPerMonth;
	}
	public void setSalaryPerMonth(BigDecimal salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}
	public String getOccupationProfession() {
		return occupationProfession;
	}
	public void setOccupationProfession(String occupationProfession) {
		this.occupationProfession = occupationProfession;
	}
	public BigDecimal getEducationLoanAmount() {
		return educationLoanAmount;
	}
	public void setEducationLoanAmount(BigDecimal educationLoanAmount) {
		this.educationLoanAmount = educationLoanAmount;
	}
	public BigDecimal getHelpAmount() {
		return helpAmount;
	}
	public void setHelpAmount(BigDecimal helpAmount) {
		this.helpAmount = helpAmount;
	}
	
}
