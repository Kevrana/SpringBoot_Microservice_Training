package com.module3.hotelsapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.module3.hotelsapp.exception.ResourceNotFoundException;
import com.module3.hotelsapp.model.Hotel;
import com.module3.hotelsapp.repository.HotelRepository;


@Service
@Transactional
public class HotelServiceImpl implements HotelService{

	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		Optional<Hotel> hotelDb = this.hotelRepository.findById(hotel.getId());
		
		if(hotelDb.isPresent()) {
			Hotel hotelUpdate = hotelDb.get();
			hotelUpdate.setId(hotel.getId());
			hotelUpdate.setName(hotel.getName());
			hotelUpdate.setDescription(hotel.getDescription());
			hotelUpdate.setCity(hotel.getCity());
			hotelUpdate.setRating(hotel.getRating());
			hotelRepository.save(hotelUpdate);
			
			return hotelUpdate;
		}
		else {
			throw new ResourceNotFoundException("Record not found with id: " + hotel.getId());
		}
	}

	@Override
	public List<Hotel> getAllHotels(Integer pageNum, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNum, pageSize);
		Page<Hotel> pagedResult = hotelRepository.findAll(paging);
		
		if(pagedResult.hasContent()) {
			return pagedResult.getContent();
		}
		else {
			return new ArrayList<Hotel>();
		}
	}

	@Override
	public Hotel getHotelById(long hotelId) {
		
		Optional<Hotel> hotelDb = this.hotelRepository.findById(hotelId);
		
		if(hotelDb.isPresent()) {
			return hotelDb.get();
		}
		else {
			throw new ResourceNotFoundException("Record not found with id: " + hotelId);
		}

	}

	@Override
	public void deleteHotel(long hotelId) {
		
		Optional<Hotel> hotelDb = this.hotelRepository.findById(hotelId);
		
		if(hotelDb.isPresent()) {
			this.hotelRepository.delete(hotelDb.get());
		}
		else {
			throw new ResourceNotFoundException("Record not found with id: " + hotelId);
		}
		
	}

}
