package com.domain.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class Config {

	@Value("${alfresco.url}")
	public String ALFRESCO_URL;
	
	@Value("${admin.user}")
	public String ADMIN_USER;

	@Value("${admin.password}")
	public String ADMIN_PASSWORD;
	
	@Value("${preview.download.url}")
	public String PREVIEW_DOWNLOAD_URL;
	
}
