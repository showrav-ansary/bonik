package com.showrav.bonik.web;

import com.showrav.bonik.domain.Cart;
import com.showrav.bonik.domain.User;
import com.showrav.bonik.service.Action;
import com.showrav.bonik.service.CartService;
import com.showrav.bonik.util.SecurityContext;
import com.showrav.bonik.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-to-cart")
public class CartServlet extends HttpServlet {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartServlet.class);

	@Inject
	private CartService cartService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
					throws IOException {
		var productId = req.getParameter("productId");
		var action = req.getParameter("action");
		var cart = getCart(req);

		if (StringUtil.isNotEmpty(action)) {
			processCart(productId, action, cart);

			resp.sendRedirect("/checkout");
			return;
		}

		LOGGER.info(
						"Received request to add product with id: {} to cart",
						productId);

		cartService.addProductToCart(productId, cart);

		resp.sendRedirect("/home");
	}

	private void processCart(String productId, String action, Cart cart) {

		switch (Action.valueOf(action.toUpperCase())) {
			case ADD:
				LOGGER.info(
								"Received request to add product with id: {} to cart",
								productId);
				cartService.addProductToCart(productId, cart);
				break;
			case REMOVE:
				LOGGER.info(
								"Received request to remove product with id: {} to cart",
								productId);
				cartService.removeProductToCart(productId, cart);
				break;
		}
	}

	private Cart getCart(HttpServletRequest req) {
		final User currentUser = SecurityContext.getCurrentUser(req);

		return cartService.getCartByUser(currentUser);
	}
}
