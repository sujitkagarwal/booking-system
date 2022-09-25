package com.assessment.theater.model.Search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class SearchCriteriaRequest {

    @NotNull
    private final String type;

    @NotNull
    private final String value;

}
