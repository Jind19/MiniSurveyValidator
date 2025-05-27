package com.surveyvalidator;

public class Demo {

    public static void main(String[] args) {

        SurveyResponse r1 = new SurveyResponse("John", 25, "john@example.com", "Great survey!");
        SurveyResponse r2 = new SurveyResponse("Alex", 19, "invalidemail", "Very informative.");

        try {
            Validator.validate(r1);
            System.out.println("✅ r1 is valid");
        } catch (Exception e) {
            System.out.println("❌ r1 Error: " + e.getMessage());
        }

        try {
            Validator.validate(r2);
            System.out.println("✅ r2 is valid");
        } catch (Exception e) {
            System.out.println("❌ r2 Error: " + e.getMessage());
        }
    }
}
