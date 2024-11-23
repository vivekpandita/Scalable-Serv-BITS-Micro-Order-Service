package com.bits.orderservice.orderservice.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bits.orderservice.orderservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	Book getBookById(Long id);
	
	@Query(value = "select a.* from book a where UPPER(a.name) like UPPER(CONCAT('%', :key, '%'))", nativeQuery = true)
	List<Book> searchBooks(@Param("key") String key);
}