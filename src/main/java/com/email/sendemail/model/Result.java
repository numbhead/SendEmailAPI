package com.email.sendemail.model;

public class Result {
    
    private boolean successFlag;
    private String message;
    private String errorMessage;
    
    public boolean isSuccessFlag() {
        return successFlag;
    }
    public void setSuccessFlag(boolean successFlag) {
        this.successFlag = successFlag;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    
}
