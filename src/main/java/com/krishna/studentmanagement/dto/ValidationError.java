package com.krishna.studentmanagement.dto;

import java.util.Map;

public class ValidationError {

    private int status;
    private Map<String, String> errors;
    private String path;

    public ValidationError(int status, Map<String, String> errors, String path) {
        this.status = status;
        this.errors = errors;
        this.path = path;
    }

    public int getStatus()
    {
        return this.status;
    }
    
    public Map<String, String> getErrors() {
        return this.errors;
    }

    public String getPath()
    {
        return this.path;
    }
}
