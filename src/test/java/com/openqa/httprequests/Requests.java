package com.openqa.httprequests;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.commons.io.output.WriterOutputStream;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.io.StringWriter;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

/***
 * This class will contain all methods that could be used for any
 * CRUD(POST, PUT, GET, DELETE) operations
 */
@Component
public class Requests {

    public StringWriter requestWriter;

    private PrintStream getRequestLogger() {
        requestWriter = new StringWriter();
        return new PrintStream(new WriterOutputStream(requestWriter), true);
    }

    /***
     * method to retrieve an existing resource using GET method
     * @param endPoint - api endpoint url
     * @return
     */
    public Response getRequest(String endPoint) {
        return given()
                .urlEncodingEnabled(true)
                .filter(new RequestLoggingFilter(getRequestLogger()))
                .get(endPoint);
    }


    /***
     * method to retrieve an existing resource with parameters using GET method
     * @param endPoint
     * @param params
     * @return
     */
    public Response getRequest(String endPoint, HashMap<String, String> params) {
        RestAssured.defaultParser = Parser.JSON;
        return RestAssured
                .given()
                .urlEncodingEnabled(true)
                .filter(new RequestLoggingFilter(getRequestLogger()))
                .params(params)
                .get(endPoint);
    }
}
