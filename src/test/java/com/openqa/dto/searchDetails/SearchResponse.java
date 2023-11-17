package com.openqa.dto.searchDetails;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchResponse {
    @JsonProperty("resultCount")
    private Integer resultCount;
    @JsonProperty("results")
    private List<Result> results;
}
