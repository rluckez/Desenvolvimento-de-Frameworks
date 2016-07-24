package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import annotationimpl.IntRangeParser;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ValidatorImplementation(IntRangeParser.class)
public @interface IntRange {
	int min() default Integer.MIN_VALUE; 
    int max()     default Integer.MAX_VALUE; 
}
