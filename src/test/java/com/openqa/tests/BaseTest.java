package com.openqa.tests;

import com.openqa.config.Config;
import com.openqa.steps.LookUpSteps;
import com.openqa.steps.SearchSteps;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = Config.class)
@ExtendWith(SpringExtension.class)
@TestPropertySource({"classpath:endpoints.properties"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseTest {
    @Autowired protected SearchSteps searchSteps;
    @Autowired protected LookUpSteps lookUpSteps;
}
