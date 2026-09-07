package com.krishna.studentmanagement.dto;

public class ErrorResponse {

    private int status;
    private String message;
    private String path;

    public ErrorResponse(int status, String message, String path)
    {
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public int getStatus()
    {
        return this.status;
    }

    public String getMessage()
    {
        return this.message;
    }

    public String getPath()
    {
        return this.path;
    }
    
}
