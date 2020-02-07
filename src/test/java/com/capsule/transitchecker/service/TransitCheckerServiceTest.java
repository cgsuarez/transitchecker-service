package com.capsule.transitchecker.service;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capsule.transitchecker.service.impl.TransitCheckServiceImpl;

@RunWith(SpringRunner.class)
public class TransitCheckerServiceTest {

	@TestConfiguration
    static class TransitCheckerServiceSpringConfiguration {
  
        @Bean
        public TransitCheckService transitCheckService() {
            return new TransitCheckServiceImpl();
        }
    }
	
	@Autowired
    private TransitCheckService transitCheckService;
	
	@Test
	public void validateVehicleOutOfTransitTimeMonday() {
	     
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		 cal.set(Calendar.HOUR_OF_DAY, 7);
		 cal.set(Calendar.MINUTE, 8);
	  
	    boolean allow = 
	    		transitCheckService.isVehicleAllowedTransit("PBV1231",
	    				cal.getTime());
	    Assert.assertEquals(false, allow);	    
	 }
	
	@Test
	public void validateVehicleOutOfTransitTimeTuesday() {
	     
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		 cal.set(Calendar.HOUR_OF_DAY, 16);
		 cal.set(Calendar.MINUTE, 31);
	  
	    boolean allow = 
	    		transitCheckService.isVehicleAllowedTransit("PBV1233",
	    				cal.getTime());
	    Assert.assertEquals(false, allow);	    
	 }
	
	@Test
	public void validateVehicleOutOfTransitTimeWednesday() {
	     
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		 cal.set(Calendar.HOUR_OF_DAY, 18);
		 cal.set(Calendar.MINUTE, 59);
	  
	    boolean allow = 
	    		transitCheckService.isVehicleAllowedTransit("PBV1235",
	    				cal.getTime());
	    Assert.assertEquals(false, allow);	    
	 }
	
	@Test
	public void validateVehicleOutOfTransitTimeAllow() {
	     
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		 cal.set(Calendar.HOUR_OF_DAY, 18);
		 cal.set(Calendar.MINUTE, 59);
	  
	    boolean allow = 
	    		transitCheckService.isVehicleAllowedTransit("PBV1233",
	    				cal.getTime());
	    Assert.assertEquals(true, allow);	    
	 }
	
	@Test
	public void validateVehicleOutOfTransitTimeAllowFriday() {
	     
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		 cal.set(Calendar.HOUR_OF_DAY, 15);
		 cal.set(Calendar.MINUTE, 59);
	  
	    boolean allow = 
	    		transitCheckService.isVehicleAllowedTransit("PBV1230",
	    				cal.getTime());
	    Assert.assertEquals(true, allow);	    
	 }
	
	@Test
	public void validateVehicleOutOfTransitTimeDisallowFriday() {
	     
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		 cal.set(Calendar.HOUR_OF_DAY, 17);
		 cal.set(Calendar.MINUTE, 26);
	  
	    boolean allow = 
	    		transitCheckService.isVehicleAllowedTransit("PBV6540",
	    				cal.getTime());
	    Assert.assertEquals(false, allow);	    
	 }
}
