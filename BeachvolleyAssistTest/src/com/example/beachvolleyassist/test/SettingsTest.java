package com.example.beachvolleyassist.test;

import com.example.beachvolleyassist.SettingsActivity;
import com.example.beachvolleyassist.R;
import com.robotium.solo.Solo;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.LinearLayout;

public class SettingsTest extends ActivityInstrumentationTestCase2<SettingsActivity> {
	
	private Solo mySolo;
	
	public SettingsTest() {
		super(SettingsActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		mySolo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testActivityTitle()
	{	
		mySolo.getView(R.id.textViewActivityTitle);
		mySolo.getText("Settings");
	}

	public void testButtonCancel()
	{	
		mySolo.clickOnView(mySolo.getView(R.id.buttonCancel));
		mySolo.getText("Do you really want to cancel the game settings?");
	}
	
}