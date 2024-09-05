package com.userpreference.service;

import com.userpreference.model.UserPreference;
import com.userpreference.repo.UserPreferenceRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPreferenceService {
    private static final Logger logger = LoggerFactory.getLogger(UserPreferenceService.class);



    @Autowired
    private UserPreferenceRepo userPreferenceRepository;




    public UserPreference getUserPreference(Integer userId) {
        logger.info("Getting user preference for user ID at service: {}", userId);
        UserPreference userPreference= userPreferenceRepository.findByUserId(userId);
        if (userPreference == null) {
            logger.warn("User preference with ID: {} not found", userId);
        } else {
            logger.info("Fetched user preference: {}", userPreference);
        }
        return userPreference;

    }

    public UserPreference updateUserPreference(Integer userId, UserPreference userPreference) {

        userPreference.setUserId(userId);
        try {
            UserPreference userPreference1= userPreferenceRepository.findByUserId(userId);
            userPreference.setUserPrefId(userPreference1.getUserPrefId());
            logger.warn("User preference ID is null, setting a new ID");
            logger.info("Updating user preference for user ID at service : {}", userId);
            UserPreference savedPreference = userPreferenceRepository.save(userPreference);
            logger.info("Saved user preference with ID: {}", savedPreference.getUserPrefId());
            return savedPreference;
        }catch (Exception e){
            logger.warn("No user is found with the given ID");
            UserPreference savedPreference = userPreferenceRepository.save(userPreference);
            return savedPreference;
        }


    }

    public UserPreference saveUserPreference(UserPreference userPreference) {
        // Ensure that userPreference has a valid userId or handle it accordingly
        return userPreferenceRepository.save(userPreference);
    }
}
