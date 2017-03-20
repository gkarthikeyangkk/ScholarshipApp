package com.tripleS.dto;

import java.sql.Date;

public class StudentFileDTO {
	private long id;
    private String fileNo;
    private String fileStatus;
    private String createdBy;
    private String interviewedBy;
    private long entityId;
    private Date createdDate;
    private Date interviewedDate;
    
	public StudentFileDTO(String fileNo, String fileStatus, long entityId, String createdBy, Date createdDate) {
		super();
		this.fileNo = fileNo;
		this.fileStatus = fileStatus;
		this.entityId = entityId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public StudentFileDTO(long id, String fileNo, String fileStatus, String createdBy, String interviewedBy,
			long entityId, Date createdDate, Date interviewedDate) {
		super();
		this.id = id;
		this.fileNo = fileNo;
		this.fileStatus = fileStatus;
		this.createdBy = createdBy;
		this.interviewedBy = interviewedBy;
		this.entityId = entityId;
		this.createdDate = createdDate;
		this.interviewedDate = interviewedDate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
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
	public long getEntityId() {
		return entityId;
	}
	public void setEntityId(long entityId) {
		this.entityId = entityId;
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
}
