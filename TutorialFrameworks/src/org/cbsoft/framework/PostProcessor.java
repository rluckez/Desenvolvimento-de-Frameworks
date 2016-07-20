package org.cbsoft.framework;

import java.io.IOException;

public interface PostProcessor {

	byte[] postProcess(byte[] bytes) throws IOException;
	
}
