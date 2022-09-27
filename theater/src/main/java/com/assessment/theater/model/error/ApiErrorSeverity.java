package com.assessment.theater.model.error;

import lombok.NonNull;
import org.springframework.http.HttpStatus;

public enum ApiErrorSeverity {

    ERROR,
    WARNING;

    public static ApiErrorSeverity getSeverityByStatus(@NonNull HttpStatus httpStatus) {
        if (httpStatus == HttpStatus.NOT_FOUND) {
            return WARNING;
        } else {
            return ERROR;
        }
    }

}
