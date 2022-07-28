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
@Table(name = "BIOMETRICS")
public class Biometrics implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "HEIGHT")
	private Long height;

	@Column(name = "WEIGHT")
	private Double weight;

	@Column(name = "AGE")
	private Integer age;

	@Column(name = "BODY_MASS_INDEX")
	private Double bodyMassIndex;

	@Column(name = "BODY_FAT_PERCENTAGE")
	private Double bodyFatPercentage;

	@Column(name = "TOTAL_BODY_WATER_PERCENTAGE")
	private Double totalBodyWaterPercentage;

	@Column(name = "LEAN_BODY_MASS")
	private Double leanBodyMass;

	@OneToOne
	private User user;

	public Biometrics() {
	}

	public Biometrics(Long id, Long height, Double weight, Integer age, Double bodyMassIndex,
			Double bodyFatPercentage, Double totalBodyWaterPercentage, Double leanBodyMass) {
		super();
		this.id = id;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.bodyMassIndex = bodyMassIndex;
		this.bodyFatPercentage = bodyFatPercentage;
		this.totalBodyWaterPercentage = totalBodyWaterPercentage;
		this.leanBodyMass = leanBodyMass;
	}

	public Biometrics(Long height, Double weight, Integer age, Double bodyMassIndex,
			Double bodyFatPercentage, Double totalBodyWaterPercentage, Double leanBodyMass) {
		super();
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.bodyMassIndex = bodyMassIndex;
		this.bodyFatPercentage = bodyFatPercentage;
		this.totalBodyWaterPercentage = totalBodyWaterPercentage;
		this.leanBodyMass = leanBodyMass;
	}

	public Biometrics(Long height, Double weight, Integer age, Double bodyMassIndex,
			Double bodyFatPercentage, Double totalBodyWaterPercentage, Double leanBodyMass, User user) {
		super();
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.bodyMassIndex = bodyMassIndex;
		this.bodyFatPercentage = bodyFatPercentage;
		this.totalBodyWaterPercentage = totalBodyWaterPercentage;
		this.leanBodyMass = leanBodyMass;
		this.user = user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setHeight(Long height) {
		this.height = height;
	}

	public Long getHeight() {
		return this.height;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setBodyMassIndex(Double bodyMassIndex) {
		this.bodyMassIndex = bodyMassIndex;
	}

	public Double getBodyMassIndex() {
		return this.bodyMassIndex;
	}

	public void setBodyFatPercentage(Double bodyFatPercentage) {
		this.bodyFatPercentage = bodyFatPercentage;
	}

	public Double getBodyFatPercentage() {
		return this.bodyFatPercentage;
	}

	public void setTotalBodyWaterPercentage(Double totalBodyWaterPercentage) {
		this.totalBodyWaterPercentage = totalBodyWaterPercentage;
	}

	public Double getTotalBodyWaterPercentage() {
		return this.totalBodyWaterPercentage;
	}

	public void setLeanBodyMass(Double leanBodyMass) {
		this.leanBodyMass = leanBodyMass;
	}

	public Double getLeanBodyMass() {
		return this.leanBodyMass;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

	@Override
	public String toString() {
		return String.format(
				"USER-Biometrics[id=%d, height=%d, weight=%f, age=%d, bodyMassIndex=%f, bodyFatPercentage=%f, totalBodyWaterPercentage=%f, leanBodyMass=%f]",
				this.id, this.height, this.weight, this.age, this.bodyMassIndex, this.bodyFatPercentage,
				this.totalBodyWaterPercentage, this.leanBodyMass);
	}
}