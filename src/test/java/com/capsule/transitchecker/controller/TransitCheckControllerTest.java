package com.capsule.transitchecker.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.capsule.transitchecker.Application;
import com.capsule.transitchecker.controllers.rest.TransitCheckController;
import com.capsule.transitchecker.dto.AllowTransitRequest;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={Application.class})
@WebMvcTest(TransitCheckController.class)
public class TransitCheckControllerTest {

	@Autowired
    private MockMvc mvc;
	
	
	 @Test
	 public void testVehicleAllowedGivenParameters() throws Exception{
		 
		 Gson gson = new Gson();
		 mvc.perform(post("/api/transitcheck/isAllowTransit")
		  .content(gson.toJson(new AllowTransitRequest("PBC001", "02/01/2020", "07:34")))
		  .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());	      
	 }
}
