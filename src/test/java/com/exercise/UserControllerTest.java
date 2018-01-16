package com.exercise;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.exercise.base.Type;
import com.exercise.controller.UserController;
import com.exercise.data.TestData;
import com.exercise.exceptions.ItemNotFoundException;
import com.exercise.service.UserService;

/**
 * Unit tests for testing the UserController.
 * 
 * Note: Mocking the service is redundant here since all the data in the service is coming
 * from the TestData class. These tests are written considering that the data will eventually
 * reside in the database.
 * 
 * @author arao
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	private MockMvc mockMvc;
	
	@MockBean
	private UserService mockUserService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void getAllUsers_Success() throws Exception {
		given(mockUserService.getAllUsers())
		.willReturn(TestData.USERS);

		mockMvc.perform(get("/users"))
		.andExpect(status().is(200));
	}

	@Test
	public void getUser_Success() throws Exception {
		given(mockUserService.getUser("4FLrUHftHW3v2BLi9fzfjU"))
		.willReturn(TestData.USER1);

		mockMvc.perform(get("/users/4FLrUHftHW3v2BLi9fzfjU"))
		.andExpect(status().is(200))
		.andExpect(jsonPath("$.sys.id", is("4FLrUHftHW3v2BLi9fzfjU")))
		.andExpect(jsonPath("$.fields.name", is("Alana Atlassian")));
	}
	
	@Test
	public void getUser_NotFound() throws Exception {
		given(mockUserService.getUser("4FLrUHftHW3v2BLi9fzfjU12"))
		.willThrow(new ItemNotFoundException(Type.USER.getType() + " not found."));
		
		mockMvc.perform(get("/users/4FLrUHftHW3v2BLi9fzfjU12"))
		.andExpect(status().is(404))
		.andExpect(jsonPath("$.message", is("User not found.")));
	}
}
