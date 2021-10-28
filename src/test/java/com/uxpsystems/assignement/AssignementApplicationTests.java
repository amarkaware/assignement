package com.uxpsystems.assignement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uxpsystems.assignement.dao.UserRepository;
import com.uxpsystems.assignement.model.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AssignementApplicationTests {
	
	@Autowired
	UserRepository userRepository;

	/*@Test
	void contextLoads() {
	}*/
	
	@Test
	@Order(1)
	public void testSaveUser() {
		User user=new User();
		user.setUsername("amar");
		user.setPassword("1234");
		user.setStatus("active");
		
		userRepository.save(user);
		assertNotNull(userRepository.findById((long) 1).get());
	}
	
	
	@Test
	@Order(2)
	public void testReadAll () {
		List<User> list = userRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testRead () {
		User user = userRepository.findById((long) 1).get();
		assertEquals("amar", user.getUsername()	);
	}
	
	@Test
	@Order(4)
	public void testUpdate () {
		User user = userRepository.findById((long) 1).get();
		user.setStatus("Deactive");
		userRepository.save(user);
		System.out.println(user.getStatus());
		assertNotEquals("active", userRepository.findById((long) 1).get().getStatus());
	}
	
	
	@Test
	@Order(5)
	public void testDelete () {
		userRepository.deleteById((long) 1);
		assertThat(userRepository.existsById((long) 1)).isFalse();
	}
}
