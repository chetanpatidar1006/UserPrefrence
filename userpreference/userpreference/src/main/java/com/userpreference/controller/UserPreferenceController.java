package com.userpreference.controller;

import com.userpreference.model.UserPreference;
import com.userpreference.service.UserPreferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * REST controller for managing user preferences.
 */
@RestController
@RequestMapping("/user-preference")
public class UserPreferenceController {


    private static final Logger logger = LoggerFactory.getLogger(UserPreferenceService.class);
    @Autowired
    private UserPreferenceService userPreferenceService;

    /**
     * Retrieves the user preference for a given user ID.
     *
     * @param userId the ID of the user
     * @return the user preference if found, or a 404 Not Found status
     */
    @Operation(summary = "Get user preferences", description = "Retrieve the preferences for a specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User preferences found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{userId}")
    public ResponseEntity<UserPreference> getUserPreference(@PathVariable Integer userId) {
        logger.info("Getting user preference for user ID: {}", userId);

        UserPreference preference = userPreferenceService.getUserPreference(userId);
        if (preference == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(preference);
    }

    /**
     * Updates the user preference for a given user ID.
     *
     * @param userId the ID of the user
     * @param userPreference the new user preference data
     * @return the updated user preference
     */
    @Operation(summary = "Update user preferences", description = "Update the preferences for a specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Preferences updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PutMapping("/{userId}/update")
    public ResponseEntity<UserPreference> updateUserPreference(
            @PathVariable Integer userId, @RequestBody UserPreference userPreference) {
        logger.info("Updating user preference for user ID: {} , {}", userId , userPreference);

        UserPreference updatedPreference = userPreferenceService.updateUserPreference(userId, userPreference);
        return ResponseEntity.ok(updatedPreference);
    }

    /**
     * A simple endpoint to test the controller.
     *
     * @return a greeting message
     */
    @Operation(summary = "Testing Service", description = "Testing the service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Service is working fine"),
            @ApiResponse(responseCode = "404", description = "Service is not working fine")
    })
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

}

