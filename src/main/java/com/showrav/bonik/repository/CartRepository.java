package com.showrav.bonik.repository;

import com.showrav.bonik.domain.Cart;
import com.showrav.bonik.domain.User;

import java.util.Optional;

public interface CartRepository {
	Optional<Cart> findByUser(User currentUser);

	Cart save(Cart cart);

	Cart update(Cart cart);

	Optional<Cart> findOne(long cartId);
}
