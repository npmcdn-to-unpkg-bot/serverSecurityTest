package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerSecuritytestApplication.class)
@WebAppConfiguration
public class ServerSecuritytestApplicationTests {



	private MockMvc mockMvc;


	@Autowired
	private ApplicationContext context;

	private Authentication authentication;
	private AuthenticationManager authenticationManager;

	@Before
	public void setUp() throws Exception {

//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//				.build();

		authenticationManager = this.context
				.getBean(AuthenticationManager.class);
	}

	@After
	public void close() {
		SecurityContextHolder.clearContext();
	}

	@Test
	public void authenticated() throws Exception {
		this.authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken("user", "pass"));
		SecurityContextHolder.getContext().setAuthentication(this.authentication);
	}

	@Test(expected=BadCredentialsException.class)
	public void failAuthenticated() throws Exception {
		this.authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken("user", "wrongPassword"));

		SecurityContextHolder.getContext().setAuthentication(this.authentication);



		// TODO: 2016-04-22 :18:49 to understand assertThat and is var's
		//they are static imports
//		import static org.hamcrest.Matchers.is;
//		import static org.junit.Assert.assertThat;
//		assertThat(123, is("Greetings from Spring Boot!"));

	}
}
