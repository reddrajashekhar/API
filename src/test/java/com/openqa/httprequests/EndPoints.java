package com.openqa.httprequests;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class EndPoints {

    @Value("${baseURISearch}")
    private String baseURISearch;

    @Value("${baseURILookUp}")
    private String baseURILookUp;

    public Supplier<String> searchEndpoint = () -> baseURISearch;
    public Supplier<String> lookUpEndpoint = () -> baseURILookUp;
}
