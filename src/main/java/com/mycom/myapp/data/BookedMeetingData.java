package com.mycom.myapp.data;

import java.util.Date;


/**
 * Class contains information of successfully booked meeting
 * @author Eugene
 *
 */
public class BookedMeetingData{
	
	/**
	 * time of begin meeting e.g. 09:00
	 */
	protected Date startMeeting;
	/**
	 * time of end meeting e.g. 11:00
	 */
	protected Date endMeeting;
	/**
	 * employee name
	 */
	protected String employee;
	
	public BookedMeetingData(){
		
	}
	
	public BookedMeetingData(Date start, Date end, String emp){
		this.startMeeting = start;
		this.endMeeting = end;
		this.employee = emp;
	}
	
	/**
	 * overridden equals(Object obj) to provide searching by overlap 
	 */
	@Override
    public boolean equals(Object obj) {
		boolean isEq = false;
		
		if (obj == null) return false;
        if (obj == this) return true; //if both pointing towards same object on heap

        BookedMeetingData ins = (BookedMeetingData) obj;
        //3 cases should be checked: 1) first meeting overlap second on left 2) first equal second or included in second 3) 1) first meeting overlap second on right     
        if( 
           (this.startMeeting.compareTo(ins.getStartMeeting()) < 0 && this.endMeeting.compareTo(ins.getEndMeeting()) < 0 && this.endMeeting.compareTo(ins.getStartMeeting()) > 0)
        || (this.startMeeting.compareTo(ins.getStartMeeting()) >= 0 && this.endMeeting.compareTo(ins.getEndMeeting()) <= 0 )
        || (this.startMeeting.compareTo(ins.getStartMeeting()) > 0 && this.endMeeting.compareTo(ins.getEndMeeting()) > 0 && this.startMeeting.compareTo(ins.getEndMeeting()) < 0)  ){
        	isEq = true;
        }
        
    	return isEq;
    }
	/**
	 * overridden hashCode() to provide searching by overlap 
	 */
    @Override
    public int hashCode() {
    	int hashCode = 17;
    	hashCode = hashCode * (int)(endMeeting.getTime() - startMeeting.getTime()); 
    	return hashCode;
    }

	public Date getStartMeeting() {
		return startMeeting;
	}

	public void setStartMeeting(Date startMeeting) {
		this.startMeeting = startMeeting;
	}

	public Date getEndMeeting() {
		return endMeeting;
	}

	public void setEndMeeting(Date endMeeting) {
		this.endMeeting = endMeeting;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
}

