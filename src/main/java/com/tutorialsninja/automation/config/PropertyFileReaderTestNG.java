package com.tutorialsninja.automation.config;

import com.tutorialsninja.automation.util.PathHelper;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.io.IOException;
import java.util.Properties;


public class PropertyFileReaderTestNG implements ConfigurationReader{


	public static ThreadLocal<Properties> propertiesThreadLocal=new ThreadLocal<>();

	Properties properties=null;

	public PropertyFileReaderTestNG() {
		properties=new Properties();
		try {
			properties.load(PathHelper.getInputStreamResourcePath("/src/main/resources/ConfigurationFile/config.properties"));
			propertiesThreadLocal.set(properties);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return properties.getProperty("url");
	}

	public String getBrowser() {
		return properties.getProperty("browser");
	}
	public int getPageLoadTimeOut() {
		return Integer.parseInt(properties.getProperty("PageLoadTimeOut"));
	}



}
