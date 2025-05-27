package com.surveyvalidator;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Min {

    int value();  //minimum value allowed which user must provide while using @Min
}
