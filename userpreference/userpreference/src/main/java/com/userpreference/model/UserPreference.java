package com.userpreference.model;


import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Entity
@Schema(description = "User_preferences")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the userpref", example = "1")
    private Integer userPrefId;
    @Schema(description = "Unique identifier for the user", example = "1")
    private Integer userId;
    @Schema(description = "Indicates if dark mode is enabled", example = "true")
    private boolean darkMode;

    @Schema(description = "List of social media platforms", example = "['Facebook','Instagram','Twitter']")
    @ElementCollection
    private List<String> platforms; // e.g., "Facebook,Instagram,Twitter"

    public Integer getUserPrefId() {
        return userPrefId;
    }

    public void setUserPrefId(Integer userPrefId) {
        this.userPrefId = userPrefId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    @Override
    public String toString() {
        return "UserPreference{" +
                "userPrefId=" + userPrefId +
                ", userId=" + userId +
                ", darkMode=" + darkMode +
                ", platforms=" + platforms +
                '}';
    }
}
