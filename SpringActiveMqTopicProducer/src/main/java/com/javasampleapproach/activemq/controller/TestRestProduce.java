package com.javasampleapproach.activemq.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestRestProduce {
	
	public static void main(String[] args) {
		try {
			POSTRequest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void POSTRequest() throws IOException {
	    String POST_PARAMS = "{\n" + "\"userId\": 101,\r\n" +
	        "    \"id\": 101,\r\n" +
	        "    \"title\": \"Test Title\",\r\n" +
	        "    \"body\": \"Test Body\"" + "\n}";

	    POST_PARAMS = "{\n" + "\"id\": 101,\r\n" +
		        "    \"name\": \"Mahan\"" + "\n}";

	    System.out.println(POST_PARAMS);
	    
	    // URL obj = new URL("https://jsonplaceholder.typicode.com/posts");
	    URL obj = new URL("http://localhost:8090/api/task");
	    
	    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	    postConnection.setRequestMethod("POST");
	    postConnection.setRequestProperty("Content-Type", "application/json");
	    postConnection.setDoOutput(true);
	    OutputStream os = postConnection.getOutputStream();
	    os.write(POST_PARAMS.getBytes());
	    os.flush();
	    os.close();
	    int responseCode = postConnection.getResponseCode();
	    System.out.println("POST Response Code :  " + responseCode);
	    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
	    
	    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	            postConnection.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in .readLine()) != null) {
	            response.append(inputLine);
	        } in .close();
	        // print result
	        System.out.println(response.toString());
	    } else {
	        System.out.println("POST NOT WORKED");
	    }
	}
}
