package com.tripleS.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Column(name="first_name")
	@NotEmpty(message = "*Please provide your first name")
    private String firstName;
	
	@Column(name="last_name")
	@NotEmpty(message = "*Please provide your last name")
    private String lastName;
	
	@Column(name="display_user_name")
    private String displayUserName;
	
	@Column(name="password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
    private String password;
	
	/*@Transient
    private String passwordConfirm;*/
	
	@Column(name="email_id")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
    private String emailID;
	
	@Column(name="mobile_no")
    private String mobileNo;
	
	@Column(name="created_date")
    private Date createdDate;
	
	@ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }*/

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplayUserName() {
		return displayUserName;
	}

	public void setDisplayUserName(String displayUserName) {
		this.displayUserName = displayUserName;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
