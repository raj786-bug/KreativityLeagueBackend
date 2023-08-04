package com.kreativity.studentregister.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="schoolInfo")
public class SchoolInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="StudentID")
	private Integer stid;
	@Column(name="StudentName")
	private String studentName;
	@Column(name="DOB")
	private String dob;
	@Column(name="Email")
	private String email;
	@Column(name="SchoolName")
	private String schoolName;
	@Column(name="WhatsappNumber")
	private String whatsappNumber;
	public SchoolInfo() {
		super();
		this.stid = stid;
		this.studentName = studentName;
		this.dob = dob;
		this.email = email;
		this.schoolName = schoolName;
		this.whatsappNumber = whatsappNumber;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getWhatsappNumber() {
		return whatsappNumber;
	}
	public void setWhatsappNumber(String whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}
	@Override
	public String toString() {
		return "SchoolInfo [stid=" + stid + ", studentName=" + studentName + ", dob=" + dob + ", email=" + email
				+ ", schoolName=" + schoolName + ", whatsappNumber=" + whatsappNumber + "]";
	}
	
	

}
