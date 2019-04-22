package com.domain.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.domain.demo.configuration.Config;

@Service("alfrescoService")
public class AlfrescoService {

	String alfrescoUrl;

	@Autowired
	private Config configService;

	@Autowired
	public AlfrescoService(@Value("${alfresco.url}") String alfrescoUrl) {
		this.alfrescoUrl = alfrescoUrl;
	}

	public static void main(String[] args) {
		AlfrescoService alf = new AlfrescoService("http://localhost:8080/alfresco");
		alf.settingHttpCient();
	}
	
	public void settingHttpCient() {
		try {
			URL url = new URL("http://localhost:8080/alfresco/s/api/login.json?u=admin&pw=admin");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
//			Authenticator.setDefault(new Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(configService.ADMIN_USER,
//							configService.ADMIN_PASSWORD.toCharArray());
//				}
//			});

			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				System.out.println("Output from Server .... \n");
				String output;

				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
			} else {
				System.err.println("Failed : HTTP error code : " + conn.getResponseCode());
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
