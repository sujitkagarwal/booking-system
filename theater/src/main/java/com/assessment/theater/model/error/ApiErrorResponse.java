package com.assessment.theater.model.error;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ApiErrorResponse {

    @NonNull
    private final ApiError error;

}