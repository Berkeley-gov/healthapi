package com.healthmetrics.HealthAPI.services;

public final class BiometericsService {

	private Long height;
	private Double weight;
	private Integer age;
	private String gender;
	private Double bodyMassIndex;

	public BiometericsService() {
	}

	public BiometericsService(Long height, Double weight, Integer age, String gender) {
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
	}

	// BMI = [Weight / (height)^2] * 703
	public Double calculateBMI() {
		this.bodyMassIndex = (this.weight / Math.pow(this.height, 2)) * 703;
		return this.bodyMassIndex;
	}

	// BFP = –44.988 + (0.503 * age) + (10.689 * gender) + (3.172 * BMI)
	// – (0.026 * BMI2) + (0.181 * BMI * gender) – (0.02 * BMI * age) – (0.005 *
	// BMI2 * gender) + (0.00021 * BMI2 * age)
	public Double calculateBodyFatPercentage() {
		Short genderValue;

		if (this.gender.equalsIgnoreCase("male")) {
			genderValue = 0;

			return -44.988 + (0.503 * this.age) + (10.689 * genderValue) + (3.172 * this.bodyMassIndex)
					- (0.026 * Math.pow(this.bodyMassIndex, 2)) + (0.181 * this.bodyMassIndex * genderValue)
					- (0.02 * this.bodyMassIndex * this.age) - (0.005 * Math.pow(this.bodyMassIndex, 2) * genderValue)
					+ (0.00021 * Math.pow(this.bodyMassIndex, 2) * this.age);

		} else if (this.gender.equalsIgnoreCase("female")) {
			genderValue = 1;

			return -44.988 + (0.503 * this.age) + (10.689 * genderValue) + (3.172 * this.bodyMassIndex)
					- (0.026 * Math.pow(this.bodyMassIndex, 2)) + (0.181 * this.bodyMassIndex * genderValue)
					- (0.02 * this.bodyMassIndex * this.age) - (0.005 * Math.pow(this.bodyMassIndex, 2) * genderValue)
					+ (0.00021 * Math.pow(this.bodyMassIndex, 2) * this.age);

		} else {
			return null;
		}

	}

	// There are two formulaes; they are applied based on user's gender and age
	// males (TBW) = 2.447 - 0.09516 X age + 0.1074 X height + 0.3362 X weight
	// females (TBW) = -2.097 + 0.1069 X height + 0.2466 X weight
	public Double calculateTotalBodyWaterPercentage() {

		if (this.gender.equalsIgnoreCase("male")) {
			return 2.447 - 0.09516 * this.age + 0.1074 * this.height + 0.3362 * this.weight;
		} else if (this.gender.equalsIgnoreCase("female")) {
			return -2.097 + 0.1069 * this.height + 0.2466 * this.weight;
		} else {
			return null;
		}

	}

	// For men: Lean body mass = (0.32810 × W) + (0.33929 × H) − 29.5336
	// For women: Lean body mass = (0.29569 × W) + (0.41813 × H) − 43.2933
	public Double calculateLeanBodyMass() {

		if (this.gender.equalsIgnoreCase("male")) {
			return (0.32810 * this.weight) + (0.33929 * this.height) - 29.5336;
		} else if (this.gender.equalsIgnoreCase("female")) {
			return (0.29569 * this.weight) + (0.41813 * this.height) - 43.2933;
		} else {
			return null;
		}

	}

	public void setHeight(Long height) {
		this.height = height;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "BiometericsService [age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
}