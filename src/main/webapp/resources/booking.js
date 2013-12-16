$(document).ready(function(){
	/**
	 * 
	 * handling button click
	 */
	$("#buttonAdd").click( function(){
	    
		var arrayBooking = []; 
		
		var booking = new Object();
		//just example values - hardcoded for now, not critical data
		booking.bookingAction = ["2011-03-17 10:17:06", "EMP001"];
		booking.bookingInfo = ["2011-03-21 09:00", "2"];
		arrayBooking.push(booking);
		
		var booking2 = new Object();
		booking2.bookingAction = ["2011-03-16 12:34:56", "EMP002"];
		booking2.bookingInfo = ["2011-03-21 09:00", "2"];
		arrayBooking.push(booking2);
		
		
		var booking3 = new Object();
		booking3.bookingAction = ["2011-03-16 09:28:23", "EMP003"];
		booking3.bookingInfo = ["2011-03-22 14:00", "2"];
		arrayBooking.push(booking3);
		
		
		var booking4 = new Object();
		booking4.bookingAction = ["2011-03-17 11:23:45", "EMP004"];
		booking4.bookingInfo = ["2011-03-22 16:00", "1"];
		arrayBooking.push(booking4);
		
		
		var booking5 = new Object();
		booking5.bookingAction = ["2011-03-15 17:29:12", "EMP005"];
		booking5.bookingInfo = ["2011-03-21 16:00", "3"];
		arrayBooking.push(booking5);
		
		var dataArg = JSON.stringify(arrayBooking);
		
		$.ajax({ 
		    url: urlAddBook, 
		    type: 'POST', 
		    dataType: 'json', 
		    data: dataArg, 
		    contentType: 'application/json',
		    mimeType: 'application/json',
		    success: function(data) { 
		    },
		    error:function(data,status,er) { 
		        alert("error: "+data+" status: "+status+" er:"+er);
		    }
		});
		
	});
	
});