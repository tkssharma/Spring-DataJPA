package com.spring.training.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.training.model.Address;

@Transactional
public interface AddressRepository extends JpaRepository<Address, Integer> {

	
}
