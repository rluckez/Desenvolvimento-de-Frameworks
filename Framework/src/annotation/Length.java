package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import annotationimpl.LengthParser;
import net.sf.esfinge.metadata.annotation.validator.field.ValidFieldTypes;

/**
 * Validate a String length with min and/or max values
 * @author Rafael
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ValidatorImplementation(LengthParser.class)
@ValidFieldTypes(listValidTypes = {String.class})
public @interface Length {
	int min() default -1; 
    int max()     default -1; 
}
