package com.bits.orderservice.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bits.orderservice.orderservice.db.OrderRepository;
import com.bits.orderservice.orderservice.model.Orders;
import com.bits.orderservice.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Orders getActivityTypeById(@PathVariable(name = "id") Long id) {
		return orderRepository.getOrderById(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Orders save(@RequestBody(required = false) Orders body) {
		body = orderService.fillOrderObjectForSave(body);
		return orderRepository.save(body);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Orders> list() {
		return orderRepository.findAll();
	}

	@RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
	public List<Orders> listForUser(@PathVariable(name = "userId") Long userId) {
		return orderRepository.listForUser(userId);
	}
}
