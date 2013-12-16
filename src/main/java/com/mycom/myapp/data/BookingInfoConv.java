package com.mycom.myapp.data;

import java.util.Date;

/**
 * Class to provide translation of BookingInfo(input data - first and second text, JSON lines) to entity with real data to provide more convenient handling booking requests  
 * @author Eugene
 *
 */
public class BookingInfoConv{
	/**
	 * date of booking
	 */
	protected Date dateOfBooking;
	/**
	 * employee name
	 */
	protected String bookingEmployee;
	/**
	 * time of booking
	 */
	protected Date timeOfBooking;
	/**
	 * duration of meeting in hours
	 */
	protected Integer bookingDurationHours;
	
	public BookingInfoConv(){
		
	}
	public BookingInfoConv(Date dataOfBooking, String bookingEmployee, Date timeOfBooking, Integer bookingDurationHours){
		this.dateOfBooking = dataOfBooking;
		this.bookingEmployee = bookingEmployee;
		this.timeOfBooking = timeOfBooking;
		this.bookingDurationHours = bookingDurationHours;
	}
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public String getBookingEmployee() {
		return bookingEmployee;
	}
	public void setBookingEmployee(String bookingEmployee) {
		this.bookingEmployee = bookingEmployee;
	}
	public Date getTimeOfBooking() {
		return timeOfBooking;
	}
	public void setTimeOfBooking(Date timeOfBooking) {
		this.timeOfBooking = timeOfBooking;
	}
	public Integer getBookingDurationHours() {
		return bookingDurationHours;
	}
	public void setBookingDurationHours(Integer bookingDurationHours) {
		this.bookingDurationHours = bookingDurationHours;
	}
}