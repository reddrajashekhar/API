package com.openqa.steps;

import com.openqa.enums.AttachmentName;
import com.openqa.enums.StatusCode;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SearchSteps extends BaseSteps{

    @Step
    public SearchSteps whenISearchForTerm(String term){
        HashMap<String, String> searchParams = new HashMap<>();
        searchParams.put("term", term);
        search(searchParams);
        return this;
    }

    @Step
    public SearchSteps whenISearchForTermAndCountry(String name, String country){
        HashMap<String, String> searchParams = new HashMap<>();
        searchParams.put("term", name);
        searchParams.put("country", country);
        search(searchParams);
        return this;
    }

    @Step
    public SearchSteps whenISearchForTermAndEntity(String name, String entity){
        HashMap<String, String> searchParams = new HashMap<>();
        searchParams.put("term", name);
        searchParams.put("entity", entity);
        search(searchParams);
        return this;
    }

    @Step
    public SearchSteps whenISearchForTermCountryAndEntity(String name, String country, String entity){
        HashMap<String, String> searchParams = new HashMap<>();
        searchParams.put("term", name);
        searchParams.put("country", country);
        searchParams.put("entity", entity);
        search(searchParams);
        return this;
    }

    @Step
    public SearchSteps thenIVerifyArtistName(String artistName){
        Assert.assertTrue("Artist Name not matched"
                + "\n expected Name: " + artistName
                + "\n actual name: " + searchDetails.getArtistName(), searchDetails.getArtistName().contains(artistName));
        return this;
    }

    @Step
    public SearchSteps thenIVerifyCountry(String country){
        Assert.assertEquals("country Name not matched ", country, searchDetails.getCountry());
        return this;
    }

    @Step
    public SearchSteps thenIVerifyEntity(String entity){
        Assert.assertEquals("entity Name not matched", entity, searchDetails.getKind());
        return this;
    }

    private void search(HashMap<String, String> searchParams){
        response = requests.getRequest(endPoints.searchEndpoint.get(), searchParams);
        System.out.println(response.asString());
        validateAndAttachResponse(StatusCode.STATUS_OK, AttachmentName.SEARCH, response);
        searchDetails.setSearchResponse(response);
    }


}
