package com.surveyvalidator;

public class SurveyResponse {

    @NotNull
    @Length(min = 3, max = 50)
    private String name;

    @Min(18)
    private int age;

    @NotNull
    @EMail
    private String email;

    @Length(max = 200)
    private String feedback;

    public SurveyResponse(String name, int age, String email, String feedback) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "SurveyResponse{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
