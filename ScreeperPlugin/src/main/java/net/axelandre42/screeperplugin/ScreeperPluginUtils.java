package net.axelandre42.screeperplugin;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ScreeperPluginUtils {
	public static int httpPostRequest(URL url) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		// Configuring request.
		connection.setRequestMethod("GET");
		
		
		connection.setUseCaches(false);
		connection.setDoInput(true);
		connection.setDoOutput(true);
		
		int code = connection.getResponseCode();
		return code;
	}
}
