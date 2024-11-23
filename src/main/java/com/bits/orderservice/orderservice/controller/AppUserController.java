package com.bits.orderservice.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bits.orderservice.orderservice.db.AppUserRepository;
import com.bits.orderservice.orderservice.model.AppUser;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppUserController {
	@Autowired
	private AppUserRepository appUserRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AppUser getActivityTypeById(@PathVariable(name = "id") Long id) {
		return appUserRepository.getAppUserById(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AppUser save(@RequestBody(required = false) AppUser body) {
		return appUserRepository.save(body);
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(@RequestBody(required = false) AppUser body) {
		try {
			AppUser a = appUserRepository.save(body);
			return "Sign Up Successful for " + a.getName() + " with user Id: " + a.getId();
		} catch (Exception e) {
			return "Sign UP Failed";
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<AppUser> list() {
		return appUserRepository.findAll();
	}
}
