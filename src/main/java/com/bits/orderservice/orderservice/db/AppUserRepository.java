package com.bits.orderservice.orderservice.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bits.orderservice.orderservice.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	AppUser getAppUserById(Long id);
}