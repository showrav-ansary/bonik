package com.showrav.bonik.repository;

import com.showrav.bonik.domain.User;

import java.util.Optional;


public interface UserRepository {
	void save(User user);

	Optional<User> findByUsername(String username);
}
