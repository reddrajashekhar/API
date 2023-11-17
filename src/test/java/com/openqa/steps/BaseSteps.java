package com.openqa.steps;

import com.openqa.enums.AttachmentName;
import com.openqa.enums.StatusCode;
import com.openqa.httprequests.EndPoints;
import com.openqa.httprequests.Requests;
import com.openqa.providers.SearchDetails;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseSteps {

    @Autowired protected Requests requests;
    @Autowired EndPoints endPoints;
    @Autowired protected SearchDetails searchDetails;
    protected Response response;

    /***
     * validates the api response status code with expected status code
     * attach the api response in the allure report
     * @param expectedStatusCode
     * @param attachmentName
     * @param response
     */
    public void validateAndAttachResponse(StatusCode expectedStatusCode, AttachmentName attachmentName, Response response){
        System.out.println(response.asString());
        Allure.addAttachment(attachmentName.getAttachmentName() + "Request",  requests.requestWriter.toString());
        Allure.addAttachment(attachmentName.getAttachmentName() + "Response", "Status code: " + response.statusCode()
                + System.lineSeparator() + "Response:" + System.lineSeparator() + response.asString());
        Assertions.assertEquals(expectedStatusCode.getStatusCode(), response.getStatusCode(), "Status code not matched");
    }
}
