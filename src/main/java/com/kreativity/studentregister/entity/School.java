package com.kreativity.studentregister.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="teacherData")
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="t_id")
	private Integer tId;
	@Column(name="teacherName")
	private String teacherName;
	@Column(name="schoolName")
	private String schoolName;
	@Column(name="city")
	private String city;
	@Column(name="pinCode")
	private Integer pinCode;
	@Column(name="email")
	private String email;
	@Column(name="phoneNumber")
	private Long phoneNumber;
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPinCode() {
		return pinCode;
	}
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "SchoolRegister [tId=" + tId + ", teacherName=" + teacherName + ", schoolName=" + schoolName + ", city="
				+ city + ", pinCode=" + pinCode + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}

}
