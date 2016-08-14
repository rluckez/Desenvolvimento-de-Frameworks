package org.cbsoft.framework;

import java.io.IOException;

public class NullPostProcessor implements PostProcessor {

	@Override
	public byte[] postProcess(byte[] bytes) throws IOException {
		return bytes;
	}

}
