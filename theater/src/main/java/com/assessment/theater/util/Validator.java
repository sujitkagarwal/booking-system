package com.assessment.theater.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
public class Validator {

    public static final String ZIP_CODE_PATTERN = "^[0-9]{6}$";

    public static void checkSuppressedFields(BindingResult bindingResult) {
        if (bindingResult != null && (bindingResult.hasErrors() || bindingResult.getSuppressedFields().length > 0)) {
            log.warn("Request validation has failed as it contains suppressed fields");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
