package com.mjedli.testjanvier2023;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.xml.xpath.XPathExpressionException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.times;

import com.mjedli.testjanvier2023.model.User;
import com.mjedli.testjanvier2023.user.UserService;

@SpringBootTest
@AutoConfigureMockMvc
class TestJanvier2023MockApplication {


	@Autowired
	MockMvc mockMvcTest;
	
	@MockBean
	private UserService userService;
	
	/**
	 * <p>
	 * Test controlleur home page
	 * </p>
	 */
	@Test
	public void homePage() throws Exception {
		mockMvcTest.perform(MockMvcRequestBuilders.get("/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Bienvenue")))
			.andExpect(view().name("home"));
	}
	
	
	
	/**
	 * <p>
	 * Test controlleur de bout en bout insert user
	 * </p>
	 * @throws Exception 
	 * @throws XPathExpressionException 
	 */
	@Test
	public void postInsertUser() throws XPathExpressionException, Exception {
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		
		String date = "Wed Dec 01 00:00:00 CET 2004";
		DateTimeFormatter df = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
		LocalDate  birthday = LocalDate.parse(date, df);
		
		String birthdayString = birthday.toString();
		
		map.add("lastname", "Mejdi");
		map.add("firstname", "JEDLI");
		map.add("nickname", "mjedli");
		map.add("birthday", birthdayString);
		map.add("email", "mejdi.jedli@lapost.net");
		map.add("country", "France");
		
		try {
			mockMvcTest.perform(
					MockMvcRequestBuilders.post("/insert").queryParams(map)
						.contentType("text/html;charset=UTF-8")
						.accept("text/html;charset=UTF-8")
				)
					.andExpect(xpath("/html/head/title").string(containsString("Bienvenue")));
		} catch (Exception e) {

		}
	
	}

	/**
	 * <p>
	 * Test controlleur list page
	 * </p>
	 * @throws Exception 
	 */
	@Test
	public void listPage() throws Exception {
		mockMvcTest.perform(MockMvcRequestBuilders.get("/list"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Bienvenue")))
		.andExpect(view().name("list"));
	}
	
	
	/**
	 * <p>
	 * Test controlleur details page
	 * </p>
	 * @throws Exception 
	 */
	@Test
	public void detailsPage() throws Exception {
		
		User user = new User();
		
		Mockito.when(userService.findUserById(new Long(0))).thenReturn(user);
		
		mockMvcTest.perform(MockMvcRequestBuilders.get("/user/0").flashAttr("user", user))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("details"));
		
		Mockito.verify(userService, times(1)).findUserById(new Long(0));
	}
	
}
