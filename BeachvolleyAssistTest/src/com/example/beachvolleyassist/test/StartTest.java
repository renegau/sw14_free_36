package com.example.beachvolleyassist.test;

import com.example.beachvolleyassist.StartActivity;
import com.example.beachvolleyassist.R;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class StartTest extends ActivityInstrumentationTestCase2<StartActivity> {
	
	private Solo mySolo;
	
	public StartTest() {
		super(StartActivity.class);
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
		mySolo.getView(R.id.textViewAppTitle);
		mySolo.getText("Beachvolley Assist");
	}
	
	public void testExit()
	{	
		mySolo.clickOnView(mySolo.getView(R.id.buttonExit));
		
		mySolo.getText("Do you really want to exit Beachvollay Assist?");
		mySolo.clickOnView(mySolo.getView(android.R.id.button1));
	}

}