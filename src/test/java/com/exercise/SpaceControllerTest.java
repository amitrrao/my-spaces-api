package com.exercise;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.exercise.service.SpaceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpaceControllerTest {
	
	private MockMvc mockMvc;
	
	@MockBean
	private SpaceService mockSpaceService;

	@Autowired
    private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	@Test
	public void getAllSpaces_Success() {
		
		System.out.println("Aru: Test");
	}

}
