package com.androidapp.restaurantguide;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
//import com.androidapp.restaurantguide.JSONParser;
//import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemClickListener;

public class RestaurantGuideActivity extends Activity {

	/** Called when the activity is first created. */
	private static final String TAG_ID = "hotel_id";
	private static final String TAG_NAME = "hotel_name";
	private static final String TAG_ADDRESS = "hotel_address";
	private static final String TAG_PHONE = "hotel_phone";
	private static final String TAG_OPTIME = "hotel_opening_time";
	private static final String TAG_LATITUDE = "latitude";
	private static final String TAG_LONGITUDE = "longitude";

	static InputStream is = null;
	public static final String URI = "http://10.0.2.2/restaurantGuide.php"; // I
																			// use
																			// my
																			// real
																			// IP
																			// address

	String phone1 = null, phone2 = null, phone3 = null, phone4 = null,
			phone5 = null;
	String optime1 = null, optime2 = null, optime3 = null, optime4 = null,
			optime5 = null;
	String h_id1 = null, h_id2 = "", h_id3 = "", h_id4 = "", h_id5 = "";
	double lat_d1, lon_d1, lat_d2, lon_d2, lat_d3, lon_d3, lat_d4, lon_d4,
			lat_d5, lon_d5;
	double lat1 = 27.674274, lon1 = 85.314391;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.main);
		getWindow()
				.setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.mytitle);
		ListView lv = (ListView) findViewById(R.id.mylist);

		Log.e("log-cat", "Starting of the getServerdata()");
		ArrayList<HashMap<String, String>> hotelList = new ArrayList<HashMap<String, String>>();
		Log.e("log-tag", "Parsing  passing through jArray...");
		JSONParser jParser = new JSONParser();
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new DoubleNameValuePair("lat1", lat1));
		nameValuePairs.add(new DoubleNameValuePair("lon1", lon1));
		JSONArray jArray = jParser.getJSONFromUrl(URI, nameValuePairs);
		Log.e("Log-tag", "Passing through method call");

		try {
			for (int i = 0; i < jArray.length(); i++) {

				JSONObject json_data = jArray.getJSONObject(i);

				String id = "" + (i + 1) + ". ";
				String name = json_data.getString(TAG_NAME);
				String address = json_data.getString(TAG_ADDRESS);
				String phone = json_data.getString(TAG_PHONE);
				String optime = json_data.getString(TAG_OPTIME);
				double latitude = json_data.getDouble(TAG_LATITUDE);
				double longitude = json_data.getDouble(TAG_LONGITUDE);

				HashMap<String, String> map = new HashMap<String, String>();
				map.put(TAG_ID, id);
				map.put(TAG_NAME, name);
				map.put(TAG_ADDRESS, address);
				hotelList.add(map);

				if (i == 0) {
					h_id1 = json_data.getString("hotel_id");
					phone1 = phone;
					optime1 = optime;
					lat_d1 = latitude;
					lon_d1 = longitude;
				} else if (i == 1) {
					h_id2 = json_data.getString("hotel_id");
					phone2 = phone;
					optime2 = optime;
					lat_d2 = latitude;
					lon_d2 = longitude;
				} else if (i == 2) {
					h_id3 = json_data.getString("hotel_id");
					phone3 = phone;
					optime3 = optime;
					lat_d3 = latitude;
					lon_d3 = longitude;
				} else if (i == 3) {
					h_id4 = json_data.getString("hotel_id");
					phone4 = phone;
					optime4 = optime;
					lat_d4 = latitude;
					lon_d4 = longitude;
				} else if (i == 4) {
					h_id5 = json_data.getString("hotel_id");
					phone5 = phone;
					optime5 = optime;
					lat_d5 = latitude;
					lon_d5 = longitude;
				}

				Log.e("log-tag", "Successful data parsing");
			}
		} catch (JSONException e) {
			Log.e("log-tag", "Error in JsonArray Parsing" + e.toString());
		}

		SimpleAdapter adapter = new SimpleAdapter(this, hotelList,
				R.layout.grid_view, new String[] { TAG_ID, TAG_NAME,
						TAG_ADDRESS }, new int[] { R.id.tvhid, R.id.tvhname,
						R.id.tvhaddress });

		lv.setAdapter(adapter);
		// Launching new screen on Selecting Single ListItem
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				String name = ((TextView) view.findViewById(R.id.tvhname))
						.getText().toString();
				String address = ((TextView) view.findViewById(R.id.tvhaddress))
						.getText().toString();

				String phone = null, optime = null, h_id = null;
				double latitude=0, longitude=0;

				// Starting new intent
				Intent in = new Intent(getApplicationContext(), Hotels.class);

				in.putExtra(TAG_NAME, name);
				in.putExtra(TAG_ADDRESS, address);
				if (position == 0) {
					h_id = h_id1;
					phone = phone1;
					optime = optime1;
					latitude = lat_d1;
					longitude = lon_d1;
				} else if (position == 1) {
					h_id = h_id2;
					phone = phone2;
					optime = optime2;
					latitude = lat_d2;
					longitude = lon_d2;
				} else if (position == 2) {
					h_id = h_id3;
					phone = phone3;
					optime = optime3;
					latitude = lat_d3;
					longitude = lon_d3;
				} else if (position == 3) {
					h_id = h_id4;
					phone = phone4;
					optime = optime4;
					latitude = lat_d4;
					longitude = lon_d4;
				} else if (position == 4) {
					h_id = h_id5;
					phone = phone5;
					optime = optime5;
					latitude = lat_d5;
					longitude = lon_d5;
				}
				in.putExtra("h_id", h_id);
				in.putExtra(TAG_PHONE, phone);
				in.putExtra(TAG_OPTIME, optime);
				in.putExtra("lat2", latitude);
				in.putExtra("lon2", longitude);
				in.putExtra("lat1", lat1);
				in.putExtra("lon1", lon1);
				startActivity(in);
			}
		});

	}
}