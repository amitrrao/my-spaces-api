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

import com.exercise.base.Type;
import com.exercise.data.TestData;
import com.exercise.exceptions.ItemNotFoundException;
import com.exercise.service.AssetService;
import com.exercise.service.EntryService;
import com.exercise.service.SpaceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpaceControllerTest {

	private MockMvc mockMvc;

	@MockBean
	private SpaceService mockSpaceService;
	
	@MockBean
	private AssetService mockAssetService;
	
	@MockBean
	private EntryService mockEntryService;

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
	public void getSpace_NotFound() throws Exception {
		given(mockSpaceService.getSpace("yadj1kx9rmg01"))
		.willThrow(new ItemNotFoundException(Type.SPACE.getType() + " not found."));
		
		mockMvc.perform(get("/spaces/yadj1kx9rmg01"))
		.andExpect(status().is(404))
		.andExpect(jsonPath("$.message", is("Space not found.")));
	}
	
	@Test
	public void getEntriesBySpace_Success() throws Exception {
		given(mockEntryService.getAllEntriesBySpace("yadj1kx9rmg0"))
		.willReturn(TestData.ENTRIES);

		mockMvc.perform(get("/spaces/yadj1kx9rmg0/entries"))
		.andExpect(status().is(200))
		.andExpect(jsonPath("$.[0].fields.title", is("Hello, World!")))
		.andExpect(jsonPath("$.[1].fields.title", is("Tutorial 1")))
		.andExpect(jsonPath("$.[2].fields.title", is("Tutorial 2")))
		.andExpect(jsonPath("$.[0].sys.id", is("5KsDBWseXY6QegucYAoacS1")))
		.andExpect(jsonPath("$.[1].sys.id", is("5KsDBWseXY6QegucYAoacS2")))
		.andExpect(jsonPath("$.[2].sys.id", is("5KsDBWseXY6QegucYAoacS3")));
	}
	
	@Test
	public void getEntriesBySpaceIdAndEntryId_Success() throws Exception {
		given(mockEntryService.getEntryBySpaceIdAndEntryId("yadj1kx9rmg0", "5KsDBWseXY6QegucYAoacS1"))
		.willReturn(TestData.ENTRY1);

		mockMvc.perform(get("/spaces/yadj1kx9rmg0/entries/5KsDBWseXY6QegucYAoacS1"))
		.andExpect(status().is(200))
		.andExpect(jsonPath("$.fields.title", is("Hello, World!")))
		.andExpect(jsonPath("$.sys.id", is("5KsDBWseXY6QegucYAoacS1")));
	}
	
	@Test
	public void getEntriesBySpaceIdAndEntryId_NotFound() throws Exception {
		given(mockEntryService.getEntryBySpaceIdAndEntryId("yadj1kx9rmg0", "5KsDBWseXY6QegucYAoacS11"))
		.willThrow(new ItemNotFoundException(Type.ENTRY.getType() + " not found."));

		mockMvc.perform(get("/spaces/yadj1kx9rmg0/entries/5KsDBWseXY6QegucYAoacS11"))
		.andExpect(status().is(404))
		.andExpect(jsonPath("$.message", is("Entry not found.")));
	}
	
	@Test
	public void getAssetsBySpace_Success() throws Exception {
		given(mockAssetService.getAllAssetsBySpace("yadj1kx9rmg0"))
		.willReturn(TestData.ASSETS);

		mockMvc.perform(get("/spaces/yadj1kx9rmg0/assets"))
		.andExpect(status().is(200))
		.andExpect(jsonPath("$.[0].fields.title", is("Hero Collaboration Partial")))
		.andExpect(jsonPath("$.[1].fields.title", is("Stride Chat")))
		.andExpect(jsonPath("$.[2].fields.title", is("Get Started")))
		.andExpect(jsonPath("$.[0].sys.id", is("wtrHxeu3zEoEce2MokCSi1")))
		.andExpect(jsonPath("$.[1].sys.id", is("wtrHxeu3zEoEce2MokCSi2")))
		.andExpect(jsonPath("$.[2].sys.id", is("wtrHxeu3zEoEce2MokCSi3")));
	}

	@Test
	public void getAssetsBySpaceIdAndAssetId_Success() throws Exception {
		given(mockAssetService.getAssetBySpaceIdAndAssetId("yadj1kx9rmg0", "wtrHxeu3zEoEce2MokCSi1"))
		.willReturn(TestData.ASSET1);

		mockMvc.perform(get("/spaces/yadj1kx9rmg0/assets/wtrHxeu3zEoEce2MokCSi1"))
		.andExpect(status().is(200))
		.andExpect(jsonPath("$.fields.title", is("Hero Collaboration Partial")))
		.andExpect(jsonPath("$.sys.id", is("wtrHxeu3zEoEce2MokCSi1")));
	}
	

	@Test
	public void getAssetsBySpaceIdAndAssetId_NotFound() throws Exception {
		given(mockAssetService.getAssetBySpaceIdAndAssetId("yadj1kx9rmg0", "wtrHxeu3zEoEce2MokCSi11"))
		.willThrow(new ItemNotFoundException(Type.ASSET.getType() + " not found."));

		mockMvc.perform(get("/spaces/yadj1kx9rmg0/assets/wtrHxeu3zEoEce2MokCSi11"))
		.andExpect(status().is(404))
		.andExpect(jsonPath("$.message", is("Asset not found.")));
	}
	
	//TODO: what to expect here?
	@Test
	public void testInvalidUrl() throws Exception {
		mockMvc.perform(get("/spac"))
		.andExpect(status().is(404)); // TODO: 404? or 400?
	}
	
}
