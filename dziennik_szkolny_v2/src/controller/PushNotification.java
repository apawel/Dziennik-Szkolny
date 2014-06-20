package controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.dao.DataAccessResourceFailureException;
public class PushNotification {

	private static final String APPLICATION_ID = "KxbAkP9fVFoQVX965kF5ly97pIDc9RsSy7ft32JO";
	private static final String REST_API_KEY = "bhvqrOnEm2Anamr1sKZNxmu0rJQ49OkoTg0vYh3G";
	private static final String PUSH_URL = "https://api.parse.com/1/push";  
	private static final String OBJECT_URL = "https://api.parse.com/1/classes/Zebranie";  

	public static void main(String[] args) {
	    String[] channels = new String[]{"Zebrania"};
	    String type = "android";
	    Map<String, String> data = new HashMap<String, String>();
	    data.put("alert", "Zapraszam na ZEBRANIE");

	    try {
	        new PushNotification().sendPost(channels, type, data);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	/**
	 * '{"score":1337,"playerName":"Sean Plott","cheatMode":false}' \
	 * @param channels
	 * @param type
	 * @param data
	 * @throws Exception
	 */
	public void sendObject( String host,String date) throws Exception {
	    JSONObject jo = new JSONObject();
	  
	    
	    jo.put("completed", false);
	   
	    jo.put ("date", date);
	    jo.put("description", host);  
	   
	   

	    this.pushObject(jo.toString());
	}
	private void pushObject(String postData) throws Exception {
	    DefaultHttpClient httpclient = new DefaultHttpClient();
	    HttpResponse response = null;
	    HttpEntity entity = null;
	    String responseString = null;
	    HttpPost httpost = new HttpPost(OBJECT_URL); 
	    httpost.addHeader("X-Parse-Application-Id", APPLICATION_ID);
	    httpost.addHeader("X-Parse-REST-API-Key", REST_API_KEY);
	    httpost.addHeader("Content-Type", "application/json");
	    StringEntity reqEntity = new StringEntity(postData);
	    httpost.setEntity(reqEntity);
	    response = httpclient.execute(httpost);
	    entity = response.getEntity();
	    if (entity != null) {
	         responseString = EntityUtils.toString(response.getEntity());  
	    }

	    System.out.println(responseString);
	}

	public void sendPost(String[] channels, String type, Map<String, String> data) throws Exception {
	    JSONObject jo = new JSONObject();
	    jo.put("channels", channels);
	    if(type != null) {
	      //llllll
	        jo.put("type", type);
	    }
	    jo.put("data", data);

	    this.pushData(jo.toString());
	}

	private void pushData(String postData) throws Exception {
	    DefaultHttpClient httpclient = new DefaultHttpClient();
	    HttpResponse response = null;
	    HttpEntity entity = null;
	    String responseString = null;
	    HttpPost httpost = new HttpPost(PUSH_URL); 
	    httpost.addHeader("X-Parse-Application-Id", APPLICATION_ID);
	    httpost.addHeader("X-Parse-REST-API-Key", REST_API_KEY);
	    httpost.addHeader("Content-Type", "application/json");
	    StringEntity reqEntity = new StringEntity(postData);
	    httpost.setEntity(reqEntity);
	    response = httpclient.execute(httpost);
	    entity = response.getEntity();
	    if (entity != null) {
	         responseString = EntityUtils.toString(response.getEntity());  
	    }

	    System.out.println(responseString);
	}
	
}
