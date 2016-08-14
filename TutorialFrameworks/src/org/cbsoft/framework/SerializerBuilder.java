package org.cbsoft.framework;

public class SerializerBuilder {
	
	private Serializer serializer;
	
	public SerializerBuilder createXMLSerializer(){
		serializer = new FileSerializer(new NullPostProcessor(), new XMLFormatter());
		return this;
	}
	
	public SerializerBuilder createPropertiesSerializer(){
		serializer = new FileSerializer(new NullPostProcessor(), new PropertiesFormatter());
		return this;
	}
	
	public SerializerBuilder withEncription(int number){
		PostProcessor pp = new Crypto(number);
		addPostProcessor(pp);
		return this;
	}
	
	public SerializerBuilder withCompression(){
		PostProcessor pp = new Compressor();
		addPostProcessor(pp);
		return this;
	}
	
	private void addPostProcessor(PostProcessor pp){
		PostProcessor current = serializer.getPostProcessor();
		if(current instanceof NullPostProcessor){
			serializer.setPostProcessor(pp);
		}else{
			CompositePostProcessor composite = new CompositePostProcessor(current, pp);
			serializer.setPostProcessor(composite);
		}
	}
	
	public SerializerBuilder withLogging(){
		serializer = new SerializerLogger(serializer);
		return this;
	}
	
	public Serializer build(){
		return serializer;
	}

}
