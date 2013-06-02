package com.androidapp.restaurantguide;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.OverlayItem;

public class GoogleMap_Display extends MapActivity {
	GeoPoint point = new GeoPoint(27682165,85318518);
	/*we can use if point is equal to hotel location then display hotel name*/
	OverlayItem overlayitem = new OverlayItem(point, "Restaurant!", "I'm at Pulchowk!");
	private double currentLatitude ;
	private double currentLongitude ;
	private double fixedLatitude;
	private double fixedLongitude;
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.googlemap_display);
		/*MapView mapView = (MapView) findViewById(R.id.mapview);
	    mapView.setBuiltInZoomControls(true);//default zoom button of google maps
	    List<Overlay> mapOverlays = mapView.getOverlays();
	    Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
	    HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(drawable, this);
	    itemizedoverlay.addOverlay(overlayitem);
	    mapOverlays.add(itemizedoverlay);*/
		Intent i = new Intent();
		currentLatitude = i.getDoubleExtra("lat1", 0);
		currentLongitude = i.getDoubleExtra("lon1", 0);
		fixedLatitude = i.getDoubleExtra("lat2", 0);
		fixedLongitude = i.getDoubleExtra("lon2", 0);
		
	    calc_short_Distance();
	}
	private void calc_short_Distance() {
		// TODO Auto-generated method stub
		String uri = "http://maps.google.com/maps?saddr=" + currentLatitude+","+currentLongitude+"&daddr="+fixedLatitude+","+fixedLongitude;
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
		intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
		startActivity(intent);
		//canvas.rotate(180);
		
	}
	@Override
	protected boolean isLocationDisplayed(){
		return true;
	}
	@Override
	protected boolean isRouteDisplayed(){
    	return false;
    }

}
