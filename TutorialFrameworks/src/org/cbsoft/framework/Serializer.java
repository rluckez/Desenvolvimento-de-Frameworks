package org.cbsoft.framework;

public interface Serializer {

	public abstract void generateFile(String filename, Object obj);

	public abstract void setPostProcessor(PostProcessor pp);

	public abstract PostProcessor getPostProcessor();

}