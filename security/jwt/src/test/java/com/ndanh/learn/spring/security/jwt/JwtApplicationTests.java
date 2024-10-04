package com.ndanh.learn.spring.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndanh.learn.spring.security.jwt.http.JwtRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class JwtApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper; // Jackson object mapper for JSON serialization

	@Test
	public void testLogin_Success() throws Exception {
		// Create a login request
		JwtRequest authRequest = new JwtRequest();
		authRequest.setUsername("admin");
		authRequest.setPassword("password");

		mockMvc.perform(post("/authenticate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(authRequest)))
				.andExpect(status().isOk()) // Expect 200 OK
				.andExpect(jsonPath("$.jwt").isNotEmpty()) // Expect access token present
				.andExpect(jsonPath("$.refreshToken").isNotEmpty()); // Expect refresh token present
	}

	@Test
//	@WithMockUser // Optional: Use if you want to simulate a logged-in user
	public void testSecureEndpoint() throws Exception {
		String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcyODAzNjI0NiwiZXhwIjoxNzI4MDM3MTQ2fQ.bNckNizDoX9A8C0JH0HU7qMNLsBbVZV6ftLHu9mQr7E";

		mockMvc.perform(get("/user/1")
						.header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk());
	}

}
