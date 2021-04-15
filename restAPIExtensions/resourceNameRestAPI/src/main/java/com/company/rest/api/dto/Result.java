package com.company.rest.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDate;

@JsonDeserialize(builder = Result.ResultBuilder.class)
public class Result {
    private final String sortBy;
    private final String sortType;
    private final String myParameterKey;
    @JsonIgnore
    private final LocalDate currentDate = LocalDate.now();
    
    public Result(String myParameterKey, String sortBy, String sortType) {
        this.myParameterKey = myParameterKey;
        this.sortBy = sortBy;
        this.sortType = sortType;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getSortType() {
        return sortType;
    }

    public String getMyParameterKey() {
        return myParameterKey;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class ResultBuilder {
        private String sortBy;
        private String sortType;
        private String myParameterKey;

        public ResultBuilder sortBy(String sortBy) {
            this.sortBy =  sortBy;
            return this;
        }

        public ResultBuilder sortType(String sortType) {
            this.sortType =  sortType;
            return this;
        }

        public ResultBuilder myParameterKey(String myParameterKey) {
            this.myParameterKey =  myParameterKey;
            return this;
        }

        public Result build() {
            return new Result(myParameterKey, sortBy, sortType);
        }
    }

    public static ResultBuilder builder() {
        return new ResultBuilder();
    }
}

