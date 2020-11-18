package com.module3.hotelsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module3.hotelsapp.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
