package com.tripleS.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

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
	@NotEmpty(message = "*Please provide first name")
    private String firstName;
	
	@Column(name="Middle_Name")
    private String middleName;
	
	@Column(name="Last_Name")
    private String lastName;
	
	@Column(name="Full_Name")
    private String fullName;
	
	@Column(name="Age")
	private Integer age;
	
	@Column(name="Telephone_No")
    private String telephoneNo;
	
	@Column(name="Email_ID")
	@Email(message = "*Please provide a valid Email Address")
	@NotEmpty(message = "*Please provide an email address")
	private String emailID;
	
	@Column(name="Mobile_No")
	@Pattern(regexp="(^$|[0-9]{10})", message = "*Mobile number must be exactly 10 digits")
	@NotEmpty(message = "*Please provide mobile number")
    private String mobileNo;
	
	@Column(name="Alternate_Contact_No")
	@Pattern(regexp="(^$|[0-9]{10})", message = "*Alternate contact number must be exactly 10 digits")
    private String alternateContactNo;
	
	@Column(name="Qualification")
	private String qualification;
	
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
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_ID")
	@Valid
    private EntityAddressDetails entityAddressDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Student_ID")
	@Valid
    private StudentDetails studentDetails;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="applicant")
	private List<EntityDetails> relatives;
    //private List<EntityDetails> relatives = new ArrayList<EntityDetails>();
	
	public StudentDetails getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}
	public StudentFile getStudentFile() {
		return studentFile;
	}
	public void setStudentFile(StudentFile studentFile) {
		this.studentFile = studentFile;
	}
    
    public EntityDetails getApplicant() {
		return applicant;
	}
	public void setApplicant(EntityDetails applicant) {
		this.applicant = applicant;
	}
	
	public List<EntityDetails> getRelatives() {
		return relatives;
	}
	public void setRelatives(List<EntityDetails> relatives) {
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
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
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
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
	public EntityAddressDetails getEntityAddressDetails() {
		return entityAddressDetails;
	}
	public void setEntityAddressDetails(EntityAddressDetails entityAddressDetails) {
		this.entityAddressDetails = entityAddressDetails;
	}
	
}
