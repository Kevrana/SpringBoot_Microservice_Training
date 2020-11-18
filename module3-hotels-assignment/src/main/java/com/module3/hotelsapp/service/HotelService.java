package com.module3.hotelsapp.service;

import java.util.List;

import com.module3.hotelsapp.model.Hotel;

public interface HotelService {
	
	Hotel createHotel(Hotel hotel);
	Hotel updateHotel(Hotel hotel);
	
	List<Hotel> getAllHotels(Integer pageNum, Integer pageSize);
	
	Hotel getHotelById(long hotelId);
	
	void deleteHotel(long id);
}
