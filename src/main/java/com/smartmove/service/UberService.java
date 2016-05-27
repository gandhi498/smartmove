/**
 * 
 */
package com.smartmove.service;

import java.io.IOException;
import java.text.MessageFormat;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;


/**
 * @author TCS
 *
 */
@Service
public class UberService {
	
    private static String LINK_UBER = "https://www.uber.com/fares/latLngEstimate?start_latitude={0}&start_longitude={1}&end_latitude={2}&end_longitude={3}&vids[]=1270&vids[]=64&vids[]=343";	

	/**
	 * 
	 * @return String 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String getFare() throws ClientProtocolException, IOException {
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("https://www.uber.com/fares/latLngEstimate?start_latitude=52.3028381&start_longitude=4.856512299999963&end_latitude=52.3105386&end_longitude=4.768274399999996&vids[]=1270&vids[]=64&vids[]=343");
		HttpResponse res = httpClient.execute(httpget);
		
		String responseString = new BasicResponseHandler().handleResponse(res);
		System.out.println("responseString" + responseString);
		
		return responseString;
	}
	
	/**
	 * 
	 * @param start_latitude
	 * @param start_longitude
	 * @param end_latitude
	 * @param end_longitude
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
    public String getFare(String start_latitude, String start_longitude, String end_latitude, String end_longitude) throws ClientProtocolException, IOException {
        HttpClient httpClient = new DefaultHttpClient();
        String args[] = new String[] {start_latitude, start_longitude, end_latitude, end_longitude};
        HttpGet httpget = new HttpGet(MessageFormat.format(LINK_UBER, args));
        HttpResponse res = httpClient.execute(httpget);
        String responseString = new BasicResponseHandler().handleResponse(res);
        System.out.println("responseString" + responseString);
        return responseString;
    }
}
