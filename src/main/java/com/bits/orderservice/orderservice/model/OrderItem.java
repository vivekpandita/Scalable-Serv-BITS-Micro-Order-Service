package com.bits.orderservice.orderservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Ensure unique identifier for GoalSetting
	private Long id;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "bookId", referencedColumnName = "id")
	private Book book;
	private Long quantity;
	private Double totalPrice;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "order_Id")
	private Orders order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		totalPrice = book.getPrice() * quantity;
		return totalPrice;
	}
}
