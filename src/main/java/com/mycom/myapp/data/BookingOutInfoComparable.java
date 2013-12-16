package com.mycom.myapp.data;

import java.util.Comparator;

/**
 * Class comparator for BookingOutInfo
 * @author Eugene
 *
 */
public class BookingOutInfoComparable implements Comparator<BookingOutInfo>{
	 
	/**
	 * overridden method to provide sorting of BookingOutInfo by date of booking
	 */
    @Override
    public int compare(BookingOutInfo o1, BookingOutInfo o2) {
        return o1.getBookingDate().compareTo(o2.getBookingDate() );
    }
}