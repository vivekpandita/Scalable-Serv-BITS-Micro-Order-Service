package com.bits.orderservice.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bits.orderservice.orderservice.db.BookRepository;
import com.bits.orderservice.orderservice.model.Book;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Book getActivityTypeById(@PathVariable(name = "id") Long id) {
		return bookRepository.getBookById(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Book save(@RequestBody(required = false) Book body) {
		return bookRepository.save(body);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Book> list() {
		return bookRepository.findAll();
	}
	
	@RequestMapping(value = "/searchByName/{key}", method = RequestMethod.GET)
	public List<Book> list(@PathVariable(name = "key") String key) {
		return bookRepository.searchBooks(key);
	}
}
