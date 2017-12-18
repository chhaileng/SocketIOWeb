package info.chhaileng.app.service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
//import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	public void push(String message) {
		try {
			URL url = new URL("https://onesignal.com/api/v1/notifications");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setDoInput(true);

			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Authorization", "Basic NWUyM2YzYTAtMGE5OS00OTMwLTgxMDgtZDRmNDZiNzlhN2Vm");
			con.setRequestMethod("POST");

			String strJsonBody = "{" + "\"app_id\": \"1c8142b9-6045-4c80-873c-a35057564d97\","
					+ "\"included_segments\": [\"All\"]," + "\"contents\": {\"en\": \"" + message + "\"}" + "}";

			byte[] sendBytes = strJsonBody.getBytes("UTF-8");
			con.setFixedLengthStreamingMode(sendBytes.length);

			OutputStream outputStream = con.getOutputStream();
			outputStream.write(sendBytes);

			int httpResponse = con.getResponseCode();
			System.out.println("httpResponse: " + httpResponse);

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
