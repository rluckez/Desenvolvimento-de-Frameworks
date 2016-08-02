package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import annotationimpl.RegexParser;

/**
 * Validate if a String matches a pattern
 * @author Rafael
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ValidatorImplementation(RegexParser.class)
public @interface Regex {
	String regex() default ""; 
}
