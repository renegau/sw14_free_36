package com.example.beachvolleyassist.test;

import com.example.beachvolleyassist.MainActivity;
import com.example.beachvolleyassist.R;
import com.robotium.solo.Solo;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
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
	
	public void testButtonBlueCounter()
	{
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));

		mySolo.getText("5");
	}
	
	public void testButtonBlueCounter_UNIT()
	{
		final Button button_Blue = (Button) getActivity().findViewById(R.id.buttonBlue);
		
		button_Blue.performClick();
		
		assertEquals("ERROR", button_Blue.getText(), 1);
	}
	
	public void testButtonCancel()
	{
		for(int red = 0; red < 3; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		}
		
		for(int blue = 0; blue < 2; blue++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		}
		
		mySolo.clickOnView(mySolo.getView(R.id.buttonCancel));
		
		mySolo.getText("Do you really want to cancel the game?");
	}
	
	public void testButtonCancel_UNIT()
	{
		final Button button_Cancel = (Button) getActivity().findViewById(R.id.buttonCancel);
		
		button_Cancel.performClick();
		
		assertEquals("ERROR", 1 , "Do you really want to cancel the game?");
	}
	
	public void testButtonRedCounter()
	{
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));

		mySolo.getText("3");		
	}
	
	public void testButtonRedCounter_UNIT()
	{
		final Button button_Red = (Button) getActivity().findViewById(R.id.buttonRed);
		
		button_Red.performClick();
		
		assertEquals("ERROR", button_Red.getText(), 1);
	}

	public void testButtonUndo()
	{
		for(int red = 0; red < 2; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		}
		
		mySolo.clickOnView(mySolo.getView(R.id.buttonUndo));
		
		mySolo.getText("1");
		
		
		for(int blue = 0; blue < 4; blue++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		}
		
		mySolo.clickOnView(mySolo.getView(R.id.buttonUndo));
		
		mySolo.getText("3");
	}
	
	public void testButtons()
	{
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
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
		
		mySolo.getText("Change the sides");
		mySolo.clickOnView(mySolo.getView(android.R.id.button1));
		
		float new_red_x = layout_red.getX();
		float new_red_y = layout_red.getY();
		float new_blue_x = layout_blue.getX();
		float new_blue_y = layout_blue.getY();
		
		assertEquals(red_x, new_blue_x);
		assertEquals(red_y, new_blue_y);
		assertEquals(blue_x, new_red_x);
		assertEquals(blue_y, new_red_y);
	}
		
	public void testTeamBlueWinSet()
	{	
		for(int red = 0; red < 7; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		}
		
		mySolo.getText("Change the sides");
		mySolo.clickOnView(mySolo.getView(android.R.id.button1));
		
		for(int red = 0; red < 7; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		}
		
		mySolo.getText("Change the sides");
		mySolo.clickOnView(mySolo.getView(android.R.id.button1));
		
		for(int red = 0; red < 7; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		}
		
		mySolo.getText("'Team BLUE' win this set");
	}
	
	public void testTeamRedWinSet()
	{
		for(int red = 0; red < 7; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		}
		
		mySolo.getText("Change the sides");
		mySolo.clickOnView(mySolo.getView(android.R.id.button1));
		
		for(int red = 0; red < 7; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		}
		
		mySolo.getText("Change the sides");
		mySolo.clickOnView(mySolo.getView(android.R.id.button1));
		
		for(int red = 0; red < 7; red++)
		{
		  mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		}	
		
		mySolo.getText("'Team RED' win this set");
	}
	
	public void testTimeoutBlue()
	{
		mySolo.clickOnView(mySolo.getView(R.id.buttonTimeoutBlue));
		mySolo.searchText("Timeout 'Team BLUE'");
	}
	
	
	public void testTimeoutRed()
	{
		mySolo.clickOnView(mySolo.getView(R.id.buttonTimeoutRed));
		mySolo.searchText("Timeout 'Team RED'");
	}
	
}