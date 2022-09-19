package com.healthmetrics.HealthAPI.repositories;

import org.springframework.data.repository.CrudRepository;
import com.healthmetrics.HealthAPI.entities.Biometrics;

public interface BiometricsRepository extends CrudRepository<Biometrics, Long> {
}
