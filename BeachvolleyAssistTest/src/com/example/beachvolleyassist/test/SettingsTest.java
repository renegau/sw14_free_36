package com.example.beachvolleyassist.test;

import junit.framework.Assert;

import com.example.beachvolleyassist.SettingsActivity;
import com.example.beachvolleyassist.Settings;
import com.example.beachvolleyassist.R;
import com.robotium.solo.Solo;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

public class SettingsTest extends ActivityInstrumentationTestCase2<SettingsActivity> {
	
	private Solo mySolo;
	private Settings mySettings;
	
	public SettingsTest() {
		super(SettingsActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		mySolo = new Solo(getInstrumentation(), getActivity());
		
		Activity settings_activity = this.getActivity();
		mySettings = (Settings) settings_activity.getApplication();
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
	
	public void testSetTeamRedPlayer1()
	{	
		String text_input = new String("Test TeamRedPlayer1"); 
		EditText edit_text = (EditText) mySolo.getView(R.id.editTextTeamRedPlayer1);
		mySolo.clearEditText(edit_text);
		mySolo.enterText(edit_text, text_input);
		Assert.assertTrue(mySettings.getTeamRedPlayer1().equals(text_input));
	}
	
	public void testSetTeamRedPlayer2()
	{	
		String text_input = new String("Test TeamRedPlayer2"); 
		EditText edit_text = (EditText) mySolo.getView(R.id.editTextTeamRedPlayer2);
		mySolo.clearEditText(edit_text);
		mySolo.enterText(edit_text, text_input);
		Assert.assertTrue(mySettings.getTeamRedPlayer2().equals(text_input));
	}
	
	public void testSetTeamBluePlayer1()
	{	
		String text_input = new String("Test TeamBluePlayer1"); 
		EditText edit_text = (EditText) mySolo.getView(R.id.editTextTeamBluePlayer1);
		mySolo.clearEditText(edit_text);
		mySolo.enterText(edit_text, text_input);
		Assert.assertTrue(mySettings.getTeamBluePlayer1().equals(text_input));
	}
	
	public void testSetTeamBluePlayer2()
	{	
		String text_input = new String("Test TeamBluePlayer2"); 
		EditText edit_text = (EditText) mySolo.getView(R.id.editTextTeamBluePlayer2);
		mySolo.clearEditText(edit_text);
		mySolo.enterText(edit_text, text_input);
		Assert.assertTrue(mySettings.getTeamBluePlayer2().equals(text_input));
	}
}