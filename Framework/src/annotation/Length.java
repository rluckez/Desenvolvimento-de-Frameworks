package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import annotationimpl.LengthParser;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ValidatorImplementation(LengthParser.class)
public @interface Length {
	int min() default -1; 
    int max()     default -1; 
}
