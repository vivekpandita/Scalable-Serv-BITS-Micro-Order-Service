package com.bits.orderservice.orderservice.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bits.orderservice.orderservice.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
	Orders getOrderById(Long id);

	@Query(value = "select a.* from order a where a.user_id= :userId", nativeQuery = true)
	List<Orders> listForUser(@Param("userId") Long userId);
}
