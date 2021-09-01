package com.example.dailymeal.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private static String userId;
    private static String displayName;

    public LoggedInUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public static String getUserId() {
        return userId;
    }

    public static String getDisplayName() {
        return displayName;
    }

    public static void setDisplayName(String displayName) {
        LoggedInUser.displayName = displayName;
    }

    public static void setUserId(String userId) {
        LoggedInUser.userId = userId;
    }
}