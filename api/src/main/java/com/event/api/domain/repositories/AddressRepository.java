package com.event.api.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.api.domain.address.Address;

public interface AddressRepository extends JpaRepository <Address, UUID>{

}
