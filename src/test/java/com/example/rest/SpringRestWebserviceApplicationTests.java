package com.example.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRestWebserviceApplicationTests {
	
	
	private MockMvc mockMvc;

	@Autowired
	    private WebApplicationContext wac;

	@Before
	public void setup() {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}


	@Test
	public void contextLoads() throws Exception {





	mockMvc.perform(MockMvcRequestBuilders.post("/count")
	.contentType(MediaType.APPLICATION_JSON)
	.content("{\"para\" : \"New ToDo Sample\"}")
	.accept(MediaType.APPLICATION_JSON))
	.andExpect(status().isOk());
	
		
		  mockMvc.perform(MockMvcRequestBuilders.post("/count")
		  .contentType(MediaType.APPLICATION_JSON) .content("{\"\"}")
		  .accept(MediaType.APPLICATION_JSON)) .andExpect(status().isBadRequest());
		 
	
		
		  mockMvc.perform(MockMvcRequestBuilders.post("/customer")
		  .contentType(MediaType.APPLICATION_JSON)
		  .content("{\"fst_nm\" : \"Karthick\" ,\n" + "	\"last_nm\" : \"Tst\",\n" +
		  "	\"gender\" : \"male\",\n" + "	\"dob\" : \"01 JAN 1990\",\n" +
		  "	\"phone\" : \"1234567890\",\n" +
		  "	\"addresses\" : [{\"addr_ln1\" : \"123 main st\", \"addr_ln2\": \"a4\",\"city\":\"okemos\",\"state\":\"michigan\",\"zip\":\"48864\" }]}"
		  ) .accept(MediaType.APPLICATION_JSON)) .andExpect(status().isOk());
		 
		
		
		
		  mockMvc.perform(MockMvcRequestBuilders.get("/findCustomer?id=10")
		  .contentType(MediaType.APPLICATION_JSON)
		  .accept(MediaType.APPLICATION_JSON)) .andExpect(status().isOk());
		  
		  mockMvc.perform(MockMvcRequestBuilders.get("/findCustomer?id=1")
				  .contentType(MediaType.APPLICATION_JSON)
				  .accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
		  
		  mockMvc.perform(MockMvcRequestBuilders.get("/findAllCustomer")
		  .contentType(MediaType.APPLICATION_JSON) .content("{}")
		  .accept(MediaType.APPLICATION_JSON)) .andExpect(status().isOk());
		 
		 
	
	
	}

}
