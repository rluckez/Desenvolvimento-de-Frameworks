package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Calendar;
import java.util.Date;

import annotationimpl.PeriodFromCurrentTimeParser;
import net.sf.esfinge.metadata.annotation.validator.field.ValidFieldTypes;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ValidatorImplementation(PeriodFromCurrentTimeParser.class)
@ValidFieldTypes(listValidTypes = {Date.class, Calendar.class})
public @interface PeriodFromCurrentTime {
	int numberOfDays() default 0;	 
}
