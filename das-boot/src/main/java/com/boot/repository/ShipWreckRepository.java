package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Shipwreck;

public interface ShipWreckRepository extends JpaRepository<Shipwreck, Long> {

}
