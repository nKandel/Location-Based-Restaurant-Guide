package com.androidapp.restaurantguide;

import org.apache.http.NameValuePair;

public class DoubleNameValuePair implements NameValuePair {

	
	String name;
	double value;

    public DoubleNameValuePair(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return Double.toString(value);
	}

}
