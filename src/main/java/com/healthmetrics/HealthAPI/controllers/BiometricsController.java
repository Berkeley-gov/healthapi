package com.healthmetrics.HealthAPI.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthmetrics.HealthAPI.entities.Biometrics;
import com.healthmetrics.HealthAPI.repositories.BiometricsRepository;

@RestController
@RequestMapping("biometrics")
public class BiometricsController {

	private final BiometricsRepository biometricsRepository;

	public BiometricsController(final BiometricsRepository biometricsRepository) {
		this.biometricsRepository = biometricsRepository;
	}

	@GetMapping("/")
	public Iterable<Biometrics> getAllBiometrics() {
		return this.biometricsRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Biometrics> getBiometricsById(@PathVariable("id") Long id) {
		return this.biometricsRepository.findById(id);
	}

	@PostMapping("/create-biometrics-account")
	public Biometrics createNewBiometricsAccount(@RequestBody Biometrics biometrics) {
		return this.biometricsRepository.save(biometrics);
	}

	@PutMapping("/update-biometrics/{id}")
	public Biometrics updateBiometricsInformation(@PathVariable("id") Long id, @RequestBody Biometrics biometric) {

		Optional<Biometrics> biometricsToUpdateOptional = this.biometricsRepository.findById(id);

		if (!biometricsToUpdateOptional.isPresent()) {
			return null;
		} else {
			Biometrics biometricsToUpdate = biometricsToUpdateOptional.get();

			if (biometric.getHeight() != null) {
				biometricsToUpdate.setHeight(biometric.getHeight());
			}
			if (biometric.getWeight() != null) {
				biometricsToUpdate.setWeight(biometric.getWeight());
			}
			if (biometric.getAge() != null) {
				biometricsToUpdate.setAge(biometric.getAge());
			}
			if (biometric.getGender() != null) {
				biometricsToUpdate.setGender(biometric.getGender());
			}
			if (biometric.getBodyMassIndex() != null) {
				biometricsToUpdate.setBodyMassIndex(biometric.getBodyMassIndex());
			}
			if (biometric.getBodyFatPercentage() != null) {
				biometricsToUpdate.setBodyFatPercentage(biometric.getBodyFatPercentage());
			}
			if (biometric.getTotalBodyWaterPercentage() != null) {
				biometricsToUpdate.setTotalBodyWaterPercentage(biometric.getTotalBodyWaterPercentage());
			}
			if (biometric.getLeanBodyMass() != null) {
				biometricsToUpdate.setLeanBodyMass(biometric.getLeanBodyMass());
			}

			return this.biometricsRepository.save(biometricsToUpdate);
		}
	}

	@DeleteMapping("/delete-biometrics-account/{id}")
	public Biometrics deleteBiometricsAccount(@PathVariable("id") Long id) {

		Optional<Biometrics> biometricsToDeleteOptional = this.biometricsRepository.findById(id);

		if (!biometricsToDeleteOptional.isPresent()) {
			return null;
		} else {
			Biometrics biometricsToDelete = biometricsToDeleteOptional.get();
			this.biometricsRepository.delete(biometricsToDelete);
			return biometricsToDelete;
		}
	}
}
