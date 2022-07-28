package com.healthmetrics.HealthAPI.controllers;

import java.util.List;
import java.util.Optional;
import com.healthmetrics.HealthAPI.entities.User;
import com.healthmetrics.HealthAPI.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("user")
public class UserController {

	private final UserRepository userRepository;

	public UserController(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/") // tested
	public Iterable<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@GetMapping("/authenticate/{password}") // tested
	public List<User> authenticateUser(@PathVariable("password") String password) {
		// Create authentication logic later.
		List<User> userToAuthenticate = this.userRepository.findByPassword(password);
		return userToAuthenticate;
	}

	@GetMapping("/retrieve-user/{id}") // tested
	public Optional<User> authenticateUser(@PathVariable("id") Long id) {
		return this.userRepository.findById(id);
	}

	@PostMapping("/new-user") // tested
	public User createNewUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}

	@PutMapping("/update-user/{id}") // tested
	public User updateUserInformation(@PathVariable("id") Long id, @RequestBody User user) {

		Optional<User> userToUpdateOptional = this.userRepository.findById(id);

		if (!userToUpdateOptional.isPresent()) {
			return null;
		} else {
			// Since isPresent() was true, we can .get() the Person object out of the
			// Optional
			User userToUpdate = userToUpdateOptional.get();

			if (user.getUsername() != null) {
				userToUpdate.setUsername(user.getUsername());
			}
			if (user.getPassword() != null) {
				userToUpdate.setPassword(user.getPassword());
			}
			if (user.getFirstName() != null) {
				userToUpdate.setFirstName(user.getFirstName());
			}
			if (user.getLastName() != null) {
				userToUpdate.setLastName(user.getLastName());
			}
			if (user.getEmail() != null) {
				userToUpdate.setEmail(user.getEmail());
			}
			if (user.getPhoneNumber() != null) {
				userToUpdate.setPhoneNumber(user.getPhoneNumber());
			}

			return this.userRepository.save(userToUpdate);
		}
	}

	@DeleteMapping("/remove-user/{id}") // tested
	public User deleteUser(@PathVariable("id") Long id) {

		Optional<User> userToDeleteOptional = this.userRepository.findById(id);

		if (!userToDeleteOptional.isPresent()) {
			return null;
		} else {
			User userToDelete = userToDeleteOptional.get();
			this.userRepository.delete(userToDelete);
			return userToDelete;
		}
	}

}
