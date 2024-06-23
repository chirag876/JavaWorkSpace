package com.ApiDesign.Arch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.ApiDesign.Arch.Application.Domain.Entity.Contact;

@SpringBootTest
class ArchApplicationTests {

//	@Test
//	void contextLoads() {
//		Contact contact = new Contact();
//		
//		contact.setId(489);
//		contact.setName("Roshan");
//		contact.setPhone("8529637410");
//		
//		.
//	}
//	

	
	

	
	@Test
	public void testContact() {
		Contact contact = new Contact();
		contact.setId(489);
		contact.setName("Roshan");
		contact.setPhone("8529630741");
		
		
//		Contact responce = restTemplate.postForObject(baseUrl, contact, Contact.class);
		assertEquals(489, contact.getId());
	}
	
	@Test
	public void testContact1() {
		Contact contact = new Contact();
		contact.setId(630);
		contact.setName("Shreyan");
		contact.setPhone("56789008");
		
		
//		Contact responce = restTemplate.postForObject(baseUrl, contact, Contact.class);
		assertEquals(630, contact.getId());
	}

}
