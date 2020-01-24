package com.example.SehirRehberiAPI.Model.response;

public enum  ErrorMessages {

    MISSING_REQUIRED_FIELDS("Missing required field. Please check documentation for required fields"),
    RECORD_ALREADY_EXIST("Record already exist"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    NO_RECORD_FOUND("Record with provided id is not found"),
    AUTHENTICATION_FAILED("Authentication failed"),
    COULD_NOT_UPDATE_RECORD("Could not update record"),
    COULD_NOT_DELETE_RECORD("Could not delete record"),
    EMAIL_ADDRESS_NOT_VERIFIED("Email address could not be verified"),
    EMAIL_OR_PASSWORD_INVALID("Email address or password is invalid"),
    ITEM_IS_NOT_FOUND("Item could not be found ");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
