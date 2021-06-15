package com.showrav.bonik.service;

import com.showrav.bonik.domain.User;
import com.showrav.bonik.dto.ShippingAddressDTO;

public interface OrderService {
	void processOrder(ShippingAddressDTO shippingAddress, User currentUser);
}
