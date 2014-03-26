package com.example.beachvolleyassist.test;

import com.example.beachvolleyassist.MainActivity;
import com.example.beachvolleyassist.R;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

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
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));
		mySolo.clickOnView(mySolo.getView(R.id.buttonBlue));

		mySolo.getText("3");		
	}
	
	public void testButtonBlueCounter()
	{
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));
		mySolo.clickOnView(mySolo.getView(R.id.buttonRed));

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
}