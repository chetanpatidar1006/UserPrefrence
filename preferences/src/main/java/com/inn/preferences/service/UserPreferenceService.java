package com.inn.preferences.service;

import com.inn.preferences.model.UserPreference;
import com.inn.preferences.repository.UserPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPreferenceService {

    @Autowired
    private UserPreferenceRepository preferenceRepository;

    public Optional<UserPreference> getPreferences(Integer userId) {
        return Optional.ofNullable(preferenceRepository.findByUserId(userId));
    }

    public UserPreference savePreferences(UserPreference preference) {
        return preferenceRepository.save(preference);
    }
}
