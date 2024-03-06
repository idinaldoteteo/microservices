package com.store.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.order.domain.Order;
import com.store.order.service.IOrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController extends GenericController<Order>{

	public OrderController(IOrderService service){ super(service); }
}
