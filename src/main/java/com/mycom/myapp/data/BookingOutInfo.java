package com.mycom.myapp.data;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonPropertyOrder;


/**
 * Class describes output booking info 
 * @author Eugene
 *
 */
@JsonPropertyOrder({ "bookingConfirmedMeeting", "bookingDate" })
public class BookingOutInfo  implements Serializable {
	
	/**
	 * day of booking request(to group)
	 **/
	protected String bookingDate;
	
	/**
	 * confirmed meeting info (start, end, employee name)
	 */
	protected List<String[]> bookingConfirmedMeeting;
	
	public BookingOutInfo() {
	}
	
	public BookingOutInfo(String bookingDate,
			List<String[]> bookingConfirmedMeeting) {
		super();
		this.bookingDate = bookingDate;
		this.bookingConfirmedMeeting = bookingConfirmedMeeting;
	}
	
	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public List<String[]> getBookingConfirmedMeeting() {
		return bookingConfirmedMeeting;
	}

	public void setBookingConfirmedMeeting(List<String[]> bookingConfirmedMeeting) {
		this.bookingConfirmedMeeting = bookingConfirmedMeeting;
	}
	
}
