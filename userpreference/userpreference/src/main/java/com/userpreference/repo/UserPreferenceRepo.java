package com.userpreference.repo;

import com.userpreference.model.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferenceRepo extends JpaRepository<UserPreference, Integer> {
    UserPreference findByUserId(Integer userId);


}
