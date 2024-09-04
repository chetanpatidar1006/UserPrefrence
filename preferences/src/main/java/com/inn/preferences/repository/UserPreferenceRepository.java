package com.inn.preferences.repository;

import com.inn.preferences.model.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferenceRepository extends   JpaRepository<UserPreference , Integer> {
    UserPreference findByUserId(Integer id);
}