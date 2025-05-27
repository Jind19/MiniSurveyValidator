package com.surveyvalidator;

import java.lang.annotation.*;

/**
 * Tells Validator that a field must not be null
 */

@Retention(RetentionPolicy.RUNTIME) //it means @NotNull annotation is available at runtime.
@Target(ElementType.FIELD) // it means @NotNull annotation use is only limited to fields.
public @interface NotNull {

}
