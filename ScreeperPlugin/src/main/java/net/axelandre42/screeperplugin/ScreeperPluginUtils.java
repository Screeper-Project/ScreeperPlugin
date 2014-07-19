package net.axelandre42.screeperplugin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ScreeperPluginUtils {
	/**
	 * 
	 * @param url : The URL to post data.
	 * @param postData : The data to post.
	 * @return The response returned by the URL.
	 * @throws IOException
	 */
	public static int httpPostRequest(URL url, String postData) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		// Configuring request.
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Content-Length", Integer.toString(postData.getBytes().length));
		connection.setRequestProperty("Content-Language", "en-US");
		
		connection.setUseCaches(false);
		connection.setDoInput(true);
		connection.setDoOutput(true);
		
		// Making request.
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		out.writeBytes(postData);
		out.flush();
		out.close();
		
		//Getting response code.
		int code = connection.getResponseCode();
		
		return code;
	}
	/**
	 * 
	 * @param data : data to encode.
	 * @return the data encoded to URL.
	 */
	public static String encodeToURL(String... data) {
		StringBuffer encData = new StringBuffer();
		for (String s : data) {
			try {
				encData.append(URLEncoder.encode(s, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			encData.append("&");
		}
		encData.deleteCharAt(encData.length());
		return encData.toString();
	}
}
