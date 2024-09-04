package com.inn.preferences;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.inn.preferences.model.UserPreference;
import com.inn.preferences.repository.UserPreferenceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class PreferencesApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserPreferenceRepository preferenceRepository;

	@Test
	void testGetPreferences() throws Exception {
		UserPreference preference = new UserPreference();
		preference.setUserId(1);
		preference.setDarkMode(Boolean.TRUE);
		preference.setPlatforms(Arrays.asList("Facebook", "Twitter"));
		preferenceRepository.save(preference);

		mockMvc.perform(get("/userPreference/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.darkMode").value(Boolean.TRUE))
				.andExpect(jsonPath("$.platforms").isArray());
	}

	@Test
	void testUpdatePreferences() throws Exception {
		UserPreference preference = new UserPreference();
		preference.setDarkMode(Boolean.FALSE);
		preference.setPlatforms(Arrays.asList("Facebook", "Yahoo"));

		mockMvc.perform(put("/userPreference/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(preference)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.darkMode").value(Boolean.FALSE))
        		.andExpect(jsonPath("$.platforms").isArray());
	}
}

