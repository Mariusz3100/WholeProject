
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class AditivesExplorer {
	//    public static void main(String[] args) throws IOException, UnirestException {
	//    	HttpResponse<JsonNode> response = Unirest.get("https://vx-e-additives.p.mashape.com/additives?locale=en&order=asc&sort=last_update")
	//    			.header("X-Mashape-Key", "SHWeoqo0lVmsh0DQHaZKihvAQKcqp1YjzW5jsnERLyJGNyGGWr")
	//    			.header("Accept", "application/json")
	//    			.asJson();
	//    	
	//    	System.out.println(response.getBody());
	//    	
	//    }

	public static void main(String[] args) throws IOException, UnirestException {
		URL url = new URL("https://vx-e-additives.p.mashape.com/additives?locale=en&order=asc&sort=last_update");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
	}
}