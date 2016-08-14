package org.cbsoft.framework;

public class Main {
	
	public static void main(String[] args){
		Product p = new Product("notebook", "HP", 1999.99, "2348203894032948");
		p.setSecretCode("não deve aparecer");
		
		SerializerBuilder builder = new SerializerBuilder();
		//Exemplo utilizando o builder com interface fluente
		Serializer cxs = builder.createPropertiesSerializer().withEncription(1).withLogging().build();
		
		//Código não utilizando o builder
//		Serializer cxs = new SerializerLogger(new FileSerializer(new Crypto(1), new PropertiesFormatter()));
		cxs.generateFile("product.txt", p);		
		
	}

}
