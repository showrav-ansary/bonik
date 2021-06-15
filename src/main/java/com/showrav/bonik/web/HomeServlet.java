package com.showrav.bonik.web;

import com.showrav.bonik.dto.ProductDTO;
import com.showrav.bonik.service.CartService;
import com.showrav.bonik.service.ProductService;
import com.showrav.bonik.tx.ConnectionHolder;
import com.showrav.bonik.util.SecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeServlet.class);

	@Inject
	private ProductService productService;

	@Inject
	private CartService cartService;

	@Inject
	private ConnectionHolder connectionHolder;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
		LOGGER.info("Serving home page");
		connectionHolder.getConnection();

		final String attribute = req.getParameter("orderSuccess");

		if (attribute != null && Boolean.parseBoolean(attribute)) {
			req.setAttribute("message", "<strong>Congratulation!</strong> You're order has been placed successfully. ");
		}

		List<ProductDTO> allProducts = productService.findAllProductSortedByName();
		LOGGER.info("Total product found {}", allProducts.size());

		if (SecurityContext.isAuthenticated(req)) {
			var currentUser = SecurityContext.getCurrentUser(req);
			var cart = cartService.getCartByUser(currentUser);
			req.setAttribute("cart", cart);
		}

		req.setAttribute("products", allProducts);

		req.getRequestDispatcher("/WEB-INF/home.jsp")
						.forward(req, resp);
	}
}
