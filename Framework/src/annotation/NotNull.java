package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import annotationimpl.NotNullParser;

/**
 * Check null attributes values
 * @author Rafael
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ValidatorImplementation(NotNullParser.class)
public @interface NotNull {

}
