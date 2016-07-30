package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import annotationimpl.CheckDaysParser;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ValidatorImplementation(CheckDaysParser.class)
public @interface CheckDays {
	int numberOfDays() default 0;	 
}
