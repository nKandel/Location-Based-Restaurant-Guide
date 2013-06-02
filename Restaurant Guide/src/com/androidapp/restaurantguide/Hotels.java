package com.androidapp.restaurantguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Hotels extends Activity {

	String title, location;
	String h_id;
	Button btnMenu;
	Button btnMap;
	double lat1, lat2, lon1, lon2;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.hotels);
		TextView tvtitle = (TextView) findViewById(R.id.tvTitle);
		TextView tvlocation = (TextView) findViewById(R.id.tvLocation);
		TextView tvphone = (TextView) findViewById(R.id.tvPhoneDetail);
		TextView tvopTime = (TextView) findViewById(R.id.tvOpeningTimeDetail);
		ImageView image = (ImageView) findViewById(R.id.ivhotel);

		Intent i = getIntent();
		title = i.getStringExtra("hotel_name");
		location = i.getStringExtra("hotel_address");
		h_id = i.getStringExtra("h_id");
		lat1 = i.getDoubleExtra("lat1", 0);
		lat2 = i.getDoubleExtra("lat2", 0);
		lon1 = i.getDoubleExtra("lon1", 0);
		lon2 = i.getDoubleExtra("lon2", 0);

		String phone = i.getStringExtra("hotel_phone");
		String opTime = i.getStringExtra("hotel_opening_time");

		tvtitle.setText(title);
		tvlocation.setText(location);
		tvphone.setText(phone);
		tvopTime.setText(opTime);
		// image.setImageResource(R.drawable.alice_restaurant);

		String icon = "hotel" + h_id;
		int resID = getResources().getIdentifier(icon, "drawable",
				getPackageName());
		image.setImageResource(resID);

		Initialize();

	}

	void Initialize() {
		btnMenu = (Button) findViewById(R.id.btnViewMenuList);
		btnMap = (Button) findViewById(R.id.btnViewMap);

		btnMenu.setOnClickListener((OnClickListener) this);
		btnMenu.setOnClickListener((OnClickListener) this);
	}

	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.btnViewMenuList:
			Intent in = new Intent(getApplicationContext(), menu_complete.class);
			in.putExtra("hotel_name", title);
			in.putExtra("h_id", h_id);
			Log.e("h_id", h_id);
			in.putExtra("hotel_location", location);
			startActivity(in);
			break;
		case R.id.btnViewMap:
			Intent intent = new Intent(getApplicationContext(),
					GoogleMap_Display.class);
			intent.putExtra("lat2", lat2);
			intent.putExtra("lon2", lon2);
			intent.putExtra("lat1", lat1);
			intent.putExtra("lon1", lon1);
			startActivity(intent);
			break;
		}

	}

}
