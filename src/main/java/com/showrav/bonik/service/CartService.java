package com.showrav.bonik.service;

import com.showrav.bonik.domain.Cart;
import com.showrav.bonik.domain.User;

public interface CartService {

	Cart getCartByUser(User currentUser);

	void addProductToCart(String productId, Cart cart);

	void removeProductToCart(String productId, Cart cart);
}
