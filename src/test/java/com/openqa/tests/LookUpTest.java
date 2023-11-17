package com.openqa.tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Feature("Flight operation com.openqa.tests")
public class LookUpTest extends BaseTest {

    @Test
    @DisplayName("verify user is able to lookup by artist id")
    public void searchArtistByIdTest() {
        lookUpSteps
                .whenISearchForArtistByID("284910350")
                .thenIVerifyArtistID("284910350");
    }

    @Test
    @DisplayName("verify user is able to lookup by amg artist id")
    public void searchByAMGArtistIDTest() {
        lookUpSteps
                .whenISearchForAMGArtistByID("468749")
                .thenIVerifyAMGArtistID("468749");
    }
}
