package com.androidapp.restaurantguide;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class menu_complete extends Activity{
	
	public static final String URI1 = "http://10.0.2.2/hotel_menu_preview.php";
	public static final String URI2 = "http://10.0.2.2/hotel_items_menu.php";
	private static final String TAG_CUSINE = "cusine";
	private static final String TAG_SPECIALITY = "speciality";
	private static final String TAG_ITEM_NAME = "item_name";
	private static final String TAG_ITEM_PRICE = "item_price";
	
	static InputStream is = null;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.menu_complete);
		ListView lv = (ListView) findViewById(R.id.menulist);
		
		TextView tvtitle = (TextView) findViewById(R.id.tvmenu_Title);
		TextView tvlocation = (TextView) findViewById(R.id.tvmenu_Location);
		TextView tvcusine = (TextView) findViewById(R.id.tvCusine_Description);
		TextView tvspeciality = (TextView) findViewById(R.id.tvSpeciality_Description);
		String speciality=null,cusine=null;
		
		
		Intent intent = getIntent();
		String title = intent.getStringExtra("hotel_name");
		String location = intent.getStringExtra("hotel_location");
		String h_id = intent.getStringExtra("h_id");
		Log.e("h_id", h_id);
		
		tvtitle.setText(title);
		tvlocation.setText(location);
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("h_id", h_id));
		JSONParser jParser = new JSONParser();
		JSONArray jArray = jParser.getJSONFromUrl(URI1,nameValuePairs);
		try{
			for (int i = 0; i < jArray.length(); i++) {

				JSONObject json_data = jArray.getJSONObject(i);
				cusine = json_data.getString(TAG_CUSINE);
				speciality = json_data.getString(TAG_SPECIALITY);
				tvcusine.setText(cusine);
				tvspeciality.setText(speciality);
		}
		}catch (JSONException e) {
			Log.e("log-tag", "Error in JSONArray Parsing for URI1" + e.toString());
		}
		
		
		
		ArrayList<HashMap<String, String>> menuList = new ArrayList<HashMap<String, String>>();
		ArrayList<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		nameValuePair.add(new BasicNameValuePair("h_id", h_id));
		Log.e("h_id", h_id);
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = jsonParser.getJSONFromUrl(URI2,nameValuePair);
		
		try {
			for (int j = 0; j < jsonArray.length(); j++) {

				JSONObject json_data = jsonArray.getJSONObject(j);
				String item_name = json_data.getString(TAG_ITEM_NAME);
				String item_price = json_data.getString(TAG_ITEM_PRICE);
				
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(TAG_ITEM_NAME, item_name);
				map.put(TAG_ITEM_PRICE, item_price);
				menuList.add(map);
				
				Log.e("log-tag", "Successful data parsing");
			}
		} catch (JSONException e) {
			Log.e("log-tag", "Error in JSONArray Parsing" + e.toString());
		}

		SimpleAdapter adapter = new SimpleAdapter(this, menuList,
				R.layout.menu_grid_view, new String[] { TAG_ITEM_NAME,
						TAG_ITEM_PRICE }, new int[] { R.id.tvitem_name, R.id.tvprice,
						 });

		lv.setAdapter(adapter);
		
		
	}
	
	
}
