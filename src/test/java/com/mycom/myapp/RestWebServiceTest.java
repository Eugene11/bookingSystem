package com.mycom.myapp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mycom.myapp.data.BookingInfo;
import com.mycom.myapp.data.BookingOutInfo;
import com.mycom.myapp.service.BookingService;

import javax.annotation.Resource;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.server.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;


/**
 * Class for unit testing BookingService bean
 * @author Eugene
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-conf.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration 
public class RestWebServiceTest    {
	
	/**
	 * Service for booking
	 */
	@Autowired
	protected BookingService bookingServce;
	
	/**
	 * test for default case
	 * @throws Exception
	 */
    @Test
    public void testSet1() throws Exception  {  
    	ObjectMapper mapper = new ObjectMapper();
    	
    	String strExpResp = mapper.readTree( new BufferedReader(new FileReader("test1Expect.json")) ).toString();
    	
    	ArrayList<BookingInfo> listInput = mapper.readValue(new FileReader("test1Input.json"), new TypeReference<ArrayList<BookingInfo>>() {} );
    	List<BookingOutInfo> listOutput = bookingServce.processBooking(listInput);
    	String listOutputStr = mapper.writeValueAsString(listOutput);
    	
    	Assert.assertEquals(listOutputStr, strExpResp);
    	
    }
    
    /**
     * test case when meetings overlaps
     * @throws Exception
     */
    @Test  
    public void testSet2() throws Exception  {
    	ObjectMapper mapper = new ObjectMapper();
    	
    	String strExpResp = mapper.readTree( new BufferedReader(new FileReader("test2Expect.json")) ).toString();
    	
    	ArrayList<BookingInfo> listInput = mapper.readValue(new FileReader("test2Input.json"), new TypeReference<ArrayList<BookingInfo>>() {} );
    	List<BookingOutInfo> listOutput = bookingServce.processBooking(listInput);
    	String listOutputStr = mapper.writeValueAsString(listOutput);
    	
    	Assert.assertEquals(listOutputStr, strExpResp);
    }
    
    /**
     * test case when meetings overlaps and sort correctly(all possible business logic cases)
     * @throws Exception
     */
    @Test  
    public void testSet3() throws Exception  {
    	ObjectMapper mapper = new ObjectMapper();
    	
    	String strExpResp = mapper.readTree( new BufferedReader(new FileReader("test3Expect.json")) ).toString();
    	
    	ArrayList<BookingInfo> listInput = mapper.readValue(new FileReader("test3Input.json"), new TypeReference<ArrayList<BookingInfo>>() {} );
    	List<BookingOutInfo> listOutput = bookingServce.processBooking(listInput);
    	String listOutputStr = mapper.writeValueAsString(listOutput);
    	
    	Assert.assertEquals(listOutputStr, strExpResp);
    }
    
    
}  