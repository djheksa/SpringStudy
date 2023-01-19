package com.my.study.controller;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
public class NaberAitemsTest {
	public static void main(String[] args) {
		String accessKey="3B2E92563ABDBD935C5D";
		String secretKey="C01B1002A1789BC457BFBA027F8D146104784249";
		String method="GET";
		String timestamp=Long.toString(System.currentTimeMillis());
		String apiUrl="https://aitems.apigw.ntruss.com/api/v1/services/vqs9ovhlgrz/infers/lookup?type=personalRecommend&targetId=1";
		
		//personalRecommend, relatedItem, pop
		try {
			URL url= new URL(apiUrl);
			//System.out.println("-----"+makeSignature(apiUrl,timestamp,method,accessKey,secretKey));
			URLConnection urlCon=url.openConnection();
			HttpURLConnection con=(HttpURLConnection)urlCon;
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestProperty("content-type", "application/json");
			con.setRequestProperty("x-ncp-apigw-timestamp", timestamp);
			con.setRequestProperty("x-ncp-iam-access-key",accessKey);
			con.setRequestProperty("x-ncp-apigw-signature-v2",makeSignature(timestamp,method,accessKey,secretKey));
			con.setRequestMethod(method);
			con.setDoOutput(true);
			int resCode=con.getResponseCode();
			System.out.println("resCode: "+resCode);
			System.out.println(timestamp);
		}catch(Exception e) {
			e.printStackTrace();
		}//try----
	}
		
	public static String makeSignature( String timestamp, String method, String accessKey, String secretKey)
			throws NoSuchAlgorithmException,InvalidKeyException{
			String space=" ";
			String newLine="\n";
			String url ="/api/v1/services/vqs9ovhlgrz/infers/lookup?type=personalRecommend&targetId=1";		
			String message= new StringBuilder()
					.append(method)
					.append(space)
					.append(url)
					.append(newLine)
					.append(timestamp)
					.append(newLine)
					.append(accessKey)
					.toString();
			SecretKeySpec signingKey;
			String encodeBase64String;
				try {
					signingKey=new SecretKeySpec(secretKey.getBytes("UTF-8"),"HmacSHA256");
					Mac mac=Mac.getInstance("HmacSHA256");
					mac.init(signingKey);
					byte[] rawHmac=mac.doFinal(message.getBytes("UTF-8"));
					encodeBase64String=Base64.getEncoder().encodeToString(rawHmac);
				}catch(UnsupportedEncodingException e) {
					encodeBase64String =e.toString();
				}
				System.out.println(encodeBase64String);
			return encodeBase64String;
		}
}
