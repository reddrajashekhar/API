package com.openqa.tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Feature("Flight operation com.openqa.tests")
public class SearchTest extends BaseTest{

    @Test
    @DisplayName("verify user is able to search for term")
    public void searchTermTest() {
        searchSteps
                .whenISearchForTerm("jack johnson")
                .thenIVerifyArtistName("jack johnson");
    }

    @Test
    @DisplayName("verify user is able to search for term and country")
    public void searchTermAndCountryTest() {
        searchSteps
                .whenISearchForTermAndCountry("jim jones","ca")
                .thenIVerifyArtistName("jim jones")
                .thenIVerifyCountry("CAN");
    }

    @Test
    @DisplayName("verify user is able to search for term and entity")
    public void searchTermAndEntityTest() {
        searchSteps
                .whenISearchForTermAndEntity("jack johnson", "musicVideo")
                .thenIVerifyArtistName("jack johnson")
                .thenIVerifyEntity("music-video");
    }

    @Test
    @DisplayName("verify user is able to search for term, entity and country")
    public void searchTermEntityCountryTest() {
        searchSteps
                .whenISearchForTermCountryAndEntity("jack johnson", "ca", "musicVideo")
                .thenIVerifyArtistName("jack johnson")
                .thenIVerifyEntity("music-video")
                .thenIVerifyCountry("CAN");
    }
}
