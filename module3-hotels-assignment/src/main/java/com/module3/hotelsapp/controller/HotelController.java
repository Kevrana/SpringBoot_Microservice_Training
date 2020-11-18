package com.module3.hotelsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.module3.hotelsapp.model.Hotel;
import com.module3.hotelsapp.service.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	// Service URL to get a list of all of the Hotels
	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getAllHotel(
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size){
		
		List<Hotel> list = hotelService.getAllHotels(page, size);
		return new ResponseEntity<List<Hotel>>(list, HttpStatus.OK);
	}
	
	// Service URL to get a hotel based on an id
	@GetMapping("/hotels/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable long id){
		return ResponseEntity.ok().body(hotelService.getHotelById(id));
	}
	
	// Service URL to add a hotel
	@PostMapping("/hotels")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		return ResponseEntity.ok().body(this.hotelService.createHotel(hotel));
	}
	
	// Service URL to update a hotel based on an id
	@PutMapping("/hotels/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable long id, @RequestBody Hotel hotel){
		
		hotel.setId(id);
		return ResponseEntity.ok().body(this.hotelService.updateHotel(hotel));
	}
	
	// Service URL to delete a hotel based on an id
	@DeleteMapping("/hotels/{id}")
	public HttpStatus deleteHotel(@PathVariable long id){
		
		this.hotelService.deleteHotel(id);
		return HttpStatus.OK;
	}
	
}
