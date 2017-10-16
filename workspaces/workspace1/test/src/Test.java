import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Test{
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("https://api.shop.com:8443/AffiliatePublisherNetwork/v1/products");
        urlBuilder.append("?");
        urlBuilder.append(URLEncoder.encode("publisherID","UTF-8") + "=" + URLEncoder.encode("TEST", "UTF-8") + "&");
        urlBuilder.append(URLEncoder.encode("locale","UTF-8") + "=" + URLEncoder.encode("en_US", "UTF-8") + "&");
        urlBuilder.append(URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("15", "UTF-8") + "&");
        urlBuilder.append(URLEncoder.encode("term","UTF-8") + "=" + URLEncoder.encode("pear", "UTF-8") + "&");
        urlBuilder.append(URLEncoder.encode("apikey","UTF-8") + "=" + URLEncoder.encode("l7xx804da2d946ca445381c8eded9819ceb1", "UTF-8"));
        URL url = new URL(urlBuilder.toString());
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