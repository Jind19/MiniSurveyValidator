package com.surveyvalidator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    @Test
    void validResponseShouldPass() {
        SurveyResponse res = new SurveyResponse("Alice", 20, "alice@example.com", "Awesome!");
        assertDoesNotThrow(() -> Validator.validate(res));
    }


    @Test
    void nullNameShouldFail() {
        SurveyResponse res = new SurveyResponse(null, 20, "x@example.com", "Nice.");
        Exception e = assertThrows(IllegalArgumentException.class, () -> Validator.validate(res));
        assertTrue(e.getMessage().contains("name"));
    }

    @Test
    void badEmailShouldFail() {
        SurveyResponse res = new SurveyResponse("Bob", 22, "bob.com", "Cool.");
        Exception e = assertThrows(IllegalArgumentException.class, () -> Validator.validate(res));
        assertTrue(e.getMessage().contains("email"));
    }

    @Test
    void shortAgeShouldFail() {
        SurveyResponse res = new SurveyResponse("Cara", 17, "cara@example.com", "Ok");
        Exception e = assertThrows(IllegalArgumentException.class, () -> Validator.validate(res));
        assertTrue(e.getMessage().contains("age"));
    }
}
