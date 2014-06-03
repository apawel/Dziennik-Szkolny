package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.itextpdf.text.pdf.codec.Base64.InputStream;
import com.parse.Parse;








public class PushNotification {

	private static final String APPLICATION_ID = "0OzZHchfwt0mPcV5S9W2SeDk7GvI5Hcar717dcme";
	private static final String REST_API_KEY = "BAYO556QCsqPi15Xt3eOwNdfPQW1fnpeqID6CKgm";
	private static final String PUSH_URL = "https://api.parse.com/1/push";
	private static final String username = "apawel1w@gmail.com";
	private static final String password = "wiselka1";
	protected static final String common = null;

	public static void main(String[] args) {
		
		String[] channels = new String[] { "testdd" };
		String type = "android";
		Map<String, String> data = new HashMap<String, String>();
		data.put("alert", "push data test");

		try {
			new PushNotification().sendPost(channels, type, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void sendPost(String[] channels, String type,
			Map<String, String> data) throws Exception {
		JSONObject jo = new JSONObject();
		jo.put("channels", channels);
		if (type != null) {

			jo.put("type", type);
		}
		jo.put("data", data);

		this.pushData(jo.toString());
	}

	private void pushData(String postData) throws Exception {
		
		@SuppressWarnings({ "deprecation", "resource" })
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
