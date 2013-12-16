package com.mycom.myapp.data;

import java.io.Serializable;

/**
 * Class describes input booking info 
 * @author Eugene
 *
 */
public class BookingInfo  implements Serializable {
	
	/**
	 * describes the first line of input sequence(time of booking, employee name)  
	 */
	protected String[] bookingAction;
	
	/**
	 * describes the second line of booking (start time of meeting and duration - hours)
	 */
	protected String[] bookingInfo;
	
	public String[] getBookingAction() {
			return bookingAction;
	}
	 
	public void setBookingAction(String[] bookingAction) {
			this.bookingAction = bookingAction;		
	 
	}
	 
	public String[] getBookingInfo() {
		return bookingInfo;
	 
	}
	 
	public void setBookingInfo(String[] bookingInfo) {
		this.bookingInfo = bookingInfo; 
	}
	 
}
