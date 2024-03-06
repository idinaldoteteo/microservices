package com.store.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.order.domain.OrderItem;

public interface IOrdemItemRepository extends JpaRepository<OrderItem, Long> {

}
