package com.showrav.bonik.service;

import com.showrav.bonik.domain.User;
import com.showrav.bonik.dto.LoginDTO;
import com.showrav.bonik.dto.UserDTO;

public interface UserService {
	void saveUser(UserDTO userDTO);

	boolean isNotUniqueUsername(UserDTO user);

	User verifyUser(LoginDTO loginDTO);
}
