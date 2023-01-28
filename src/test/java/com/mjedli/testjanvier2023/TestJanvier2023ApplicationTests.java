package com.mjedli.testjanvier2023;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestJanvier2023ApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	void contextLoads() {
	}
	

	@Test
	public void homePage() {
		ResponseEntity<Object> entity = testRestTemplate.getForEntity("/", null);
		if (entity != null) {
			assertEquals(entity.getStatusCode(), HttpStatus.OK);
		}
	}
	
	@Test
	public void postInsertUser() {
		
		
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		
		String date = "Wed Dec 01 00:00:00 CET 2004";
		DateTimeFormatter df = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
		LocalDate  birthday = LocalDate.parse(date, df);
		
		map.add("lastname", "Mejdi");
		map.add("firstname", "JEDLI");
		map.add("nickname", "mjedli");
		map.add("birthday", birthday);
		map.add("email", "mejdi.jedli@lapost.net");
		map.add("country", "France");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(map, headers);

		ResponseEntity<Object> entity = testRestTemplate.postForEntity("/insert", requestEntity, null);
		
		if (entity != null) {
			assertEquals(entity.getStatusCode(), HttpStatus.OK);
		}

	}

	@Test
	public void listPage() {
		ResponseEntity<Object> entity = testRestTemplate.getForEntity("/list", null);
		if (entity != null) {
			assertEquals(entity.getStatusCode(), HttpStatus.OK);
		}
	}
	
	@Test
	public void detailsPage() {
		ResponseEntity<Object> entity = testRestTemplate.getForEntity("/user/0", null);
		if (entity != null) {
			assertEquals(entity.getStatusCode(), HttpStatus.OK);
		}
	}
	
}
