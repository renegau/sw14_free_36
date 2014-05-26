package com.example.beachvolleyassist.test;

import com.example.beachvolleyassist.MainActivity;
import com.example.beachvolleyassist.R;
import com.robotium.solo.Solo;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.LinearLayout;

public class MainTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	private Solo mySolo;
	
	public MainTest() {
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		mySolo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testButtons()
	{
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
	}
	
	public void testButtonRedCounter()
	{
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));

		mySolo.getText("3");		
	}
	
	public void testButtonBlueCounter()
	{
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));

		mySolo.getText("5");
	}
	
	public void testTeamRedWin()
	{
		for(int red = 0; red < 21; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		}		
		
		mySolo.getText("TEAM RED WIN THE GAME");
	}
	
	public void testTeamBlueWin()
	{	
		for(int red = 0; red < 20; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		}
		
		for(int blue = 0; blue < 22; blue++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		}
		
		mySolo.getText("TEAM BLUE WIN THE GAME");
	}
	
	public void testButtonCancel()
	{
		for(int red = 0; red < 5; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		}
		
		for(int blue = 0; blue < 8; blue++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		}
		
		mySolo.clickOnView(mySolo.getView(R.id.buttonCancel));
		
		mySolo.getText("0");
	}
	
	public void testButtonUndo()
	{
		for(int red = 0; red < 5; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		}
		
		mySolo.clickOnView(mySolo.getView(R.id.buttonUndo));
		
		mySolo.getText("4");
		
		for(int blue = 0; blue < 8; blue++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		}
		
		mySolo.clickOnView(mySolo.getView(R.id.buttonUndo));
		
		mySolo.getText("7");
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void testChangeLayout()
	{
		LinearLayout layout_red = (LinearLayout) mySolo.getView(R.id.LayoutRed);
		LinearLayout layout_blue = (LinearLayout) mySolo.getView(R.id.LayoutBlue);
		
		float red_x = layout_red.getX();
		float red_y = layout_red.getY();
		float blue_x = layout_blue.getX();
		float blue_y = layout_blue.getY();
		
		for(int red = 0; red < 4; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		}
		
		for(int blue = 0; blue < 3; blue++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		}
		
		float new_red_x = layout_red.getX();
		float new_red_y = layout_red.getY();
		float new_blue_x = layout_blue.getX();
		float new_blue_y = layout_blue.getY();
		
		assertEquals(red_x, new_blue_x);
		assertEquals(red_y, new_blue_y);
		assertEquals(blue_x, new_red_x);
		assertEquals(blue_y, new_red_y);
	}
	
	public void testTimeoutRed()
	{
		mySolo.clickOnView(mySolo.getView(R.id.buttonTimeoutRed));
		
		mySolo.getText("30");
	}
	
	public void testTimeoutBlue()
	{
		mySolo.clickOnView(mySolo.getView(R.id.buttonTimeoutBlue));
		
		mySolo.getText("30");
	}
}