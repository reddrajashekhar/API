package com.openqa.providers;

import com.openqa.dto.searchDetails.SearchResponse;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public class SearchDetails {

    private SearchResponse searchResponse;

    public void setSearchResponse(Response response){
        this.searchResponse = response.getBody().as(SearchResponse.class);
    }

    public String getArtistName(){
        return searchResponse.getResults().get(0).getArtistName();
    }

    public String getCountry(){
        return searchResponse.getResults().get(0).getCountry();
    }

    public Integer getArtistID(){
        return searchResponse.getResults().get(0).getArtistId();
    }

    public Integer getAMGArtistID(){
        return searchResponse.getResults().get(0).getAmgArtistId();
    }

    public String getKind(){
        return searchResponse.getResults().get(0).getKind();
    }
}
