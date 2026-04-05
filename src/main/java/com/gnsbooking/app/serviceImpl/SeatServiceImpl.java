package com.gnsbooking.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.gnsbooking.app.dto.SeatResponse;
import com.gnsbooking.app.entity.SeatEntity;
import com.gnsbooking.app.repository.SeatRepository;
import com.gnsbooking.app.serviceI.SeatServiceI;

@Service
public class SeatServiceImpl implements SeatServiceI {
	
	@Autowired
	SeatRepository seatRepository;
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public List<SeatResponse> getAllSeats() {
	    List<SeatEntity> seats = seatRepository.findAll();

	    if (seats == null || seats.isEmpty()) {
	        return List.of();  // ✅ always return empty list
	    }

	    return seats.stream().map(seat -> {
	        String finalStatus = seat.getStatus();
	        if (redisTemplate.hasKey("seat:" + seat.getSeatNumber())) {
	            finalStatus = "LOCKED";
	        }

	        return new SeatResponse(
	                seat.getSeatNumber(),
	                seat.getRowName(),
	                seat.getSection(),
	                seat.getPrice(),
	                finalStatus
	        );

	    }).toList();
	}

}
