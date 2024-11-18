package com.bits.orderservice.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.orderservice.orderservice.db.BookRepository;
import com.bits.orderservice.orderservice.model.Book;
import com.bits.orderservice.orderservice.model.OrderItem;
import com.bits.orderservice.orderservice.model.Orders;

@Service
public class OrderService {
	
	@Autowired
	BookRepository bookRepository;

	public Orders fillOrderObjectForSave(Orders order) {
		if(order != null)
		{
			if(order.getOrderItems() != null && !order.getOrderItems().isEmpty())
			{
				for(OrderItem item: order.getOrderItems())
				{
					if(item.getBook() !=null)
					{
						item = fillBookObject(item);
					}
				}
			}
		}
		return order;
	}

	private OrderItem fillBookObject(OrderItem item) {
		Long bookId = item.getBook().getId();
		Book b = bookRepository.getBookById(bookId);
		item.setBook(b);
		return item;
		
	}
}
