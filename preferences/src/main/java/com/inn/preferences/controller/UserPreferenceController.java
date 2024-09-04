package com.inn.preferences.controller;


import com.inn.preferences.model.UserPreference;
import com.inn.preferences.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/userPreference")
public class UserPreferenceController {

    @Autowired
    UserPreferenceService userPreferenceService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserPreference> getPreferences(@PathVariable Integer userId) {
        Optional<UserPreference> preference = userPreferenceService.getPreferences(userId);
        return preference.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserPreference> updatePreferences(@PathVariable Integer userId, @RequestBody UserPreference preference) {
        preference.setUserId(userId);
        return ResponseEntity.ok(userPreferenceService.savePreferences(preference));
    }

    @GetMapping("Test")
    String Test(){
        return "Pass";
    }
}
