package com.healthmetrics.HealthAPI.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.healthmetrics.HealthAPI.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByPassword(@Param(value = "password") String password);
}
