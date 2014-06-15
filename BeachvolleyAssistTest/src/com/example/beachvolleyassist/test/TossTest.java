package com.example.beachvolleyassist.test;

import com.example.beachvolleyassist.Settings;
import com.example.beachvolleyassist.TossActivity;
import com.example.beachvolleyassist.R;
import com.example.beachvolleyassist.Settings.Player;
import com.example.beachvolleyassist.Settings.Team;
import com.robotium.solo.Solo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class TossTest extends ActivityInstrumentationTestCase2<TossActivity> {
	
	private Solo mySolo;
	
	private int _teamRedButtonColorValue;
	private int _teamBlueButtonColorValue;
	private Settings mySettings;
	
	public TossTest() {
		super(TossActivity.class);
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
	
	public void testAfterRandom()
	{	
		waitForRandom();
		
		// public static final int BLUE
        // Constant Value: -16776961 (0xff0000ff)
        //
        // public static final int RED
        // Constant Value: -65536 (0xffff0000)
        // 
        // public static final int WHITE
        // Constant Value: -1 (0xffffffff)

        assertTrue(
        		( _teamRedButtonColorValue == Color.RED && _teamBlueButtonColorValue == Color.WHITE ) ||
        		( _teamRedButtonColorValue == Color.WHITE && _teamBlueButtonColorValue == Color.BLUE) );
	}
	
	public void testTextStep2AndStep3()
	{	
		waitForRandom();
		
		// Team RED wins the toss
        if (_teamRedButtonColorValue == Color.RED && _teamBlueButtonColorValue == Color.WHITE)
        {
        	mySolo.getView(R.id.textViewStep2);
    		mySolo.getText("Step 2/4: Winner of the toss TEAM RED is choosing?");
    		
    		mySolo.getView(R.id.textViewStep3);
    		mySolo.getText("Step 3/4: Looser of the toss TEAM BLUE is choosing?");
        }
        // Team BLUE wins the toss
        else if (_teamRedButtonColorValue == Color.WHITE && _teamBlueButtonColorValue == Color.BLUE)
        {
        	mySolo.getView(R.id.textViewStep2);
    		mySolo.getText("Step 2/4: Winner of the toss TEAM BLUE is choosing?");
    		
    		mySolo.getView(R.id.textViewStep3);
    		mySolo.getText("Step 3/4: Looser of the toss TEAM RED is choosing?");
        }     
        else
        {
        	assertFalse(true);
        }
        
	}
	
	public void testStep2ChooseService()
	{	
		waitForRandom();
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep2Service));
		mySolo.sleep(1000);
		
		assertTrue(mySolo.getView(R.id.buttonStep2Service).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Return).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Leftside).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Rightside).isEnabled());
		
		assertFalse(mySolo.getView(R.id.buttonStep3Service).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Return).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep3Leftside).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep3Rightside).isEnabled());
		
		// Team RED wins the toss
        if (_teamRedButtonColorValue == Color.RED && _teamBlueButtonColorValue == Color.WHITE)
        {
		    assertTrue(mySettings.getFirstServiceTeam().equals(Team.RED));
        }
        // Team BLUE wins the toss
        else if (_teamRedButtonColorValue == Color.WHITE && _teamBlueButtonColorValue == Color.BLUE)
        {
        	assertTrue(mySettings.getFirstServiceTeam().equals(Team.BLUE));
        }     
        else
        {
        	assertFalse(true);
        }
        
	}
	
	public void testStep2ChooseReturn()
	{	
		waitForRandom();
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep2Return));
		mySolo.sleep(1000);
		
		assertFalse(mySolo.getView(R.id.buttonStep2Service).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep2Return).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Leftside).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Rightside).isEnabled());
		
		assertFalse(mySolo.getView(R.id.buttonStep3Service).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Return).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep3Leftside).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep3Rightside).isEnabled());
		
		// Team RED wins the toss
        if (_teamRedButtonColorValue == Color.RED && _teamBlueButtonColorValue == Color.WHITE)
        {
		    assertTrue(mySettings.getFirstServiceTeam().equals(Team.BLUE));
        }
        // Team BLUE wins the toss
        else if (_teamRedButtonColorValue == Color.WHITE && _teamBlueButtonColorValue == Color.BLUE)
        {
        	assertTrue(mySettings.getFirstServiceTeam().equals(Team.RED));
        }     
        else
        {
        	assertFalse(true);
        }
	}
	
	public void testStep2ChooseLeftSide()
	{	
		waitForRandom();
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep2Leftside));
		mySolo.sleep(1000);
		
		assertFalse(mySolo.getView(R.id.buttonStep2Service).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Return).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep2Leftside).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Rightside).isEnabled());
		
		assertTrue(mySolo.getView(R.id.buttonStep3Service).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep3Return).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Leftside).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Rightside).isEnabled());
		
		// Team RED wins the toss
        if (_teamRedButtonColorValue == Color.RED && _teamBlueButtonColorValue == Color.WHITE)
        {
		    assertTrue(mySettings.getBeginningSideLeft().equals(Team.RED));
		    assertTrue(mySettings.getBeginningSideRight().equals(Team.BLUE));
        }
        // Team BLUE wins the toss
        else if (_teamRedButtonColorValue == Color.WHITE && _teamBlueButtonColorValue == Color.BLUE)
        {
        	assertTrue(mySettings.getBeginningSideLeft().equals(Team.BLUE));
        	assertTrue(mySettings.getBeginningSideRight().equals(Team.RED));
        }     
        else
        {
        	assertFalse(true);
        }
	}
	
	public void testStep2ChooseLeftRight()
	{	
		waitForRandom();
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep2Rightside));
		mySolo.sleep(1000);
		
		assertFalse(mySolo.getView(R.id.buttonStep2Service).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Return).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Leftside).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep2Rightside).isEnabled());
		
		assertTrue(mySolo.getView(R.id.buttonStep3Service).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep3Return).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Leftside).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Rightside).isEnabled());
		
		// Team RED wins the toss
        if (_teamRedButtonColorValue == Color.RED && _teamBlueButtonColorValue == Color.WHITE)
        {
		    assertTrue(mySettings.getBeginningSideRight().equals(Team.RED));
		    assertTrue(mySettings.getBeginningSideLeft().equals(Team.BLUE));
        }
        // Team BLUE wins the toss
        else if (_teamRedButtonColorValue == Color.WHITE && _teamBlueButtonColorValue == Color.BLUE)
        {
        	assertTrue(mySettings.getBeginningSideRight().equals(Team.BLUE));
        	assertTrue(mySettings.getBeginningSideLeft().equals(Team.RED));
        }     
        else
        {
        	assertFalse(true);
        }
	}
	
	public void testStep3ChooseService()
	{	
		waitForRandom();
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep2Rightside));
		mySolo.sleep(1000);
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep3Service));
		mySolo.sleep(1000);
		
		assertFalse(mySolo.getView(R.id.buttonStep2Service).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Return).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Leftside).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep2Rightside).isEnabled());
		
		assertTrue(mySolo.getView(R.id.buttonStep3Service).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Return).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Leftside).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Rightside).isEnabled());
		
		// Team RED wins the toss
        if (_teamRedButtonColorValue == Color.RED && _teamBlueButtonColorValue == Color.WHITE)
        {
		    assertTrue(mySettings.getBeginningSideRight().equals(Team.RED));
		    assertTrue(mySettings.getBeginningSideLeft().equals(Team.BLUE));
		    
		    assertTrue(mySettings.getFirstServiceTeam().equals(Team.BLUE));
        }
        // Team BLUE wins the toss
        else if (_teamRedButtonColorValue == Color.WHITE && _teamBlueButtonColorValue == Color.BLUE)
        {
        	assertTrue(mySettings.getBeginningSideRight().equals(Team.BLUE));
        	assertTrue(mySettings.getBeginningSideLeft().equals(Team.RED));
        	
        	assertTrue(mySettings.getFirstServiceTeam().equals(Team.RED));
        }     
        else
        {
        	assertFalse(true);
        }
	}
	
	public void testStep3ChooseReturn()
	{	
		waitForRandom();
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep2Rightside));
		mySolo.sleep(1000);
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep3Return));
		mySolo.sleep(1000);
		
		assertFalse(mySolo.getView(R.id.buttonStep2Service).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Return).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Leftside).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep2Rightside).isEnabled());
		
		assertFalse(mySolo.getView(R.id.buttonStep3Service).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep3Return).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Leftside).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Rightside).isEnabled());
		
		// Team RED wins the toss
        if (_teamRedButtonColorValue == Color.RED && _teamBlueButtonColorValue == Color.WHITE)
        {
		    assertTrue(mySettings.getBeginningSideRight().equals(Team.RED));
		    assertTrue(mySettings.getBeginningSideLeft().equals(Team.BLUE));
		    
		    assertTrue(mySettings.getFirstServiceTeam().equals(Team.RED));
        }
        // Team BLUE wins the toss
        else if (_teamRedButtonColorValue == Color.WHITE && _teamBlueButtonColorValue == Color.BLUE)
        {
        	assertTrue(mySettings.getBeginningSideRight().equals(Team.BLUE));
        	assertTrue(mySettings.getBeginningSideLeft().equals(Team.RED));
        	
        	assertTrue(mySettings.getFirstServiceTeam().equals(Team.BLUE));
        }     
        else
        {
        	assertFalse(true);
        }
	}
	
	public void testStep3ChooseLeftside()
	{	
		waitForRandom();
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep2Service));
		mySolo.sleep(1000);
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep3Leftside));
		mySolo.sleep(1000);
		
		assertTrue(mySolo.getView(R.id.buttonStep2Service).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Return).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Leftside).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Rightside).isEnabled());
		
		assertFalse(mySolo.getView(R.id.buttonStep3Service).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Return).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep3Leftside).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Rightside).isEnabled());
		
		// Team RED wins the toss
        if (_teamRedButtonColorValue == Color.RED && _teamBlueButtonColorValue == Color.WHITE)
        {
		    assertTrue(mySettings.getFirstServiceTeam().equals(Team.RED));
		    
		    assertTrue(mySettings.getBeginningSideLeft().equals(Team.BLUE));
		    assertTrue(mySettings.getBeginningSideRight().equals(Team.RED));
        }
        // Team BLUE wins the toss
        else if (_teamRedButtonColorValue == Color.WHITE && _teamBlueButtonColorValue == Color.BLUE)
        {
        	assertTrue(mySettings.getFirstServiceTeam().equals(Team.BLUE));
        	
		    assertTrue(mySettings.getBeginningSideLeft().equals(Team.RED));
		    assertTrue(mySettings.getBeginningSideRight().equals(Team.BLUE));        	
        }     
        else
        {
        	assertFalse(true);
        }
	}
	
	public void testStep3ChooseRightside()
	{	
		waitForRandom();
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep2Service));
		mySolo.sleep(1000);
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep3Rightside));
		mySolo.sleep(1000);
		
		assertTrue(mySolo.getView(R.id.buttonStep2Service).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Return).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Leftside).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep2Rightside).isEnabled());
		
		assertFalse(mySolo.getView(R.id.buttonStep3Service).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Return).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonStep3Leftside).isEnabled());
		assertTrue(mySolo.getView(R.id.buttonStep3Rightside).isEnabled());
		
		// Team RED wins the toss
        if (_teamRedButtonColorValue == Color.RED && _teamBlueButtonColorValue == Color.WHITE)
        {
		    assertTrue(mySettings.getFirstServiceTeam().equals(Team.RED));
		    
		    assertTrue(mySettings.getBeginningSideRight().equals(Team.BLUE));
		    assertTrue(mySettings.getBeginningSideLeft().equals(Team.RED));
        }
        // Team BLUE wins the toss
        else if (_teamRedButtonColorValue == Color.WHITE && _teamBlueButtonColorValue == Color.BLUE)
        {
        	assertTrue(mySettings.getFirstServiceTeam().equals(Team.BLUE));
        	
        	assertTrue(mySettings.getBeginningSideRight().equals(Team.RED));
		    assertTrue(mySettings.getBeginningSideLeft().equals(Team.BLUE));        	
        }     
        else
        {
        	assertFalse(true);
        }
	}
	
	public void testStep4ChoosePlayerRed1()
	{	
		waitForRandom();
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep2Service));
		mySolo.sleep(1000);
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep3Rightside));
		mySolo.sleep(1000);
		
		mySolo.clickOnView(mySolo.getView(R.id.buttonPlayerRed1));
		mySolo.sleep(1000);
		
		assertTrue(mySolo.getView(R.id.buttonPlayerRed1).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonPlayerRed2).isEnabled());
		
		assertTrue(mySettings.getFirstServicePlayerRed().equals(Player.ONE));
	}
	
	public void testStep4ChoosePlayerRed2()
	{	
		waitForRandom();
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep2Service));
		mySolo.sleep(1000);
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep3Rightside));
		mySolo.sleep(1000);
		
		mySolo.clickOnView(mySolo.getView(R.id.buttonPlayerRed2));
		mySolo.sleep(1000);
		
		assertTrue(mySolo.getView(R.id.buttonPlayerRed2).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonPlayerRed1).isEnabled());
		
		assertTrue(mySettings.getFirstServicePlayerRed().equals(Player.TWO));
	}
	
	public void testStep4ChoosePlayerBlue1()
	{	
		waitForRandom();
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep2Service));
		mySolo.sleep(1000);
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep3Rightside));
		mySolo.sleep(1000);
		
		mySolo.clickOnView(mySolo.getView(R.id.buttonPlayerBlue1));
		mySolo.sleep(1000);
		
		assertTrue(mySolo.getView(R.id.buttonPlayerBlue1).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonPlayerBlue2).isEnabled());
		
		assertTrue(mySettings.getFirstServicePlayerBlue().equals(Player.ONE));
	}
	
	public void testStep4ChoosePlayerBlue2()
	{	
		waitForRandom();
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep2Service));
		mySolo.sleep(1000);
		mySolo.clickOnView(mySolo.getView(R.id.buttonStep3Rightside));
		mySolo.sleep(1000);
		
		mySolo.clickOnView(mySolo.getView(R.id.buttonPlayerBlue2));
		mySolo.sleep(1000);
		
		assertTrue(mySolo.getView(R.id.buttonPlayerBlue2).isEnabled());
		assertFalse(mySolo.getView(R.id.buttonPlayerBlue1).isEnabled());
		
		assertTrue(mySettings.getFirstServicePlayerBlue().equals(Player.TWO));
	}
	
	public void testActivityTitle()
	{	
		mySolo.getView(R.id.textViewTossTitle);
		mySolo.getText("The toss");
	}
	
	public void testButtonCancel()
	{	
		mySolo.clickOnView(mySolo.getView(R.id.buttonCancel));
		mySolo.getText("Do you really want to cancel the game settings?");
	}

	public void testButtonUndo()
	{	
		mySolo.clickOnView(mySolo.getView(R.id.buttonUndo));
		mySolo.getText("Undo");
		
		// TODO
		assertTrue(false);
	}

	public void testTeamRedButton()
	{	
		String s = "Team RED \n " + mySettings.getTeamRedPlayer1() + " \n " + mySettings.getTeamRedPlayer2();
		
		mySolo.clickOnView(mySolo.getView(R.id.buttonTeamRed));
		mySolo.getText(s);
	}
	
	public void testTeamBlueButton()
	{	
		String s = "Team BLUE \n " + mySettings.getTeamBluePlayer1() + " \n " + mySettings.getTeamBluePlayer2();
		
		mySolo.clickOnView(mySolo.getView(R.id.buttonTeamBlue));
		mySolo.getText(s);
	}
	
	
	private void waitForRandom()
	{
		mySolo.sleep(5000);
		
		View teamRedButton = mySolo.getView(R.id.buttonTeamRed);
		ColorDrawable colorDrawableRed = (ColorDrawable) teamRedButton.getBackground();
		_teamRedButtonColorValue = colorDrawableRed.getColor();
		
		View teamBlueButton = mySolo.getView(R.id.buttonTeamBlue);
		ColorDrawable colorDrawableBlue = (ColorDrawable) teamBlueButton.getBackground();
		_teamBlueButtonColorValue = colorDrawableBlue.getColor();
	}
	
}