package com.sh321han.mommyshare.Manager;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.sh321han.mommyshare.MyApplication;

public class PropertyManager {
	private static PropertyManager instance;
	public static PropertyManager getInstance() {
		if (instance == null) {
			instance = new PropertyManager();
		}
		return instance;
	}
	
	SharedPreferences mPrefs;
	SharedPreferences.Editor mEditor;
	
	private PropertyManager() {
		mPrefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
		mEditor = mPrefs.edit();
	}

	private static final String REG_ID = "regToken";
	
	public void setRegistrationToken(String regId) {
		mEditor.putString(REG_ID, regId);
		mEditor.commit();
	}
	
	public String getRegistrationToken() {
		return mPrefs.getString(REG_ID, "");
	}

	private Double xloca = 0.0;
	private Double yloca = 0.0;

	public void setXloca(Double longitude){
		xloca = longitude;
	}

	public void setYloca(Double latitude){
		yloca = latitude;
	}

	public Double getXloca() {
		return xloca;
	}

	public Double getYloca() {
		return yloca;
	}
}
