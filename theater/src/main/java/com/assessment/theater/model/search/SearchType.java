package com.assessment.theater.model.search;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SearchType {

    CITY("city"),
    MOVIE("movie");

    private final String value;
}
