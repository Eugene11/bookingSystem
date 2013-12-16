package com.mycom.myapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.myapp.data.BookingInfo;
import com.mycom.myapp.data.BookingOutInfo;
import com.mycom.myapp.service.BookingService;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("booking")
public class HomeController {
	
	/**
	 * Service for booking
	 */
	@Autowired
	protected BookingService bookingServce;
	
	/**
	 * Simple logger log4j
	 */
	protected static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * This list is for storing output data because db is not used 
	 */
	protected List<BookingOutInfo> listBook = null;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	/**
	 *  handles batch booking request
	 * @param bookingList
	 * @return list of successfull booking grouped by day
	 */
	@RequestMapping(value="book", method=RequestMethod.POST)
    public @ResponseBody boolean book(@RequestBody List<BookingInfo> bookingList) {
		List<BookingOutInfo> listOut = bookingServce.processBooking(bookingList);
		this.listBook = listOut;
		return true;
	}
	
	/**
	 * show booked meetings
	 * @param model
	 * @return
	 */
    @RequestMapping(value="booked", method=RequestMethod.GET)
    public ModelAndView getBooked(Model model) {
    	 
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("booked");
    	mav.addObject("listOutBook", this.listBook);
    	 
    	return mav;
    }
    
}
