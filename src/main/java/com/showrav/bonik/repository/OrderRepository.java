package com.showrav.bonik.repository;

import com.showrav.bonik.domain.Order;
import com.showrav.bonik.domain.User;

import java.util.Set;

public interface OrderRepository {

	Order save(Order order);

	Set<Order> findOrderByUser(User user);
}
