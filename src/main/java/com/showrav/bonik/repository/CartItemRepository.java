package com.showrav.bonik.repository;

import com.showrav.bonik.domain.CartItem;

public interface CartItemRepository {
	CartItem save(CartItem cartItem);

	CartItem update(CartItem cartItem);

	void remove(CartItem cartItem);
}
