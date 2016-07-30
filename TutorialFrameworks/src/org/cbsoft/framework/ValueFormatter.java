package org.cbsoft.framework;

import java.lang.annotation.Annotation;

public interface ValueFormatter {

	public Object formatValue(Object value);
	
	public void readAnnotation(Annotation an);
	
}
