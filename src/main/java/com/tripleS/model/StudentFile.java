package com.tripleS.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Student_File")
public class StudentFile {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="File_No")
    private int fileNo;
	
	@Column(name="File_Status")
	//@NotEmpty(message="*File status cannot be empty")
    private String fileStatus;
	
	@Column(name="Created_By")
	//@NotEmpty(message="*Created By cannot be empty")
    private String createdBy;
	
	@Column(name="Interviewed_By")
    private String interviewedBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Created_Date")
    private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Interviewed_Date")
    private Date interviewedDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Entity_ID")
	@Valid
    private EntityDetails entityDetails;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileStatus() {
		return fileStatus;
	}
	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getInterviewedBy() {
		return interviewedBy;
	}
	public void setInterviewedBy(String interviewedBy) {
		this.interviewedBy = interviewedBy;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getInterviewedDate() {
		return interviewedDate;
	}
	public void setInterviewedDate(Date interviewedDate) {
		this.interviewedDate = interviewedDate;
	}
	
	public EntityDetails getEntityDetails() {
		return entityDetails;
	}
	public void setEntityDetails(EntityDetails entityDetails) {
		this.entityDetails = entityDetails;
	}
	
	@Override
    public String toString() {
        return String.format(
                "File[ID=%d, Number=%s, Status=%s]",
                id, fileNo, fileStatus);
    }
}
