package com.personal.portfolio.dto.response;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public class ResponseError {

    private Date timestamp;
    private String message;
    private String details;


    public ResponseError setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseError setDetails(String details) {
        this.details = details;
        return this;
    }

    public ResponseError setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
