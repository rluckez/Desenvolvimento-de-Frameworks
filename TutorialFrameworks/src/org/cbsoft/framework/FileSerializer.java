package org.cbsoft.framework;

import java.io.FileOutputStream;

public class FileSerializer {

	private DataFormatter df;
	private PostProcessor pp;
	
	public FileSerializer(PostProcessor pp, DataFormatter df) {
		super();
		this.pp = pp;
		this.df = df;
	}

	public void generateFile(String filename, PropertiesGetter propGetter) {
		byte[] bytes = df.formatData(propGetter.getPropertiesList());
		
		try {
			bytes = pp.postProcess(bytes);	
			FileOutputStream fileout = new FileOutputStream(filename);
			fileout.write(bytes);
			fileout.close();
		} catch (Exception e) {
			throw new RuntimeException("Problems writing the file",e);
		}
		
	}
	
}