package com.showrav.bonik.service;

import com.showrav.bonik.domain.Order;
import com.showrav.bonik.domain.ShippingAddress;
import com.showrav.bonik.domain.User;
import com.showrav.bonik.dto.ShippingAddressDTO;
import com.showrav.bonik.exceptions.CartItemNotFoundException;
import com.showrav.bonik.repository.CartRepository;
import com.showrav.bonik.repository.OrderRepository;
import com.showrav.bonik.repository.ShippingAddressRepository;

import javax.inject.Inject;

public class OrderServiceImpl implements OrderService {
	private OrderRepository orderRepository;
	private ShippingAddressRepository shippingAddressRepository;
	private CartRepository cartRepository;

	@Inject
	public OrderServiceImpl(OrderRepository orderRepository,
													ShippingAddressRepository shippingAddressRepository,
													CartRepository cartRepository) {
		this.orderRepository = orderRepository;
		this.shippingAddressRepository = shippingAddressRepository;
		this.cartRepository = cartRepository;
	}

	@Override
	public void processOrder(ShippingAddressDTO shippingAddressDTO, User currentUser) {
		var shippingAddress = convertTo(shippingAddressDTO);
		var savedShippingAddress = shippingAddressRepository.save(shippingAddress);

		var cart = cartRepository.findByUser(currentUser)
						.orElseThrow(() ->
										new CartItemNotFoundException(
														"Cart Not found by current users"));

		Order order = new Order();
		order.setCart(cart);
		order.setShippingAddress(savedShippingAddress);
		order.setShipped(false);
		order.setUser(currentUser);

		orderRepository.save(order);
	}

	private ShippingAddress convertTo(ShippingAddressDTO shippingAddressDTO) {
		var shippingAddress = new ShippingAddress();
		shippingAddress.setAddress(shippingAddressDTO.getAddress());
		shippingAddress.setAddress2(shippingAddressDTO.getAddress2());
		shippingAddress.setCountry(shippingAddressDTO.getCountry());
		shippingAddress.setState(shippingAddressDTO.getState());
		shippingAddress.setZip(shippingAddressDTO.getZip());
		shippingAddress.setMobileNumber(shippingAddressDTO.getMobileNumber());

		return shippingAddress;
	}
}
