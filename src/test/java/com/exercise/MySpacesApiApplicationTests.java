package com.exercise;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.exercise.controller.SpaceController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpacesApiApplicationTests {
	
	@Autowired
	private SpaceController spaceController;

	@Test
	public void contextLoads() {
		assertThat(spaceController).isNotNull();
	}

}
