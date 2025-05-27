package com.surveyvalidator;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class Validator {

    public static void validate(Object obj) throws IllegalAccessException {

        Class<?> clazz = obj.getClass(); //Get the class of the object

        //Loop over all the fields in the class
        for(Field field : clazz.getDeclaredFields()){

            field.setAccessible(true);  //Allow access to private fields

            Object value = field.get(obj);  //Grab the actual value of that field from the object passed in

            //Checking for annotations

            //1. @NotNull annotation

            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                throw new IllegalArgumentException("Field '" + field.getName() + "' must not be null.");
            }

            //2. @Min annotation

            if(field.isAnnotationPresent(Min.class)){
                int min = field.getAnnotation(Min.class).value();
                if( (Integer) value < min) {
                    throw new IllegalArgumentException(
                            "Field '" + field.getName() + "' must be at least " + min
                    );
                }
            }

            //3. @Length annotation

            if(field.isAnnotationPresent(Length.class) && value instanceof String ){
                Length len = field.getAnnotation(Length.class);

                String str = (String) value;
                if(str.length() < len.min() || str.length() > len.max()){
                    throw new IllegalAccessException(
                            "Field '"+field.getName()+"' must have length between "+ len.min()+" and " + len.max()
                    );
                }

            }

            //4. @EMail annotation

            if(field.isAnnotationPresent(EMail.class) && value instanceof String ){
                String email = (String) value;
                String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
                if(!Pattern.matches(regex, email)) {
                    throw new IllegalArgumentException("Field '" + field.getName() + "' must be a valid email.");
                }

            }


        }


    }
}
