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

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.exercise.data.TestData;
import com.exercise.service.AssetService;
import com.exercise.service.SpaceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpaceControllerTest {

	private MockMvc mockMvc;

	@MockBean
	private SpaceService mockSpaceService;
	
	@MockBean
	private AssetService mockAssetService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getAllSpaces_Success() throws Exception {
		given(mockSpaceService.getAllSpaces())
		.willReturn(TestData.SPACES);

		mockMvc.perform(get("/spaces"))
		.andExpect(status().is(200));
	}
	
	@Test
	public void getSpace_Success() throws Exception {
		given(mockSpaceService.getSpace("yadj1kx9rmg0"))
		.willReturn(TestData.SPACE1);

		mockMvc.perform(get("/spaces/yadj1kx9rmg0"))
		.andExpect(status().is(200))
		.andExpect(jsonPath("$.sys.id", is("yadj1kx9rmg0")))
		.andExpect(jsonPath("$.fields.title", is("My First Space")));
	}
	
	@Test
	public void getEntriesBySpace_Success() throws Exception {
		given(mockAssetService.getAllAssetsBySpace("yadj1kx9rmg0"))
		.willReturn(TestData.ASSETS);

		mockMvc.perform(get("/spaces/yadj1kx9rmg0/entries"))
		.andExpect(status().is(200))
		.andExpect(jsonPath("$.[0].fields.title", is("Hello, World!")))
		.andExpect(jsonPath("$.[1].fields.title", is("Tutorial 1")))
		.andExpect(jsonPath("$.[2].fields.title", is("Tutorial 2")))
		.andExpect(jsonPath("$.[0].sys.id", is("5KsDBWseXY6QegucYAoacS1")))
		.andExpect(jsonPath("$.[1].sys.id", is("5KsDBWseXY6QegucYAoacS2")))
		.andExpect(jsonPath("$.[2].sys.id", is("5KsDBWseXY6QegucYAoacS3")));

	}

}
