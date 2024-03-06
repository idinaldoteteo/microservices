package com.store.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.order.domain.Order;

public interface IOrderRepository  extends JpaRepository<Order, Long>{

}
