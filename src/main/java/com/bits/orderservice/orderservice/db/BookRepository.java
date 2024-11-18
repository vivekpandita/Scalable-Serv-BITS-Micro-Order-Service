package com.bits.orderservice.orderservice.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bits.orderservice.orderservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	Book getBookById(Long id);
}