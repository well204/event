package com.event.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.api.domain.event.Event;

public interface EventRepository extends JpaRepository <Event, UUID>{

}
