package com.healthmetrics.HealthAPI.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBERS")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;

	@OneToOne(mappedBy = "user")
	private Biometrics userBiometrics;

	public User() {

	}

	// No id constructor to allow for an auto generated one.
	public User(String username, String password, String firstName, String lastName, String email, Long phoneNumber) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public User(String username, String password, String firstName, String lastName, String email, Long phoneNumber,
			Biometrics userBiometrics) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userBiometrics = userBiometrics;
	}

	public User(Long id, String username, String password, String firstName, String lastName, String email,
			Long phoneNumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Long getUserId() {
		return this.id;
	}

	public void setUserId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setBioMetrics(Biometrics userBiometrics) {
		this.userBiometrics = userBiometrics;
	}

	public Biometrics getUserBiometrics() {
		return this.userBiometrics;
	}

	@Override
	public String toString() {
		return String.format(
				"USER[id=%d, username=%s, password=%s, firstName=%s, lastName=%s, email=%s, phoneNumber=%d]", this.id,
				this.username, this.password, this.firstName, this.lastName, this.email, this.phoneNumber);
	}

}
