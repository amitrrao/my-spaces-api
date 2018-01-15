package com.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.exercise.service.SpaceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpaceControllerTest {
	
	@MockBean
	private SpaceService spaceServicerMock;

	@Test
	public void test() {
		System.out.println("Aru: Test");
	}

}
