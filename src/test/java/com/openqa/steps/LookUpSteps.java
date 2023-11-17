package com.openqa.steps;

import com.openqa.enums.AttachmentName;
import com.openqa.enums.StatusCode;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class LookUpSteps extends BaseSteps{

    @Step
    public LookUpSteps whenISearchForArtistByID(String id){
        HashMap<String, String> searchParams = new HashMap<>();
        searchParams.put("id", id);
        lookUp(searchParams);
        return this;
    }

    @Step
    public LookUpSteps whenISearchForAMGArtistByID(String id){
        HashMap<String, String> searchParams = new HashMap<>();
        searchParams.put("amgArtistId", id);
        lookUp(searchParams);
        return this;
    }

    private void lookUp(HashMap<String, String> lookUpParams){
        response = requests.getRequest(endPoints.lookUpEndpoint.get(), lookUpParams);
        System.out.println(response.asString());
        validateAndAttachResponse(StatusCode.STATUS_OK, AttachmentName.LOOKUP, response);
        searchDetails.setSearchResponse(response);
    }

    @Step
    public LookUpSteps thenIVerifyArtistName(String artistName){
        Assert.assertTrue("Artist Name not matched"
                + "\n expected Name: " + artistName
                + "\n actual name: " + searchDetails.getArtistName(), searchDetails.getArtistName().contains(artistName));
        return this;
    }

    @Step
    public LookUpSteps thenIVerifyArtistID(String artistID){
        Assert.assertEquals("Artist ID not matched" + "\n expected id: " + artistID + "\n actual id: "
                + searchDetails.getArtistID(), artistID, String.valueOf(searchDetails.getArtistID()));
        return this;
    }

    @Step
    public LookUpSteps thenIVerifyAMGArtistID(String amgArtistID){
        Assert.assertEquals("AMG Artist ID not matched" + "\n expected id: " + amgArtistID + "\n actual id: "
                        + searchDetails.getAMGArtistID(), amgArtistID, String.valueOf(searchDetails.getAMGArtistID()));
        return this;
    }
}
