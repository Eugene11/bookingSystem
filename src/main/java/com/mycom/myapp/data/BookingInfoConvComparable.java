package com.mycom.myapp.data;

import java.util.Comparator;

/**
 * Class comparator for BookingInfoConv
 * @author Eugene
 *
 */
public class BookingInfoConvComparable implements Comparator<BookingInfoConv>{
	 
	/**
	 * overridden method to provide sorting of BookingInfoConv by date of booking
	 */
    @Override
    public int compare(BookingInfoConv o1, BookingInfoConv o2) {
        return o1.getDateOfBooking().compareTo(o2.getDateOfBooking() );
    }
    
}
