package com.mycom.myapp.service;

import java.util.List;

import com.mycom.myapp.data.BookingInfo;
import com.mycom.myapp.data.BookingOutInfo;

/**
 * Class for processing booking operations 
 * @author Eugene
 *
 */
public interface BookingService {
	/**
	 * Process batch request of bookings
	 * @param listInfo list of requests to book the room
	 * @return result list of confirmed meetings grouped by days
	 */
	public List<BookingOutInfo> processBooking(List<BookingInfo> listInfo);
}
