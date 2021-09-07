package com.example.dailymeal.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private static String userId;
    private static String displayName;
    private static String email;
    private static String phone;
    private static String address;

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        LoggedInUser.email = email;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        LoggedInUser.address = address;
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

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        LoggedInUser.phone = phone;
    }

    public static void removeUser() {
        userId = null;
        displayName = null;
        email = null;
        phone = null;
        address = null;
    }
}