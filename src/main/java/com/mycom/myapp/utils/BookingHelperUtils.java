package com.mycom.myapp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mycom.myapp.data.BookedMeetingData;
import com.mycom.myapp.data.BookingInfo;
import com.mycom.myapp.data.BookingInfoConv;
import com.mycom.myapp.data.BookingOutInfo;

/**
 * Class for utils methods of converting from input data set and to output data set 
 * @author Eugene
 *
 */
public class BookingHelperUtils {
	/**
	 * time formatter for booking date and time 
	 */
	protected static final DateFormat FORMAT_DATE_OF_BOOKING = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	/**
	 * time formatter for meeting start time 
	 */
	protected static final DateFormat FORMAT_TIME_OF_MEETING_START = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	
	/**
	 * time formatter for meeting date
	 */
	protected static final DateFormat FORMAT_DATE_OF_MEETING = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * time formatter for meeting time
	 */
	protected static final DateFormat FORMAT_TIME_OF_MEETING = new SimpleDateFormat("HH:mm");
	
	/**
	 * Method converts from input data set(text data) to valued data to provide computation and handling  
	 * @param listInfo input data text
	 * @return data for handling
	 */
	public static List<BookingInfoConv> convert(List<BookingInfo> listInfo){
		List<BookingInfoConv> listBIC = new ArrayList<BookingInfoConv>();
		//text data converting to handle data
		for(BookingInfo inf : listInfo){
			try{
				String strDateofBooking = inf.getBookingAction()[0];
				String strBookingEmpl = inf.getBookingAction()[1];
				String strTimeOfBooking = inf.getBookingInfo()[0];
				String strDuration = inf.getBookingInfo()[1];
			    
			    Date dtDateOfBooking = FORMAT_DATE_OF_BOOKING.parse(strDateofBooking);
			    Date dtTimeOfBooking = FORMAT_TIME_OF_MEETING_START.parse(strTimeOfBooking);
			    Integer intDuration = Integer.parseInt(strDuration);
			    
			    BookingInfoConv bic = new BookingInfoConv(dtDateOfBooking, strBookingEmpl, dtTimeOfBooking, intDuration);
			    listBIC.add(bic);
			}
			catch(NullPointerException ex){
				ex.printStackTrace();
			}
			catch(IllegalArgumentException ex){
				ex.printStackTrace();
			}
			catch(ParseException ex){
				ex.printStackTrace();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
		return listBIC;
	}
	
	/**
	 * method converts from handled data to output data  
	 * @param mapBookings params to output
	 * @return list output data
	 */
	public static List<BookingOutInfo> convert( Map<Date, List<BookedMeetingData>>  mapBookings){
		List<BookingOutInfo> listOutBookedMeetings = new ArrayList<BookingOutInfo>();
		
		//put result map with grouped by days meetings to returning entity 
		for(Entry<Date, List<BookedMeetingData> > ent : mapBookings.entrySet() ){
			Date dateOfBooking = ent.getKey();
			List<BookedMeetingData> listBMD = ent.getValue();
			
			String strDateOfBooking = FORMAT_DATE_OF_MEETING.format(dateOfBooking);
			List<String[]> listOfBookedMeetings = new ArrayList<String[]>();
			
			for(BookedMeetingData bmdObj: listBMD){
				String[] dataMeeting = new String[3];
				String strStartTime = FORMAT_TIME_OF_MEETING.format(bmdObj.getStartMeeting() );
				String strEndTime = FORMAT_TIME_OF_MEETING.format(bmdObj.getEndMeeting() );
				dataMeeting[0] = strStartTime;
				dataMeeting[1] = strEndTime;
				dataMeeting[2] = bmdObj.getEmployee();
				listOfBookedMeetings.add(dataMeeting);
			}
			
			BookingOutInfo boi = new BookingOutInfo(strDateOfBooking, listOfBookedMeetings);
			listOutBookedMeetings.add(boi);
			
		}
		return listOutBookedMeetings;
	}
}
