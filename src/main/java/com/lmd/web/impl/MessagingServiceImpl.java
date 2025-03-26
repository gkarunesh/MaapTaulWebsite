/**
 * 
 */
package com.lmd.web.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.lmd.web.service.MessagingService;
import com.lmd.web.utilities.Http;
import com.lmd.web.utilities.MessagingModel;
import com.lmd.web.utilities.MyResponse;
import com.lmd.web.utilities.Params;
import com.lmd.web.utilities.Sms;

/**
 * @author karunesh
 *
 */
@Service
public class MessagingServiceImpl implements MessagingService {
	
	@Autowired
	RestTemplate restTemplate;

	private static final long serialVersionUID = 3912645955344074722L;

	@Override
	public MyResponse<?> sendText(MessagingModel data) throws Exception {
		// System.out.println(p.getParam1() + " >> " + p.getParam2());
		String encryptedPassword = MD5(data.getPassword());
		MyResponse<?> responseString = null;
		String requestUrl = data.getHost() + "username=" + URLEncoder.encode(data.getUserName(), "UTF-8") + "&password="
				+ URLEncoder.encode(encryptedPassword, "UTF-8") + "&smsservicetype="
				+ URLEncoder.encode(data.getServiceType(), "UTF-8") + "&content="
				+ URLEncoder.encode(data.getContent(), "UTF-8") + "&mobileno="
				+ URLEncoder.encode(String.valueOf(data.getMobileNo()), "UTF-8") + "&senderid=" + data.getSenderId();
		System.out.println(requestUrl);
		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
			HttpPost post = new HttpPost(requestUrl);
			HttpResponse response = client.execute(post);
			responseString = MyResponse.builder().statusCode(response.getStatusLine().getStatusCode())
					.status(response.getStatusLine().getReasonPhrase())
					.remarks(String.valueOf(response.getStatusLine())).build();
			// System.out.println(response.getStatusLine()+"\n"+response.getStatusLine().getStatusCode()+"\n"+response.getStatusLine().getReasonPhrase());
			/*
			 * try(BufferedReader bf=new BufferedReader(new
			 * InputStreamReader(response.getEntity().getContent()))){
			 * 
			 * }
			 */
		}
		return responseString;
	}

	@Override
	public MyResponse<?> sendText(Params p) throws Exception {
		String encryptedPassword = MD5(Sms.PASSWORD);
		String requestUrl = Sms.REQUEST_URL + "username=" + URLEncoder.encode(Sms.USER, "UTF-8") + "&password="
				+ URLEncoder.encode(encryptedPassword, "UTF-8") + "&smsservicetype="
				+ URLEncoder.encode(Sms.SERVICE_TYPE, "UTF-8") + "&content=" + URLEncoder.encode(p.getArg2(), "UTF-8")
				+ "&mobileno=" + URLEncoder.encode(String.valueOf(p.getArg1()), "UTF-8") + "&senderid=" + Sms.SENDER_ID;
		/*
		 * try(CloseableHttpClient client = HttpClientBuilder.create().build()) {
		 * HttpPost post=new HttpPost(requestUrl); HttpResponse
		 * response=client.execute(post); return MyResponse.builder()
		 * .statusCode(response.getStatusLine().getStatusCode())
		 * .status(response.getStatusLine().getReasonPhrase())
		 * .remarks(String.valueOf(response.getStatusLine())) .build(); }
		 */
		return MyResponse.builder().statusCode(Http.OK).status(Http.SUCCESS).build();
	}

	@Override
	public MyResponse<?> testSendText(Params p) throws Exception {
		String encryptedPassword = MD5(Sms.PASSWORD);
		String requestUrl = Sms.REQUEST_URL + "username=" + URLEncoder.encode(Sms.USER, "UTF-8") + "&password="
				+ URLEncoder.encode(encryptedPassword, "UTF-8") + "&smsservicetype="
				+ URLEncoder.encode(Sms.SERVICE_TYPE, "UTF-8") + "&content=" + URLEncoder.encode(p.getArg2(), "UTF-8")
				+ "&mobileno=" + URLEncoder.encode(String.valueOf(p.getArg1()), "UTF-8") + "&senderid=" + Sms.SENDER_ID;
		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
			HttpPost post = new HttpPost(requestUrl);
			HttpResponse response = client.execute(post);
			return MyResponse.builder().statusCode(response.getStatusLine().getStatusCode())
					.status(response.getStatusLine().getReasonPhrase())
					.remarks(String.valueOf(response.getStatusLine())).build();
		}
	}

	@Override
	public MyResponse<?> dbtText(Params p) throws Exception {

		String requestUrl = Sms.REQUEST_URL_DBT + "Passcode=" + Sms.PASSWORD_DBT + "&TemplateID=" + p.getArg2()
				+ "&OTPSMS=" + p.getArg3() + "&MobileNo=" + p.getArg1();

		MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
		postParameters.add("Passcode", Sms.PASSWORD_DBT);
		postParameters.add("TemplateID", p.getArg2());
		postParameters.add("OTPSMS", p.getArg3());
		postParameters.add("MobileNo", p.getArg1());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(postParameters, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(Sms.REQUEST_URL_DBT, requestEntity,
				String.class);
		return MyResponse.builder().statusCode(response.getStatusCodeValue()).status(response.getBody()).build();
	}
	
	@Override
	public String sendEmail(MessagingModel mModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	private static String MD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-1");
		byte[] md5 = new byte[64];
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		md5 = md.digest();
		return convertedToHex(md5);
	}

	private static String convertedToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfOfByte = (data[i] >>> 4) & 0x0F;
			int twoHalfBytes = 0;
			do {
				if ((0 <= halfOfByte) && (halfOfByte <= 9)) {
					buf.append((char) ('0' + halfOfByte));
				} else {
					buf.append((char) ('a' + (halfOfByte - 10)));
				}
				halfOfByte = data[i] & 0x0F;
			} while (twoHalfBytes++ < 1);
		}
		return buf.toString();
	}

	

}
