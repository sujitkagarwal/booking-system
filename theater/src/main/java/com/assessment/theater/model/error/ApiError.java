package com.assessment.theater.model.error;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class ApiError {

    @NonNull
    private final String code;
    @NonNull
    private final String message;
    @NonNull
    private final ApiErrorSeverity severity;
    private final String source;
    private final String target;
    @Singular
    private final List<ApiInnerError> innerErrors;

    @Data
    @Builder
    public static class ApiInnerError {

        @NonNull
        private final String code;
        @NonNull
        private final String message;
        @NonNull
        private final ApiErrorSeverity severity;
        private final String source;
        private final String target;

    }

}
