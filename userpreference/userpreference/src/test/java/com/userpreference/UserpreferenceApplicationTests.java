package com.userpreference;

import com.userpreference.model.UserPreference;
import com.userpreference.repo.UserPreferenceRepo;
import com.userpreference.service.UserPreferenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class UserpreferenceApplicationTests {


	@Mock
	private UserPreferenceRepo userPreferenceRepository;

	@InjectMocks
	private UserPreferenceService userPreferenceService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetUserPreference() {
		// Given
		UserPreference userPreference = new UserPreference();
		userPreference.setUserId(1);
		userPreference.setDarkMode(true);
		userPreference.setPlatforms(Arrays.asList("Twitter,Yahoo"));

		when(userPreferenceRepository.findByUserId(1)).thenReturn(userPreference);

		// When
		UserPreference result = userPreferenceService.getUserPreference(1);

		// Then
		assertEquals(true, result.isDarkMode());
		assertEquals(Arrays.asList("Twitter,Yahoo"), result.getPlatforms());
	}

	@Test
	public void testUpdateUserPreference() {
		// Given
		UserPreference userPreference = new UserPreference();
		userPreference.setUserId(1);
		userPreference.setDarkMode(false);
		userPreference.setPlatforms(Arrays.asList("Twitter,Yahoo"));

		when(userPreferenceRepository.save(userPreference)).thenReturn(userPreference);

		// When
		UserPreference result = userPreferenceService.updateUserPreference(1, userPreference);

		// Then
		assertEquals(false, result.isDarkMode());
		assertEquals(Arrays.asList("Twitter,Yahoo"), result.getPlatforms());
	}
}
