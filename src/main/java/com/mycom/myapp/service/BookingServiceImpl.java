package com.mycom.myapp.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;

import com.mycom.myapp.data.BookedMeetingData;
import com.mycom.myapp.data.BookingInfo;
import com.mycom.myapp.data.BookingInfoConv;
import com.mycom.myapp.data.BookingInfoConvComparable;
import com.mycom.myapp.data.BookingOutInfo;
import com.mycom.myapp.data.BookingOutInfoComparable;
import com.mycom.myapp.utils.BookingHelperUtils;

/**
 * Class for processing booking operations
 * @author Eugene
 *
 */
@Service
public class BookingServiceImpl implements BookingService {
	
		
	/**
	 * overriding handling of batch booking requests    
	 */
	@Override
	public List<BookingOutInfo> processBooking(List<BookingInfo> listInfo) {
		
		//map to easy group successful booking by date
		Map<Date, List<BookedMeetingData> > mapBookings = new HashMap< Date, List<BookedMeetingData> >();
		//result output
		List<BookingOutInfo> listOutBookedMeetings = new ArrayList<BookingOutInfo>(); 
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<BookingInfo> newBookingList;
		List<BookingInfoConv> listBIC = new ArrayList<BookingInfoConv>();
		
		try {
			//Jackson convering should be performed
 			newBookingList = mapper.convertValue(listInfo, new TypeReference< List<BookingInfo> >(){});
			
 			listBIC = BookingHelperUtils.convert(newBookingList);
 			
			//take data from input entity and put it to BookingInfoConv to provide convenient handling 
			
			//sort by time of booking converted input data to provide requirement of the chronological order
			Collections.sort(listBIC, new BookingInfoConvComparable() );
			
			//processing requests in the chronological order...
			//NOTE: !the test task has no requirement to handle room booking in the past so this case is omitted and it's possible create booking for the past day
			for(BookingInfoConv bic : listBIC){
				Calendar calTimeBooking = Calendar.getInstance();
				calTimeBooking.setTimeInMillis(bic.getTimeOfBooking().getTime() );
				
				Calendar calTimeBookingStart = Calendar.getInstance();
				calTimeBookingStart.setTimeInMillis(calTimeBooking.getTimeInMillis());
				
				calTimeBooking.add(Calendar.HOUR_OF_DAY, bic.getBookingDurationHours() );
				
				//check that meeting within working time
				if( (calTimeBooking.get(Calendar.HOUR_OF_DAY)<=18 && calTimeBooking.get(Calendar.MINUTE)<=0) && (calTimeBookingStart.get(Calendar.HOUR_OF_DAY) >= 9 && calTimeBookingStart.get(Calendar.MINUTE) >= 0 ) && (calTimeBooking.DATE == calTimeBookingStart.DATE) ){
					
					BookedMeetingData bmd = new BookedMeetingData(calTimeBookingStart.getTime(), calTimeBooking.getTime(), bic.getBookingEmployee());
					Date timeOfBooking = bic.getTimeOfBooking();
					Calendar dayOfMeeting = Calendar.getInstance();
					dayOfMeeting.setTime(timeOfBooking);
					
					dayOfMeeting.set(Calendar.HOUR, 0);
					dayOfMeeting.set(Calendar.HOUR_OF_DAY, 0);
					dayOfMeeting.set(Calendar.MINUTE, 0);
					dayOfMeeting.set(Calendar.SECOND, 0);
					dayOfMeeting.set(Calendar.MILLISECOND, 0);
					
					if(mapBookings.get(dayOfMeeting.getTime()) == null ){
						mapBookings.put(dayOfMeeting.getTime(), new ArrayList<BookedMeetingData>() );
					}
					
					//check that meeting not overlaps over
					if ( !mapBookings.get( dayOfMeeting.getTime() ).contains( bmd ) ){
						mapBookings.get( dayOfMeeting.getTime() ).add(bmd);
					}
				}
			}
			
			listOutBookedMeetings = BookingHelperUtils.convert(mapBookings);
						
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(listOutBookedMeetings, new BookingOutInfoComparable() );
 		return listOutBookedMeetings;
	}

}
