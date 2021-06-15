package com.showrav.bonik.repository;

import com.showrav.bonik.domain.ShippingAddress;

import java.util.Optional;

public interface ShippingAddressRepository {
	ShippingAddress save(ShippingAddress convertTo);

	Optional<ShippingAddress> findOne(long shippingAddressId);
}
