package general.problems;

import general.problems.TrafficFinder.Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DistanceMatrixApiCaller {
	private static final String BASE_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?";

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
        InputStream in = null;
        final StringBuilder sb = new StringBuilder();

        try {
            HttpGet httpGet = new HttpGet();
            String url = BASE_URL + "origins=" + "51.499377,-0.154993" + "&" + "destinations=" + "51.500216,-0.153652";
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("origins",
                "51.499377,-0.154993"));
            nameValuePairs.add(new BasicNameValuePair("destinations",
                    "51.500216,-0.153652"));
            //httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            httpGet.setURI(new URI(url));

            HttpResponse response = client.execute(httpGet);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
              //System.out.println(line);
              sb.append(line);
            }
            System.out.println(sb.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
			final JSONObject object = new JSONObject(sb.toString());
			System.out.println("------");
			System.out.println(object.get("destination_addresses"));
			parseApiResponse(sb.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	
	public String getTimeDistanceValue(Location origin, Location destination) {
		HttpClient client = new DefaultHttpClient();
        InputStream in = null;
        final StringBuilder sb = new StringBuilder();

        try {
            HttpGet httpGet = new HttpGet();
            String url = BASE_URL + "origins=" + origin.toString() + "&" + "destinations=" + destination.toString();
            /*List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("origins",
                "51.499377,-0.154993"));
            nameValuePairs.add(new BasicNameValuePair("destinations",
                    "51.500216,-0.153652"));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));*/
            httpGet.setURI(new URI(url));

            HttpResponse response = client.execute(httpGet);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            
            while ((line = rd.readLine()) != null) {
              //System.out.println(line);
              sb.append(line);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	public static String parseApiResponse(String response) {
		try {
			final JSONObject object = new JSONObject(response);
			final JSONObject location = object.getJSONArray("rows").getJSONObject(0);
			final JSONArray arrays = location.getJSONArray("elements");
			
			int index = 0;
			JSONObject result;
			while (index < arrays.length()) {
				result = arrays.getJSONObject(index++);
				System.out.println(result.getJSONObject("distance").get("value"));
				System.out.println(result.getJSONObject("duration").get("value"));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;

	}
		

}

