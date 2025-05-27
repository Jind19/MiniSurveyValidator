package com.surveyvalidator;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Length {

    int min() default 0;  //minimum value which user can provide while using @Min
    int max() default Integer.MAX_VALUE;  //maximum value which user can provide while using @Min
}
