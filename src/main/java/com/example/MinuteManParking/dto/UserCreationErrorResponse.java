package com.example.MinuteManParking.dto;

public class UserCreationErrorResponse {
    private boolean isUsernameExist;
    private boolean isEmailExist;

    public UserCreationErrorResponse() {
    }

    public UserCreationErrorResponse(boolean isUsernameExist, boolean isEmailExist) {
        this.isUsernameExist = isUsernameExist;
        this.isEmailExist = isEmailExist;
    }

    public boolean isUsernameExist() {
        return isUsernameExist;
    }

    public void setUsernameExist(boolean usernameExist) {
        isUsernameExist = usernameExist;
    }

    public boolean isEmailExist() {
        return isEmailExist;
    }

    public void setEmailExist(boolean emailExist) {
        isEmailExist = emailExist;
    }
}
