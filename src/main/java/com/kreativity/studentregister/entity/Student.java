package com.kreativity.studentregister.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="student")
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="std_id")
	private Integer stdId;
	@Column(name="student_name")
	private String  studentName;
	@Column(name="dob")
	private String dob;
	@Column(name="parents_name")
	private String parentsName;
	@Column(name="relationship")
	private String relationship;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="whatsapp_number")
	private Long whatsappNumber;

	@Column(name = "payment_status")
	Boolean paymentStatus;
   
	public Student(Integer stdId, String studentName, String dob, String parentsName, String relationship, String email,
			String password, Long whatsappNumber) {
		super();
		this.stdId = stdId;
		this.studentName = studentName;
		this.dob = dob;
		this.parentsName = parentsName;
		this.relationship = relationship;
		this.email = email;
		this.password = password;
		this.whatsappNumber = whatsappNumber;
	}
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
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
	public String getParentsName() {
		return parentsName;
	}
	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getWhatsappNumber() {
		return whatsappNumber;
	}
	public void setWhatsappNumber(Long whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", studentName=" + studentName + ", dob=" + dob + ", parentsName="
				+ parentsName + ", relationship=" + relationship + ", email=" + email + ", password=" + password
				+ ", whatsappNumber=" + whatsappNumber
				+", paymentStatus="+ paymentStatus
				+ "]";
	}

	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
