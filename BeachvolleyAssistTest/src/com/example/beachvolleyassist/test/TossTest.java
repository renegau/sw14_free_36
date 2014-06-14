package com.example.beachvolleyassist.test;

import com.example.beachvolleyassist.TossActivity;
import com.example.beachvolleyassist.R;
import com.robotium.solo.Solo;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class TossTest extends ActivityInstrumentationTestCase2<TossActivity> {
	
	private Solo mySolo;
	
	public TossTest() {
		super(TossActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		mySolo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test_1_TestAfterRandom()
	{	
		mySolo.sleep(5000);
		
		View teamRedButton = mySolo.getView(R.id.buttonTeamRed);
		ColorDrawable colorDrawableRed = (ColorDrawable) teamRedButton.getBackground();
        int teamRedButtonColorValue = colorDrawableRed.getColor();
		
        View teamBlueButton = mySolo.getView(R.id.buttonTeamBlue);
		ColorDrawable colorDrawableBlue = (ColorDrawable) teamBlueButton.getBackground();
        int teamBlueButtonColorValue = colorDrawableBlue.getColor();
		
        // public static final int BLUE
        // Constant Value: -16776961 (0xff0000ff)
        //
        // public static final int RED
        // Constant Value: -65536 (0xffff0000)
        // 
        // public static final int WHITE
        // Constant Value: -1 (0xffffffff)

        assertTrue(
        		( teamRedButtonColorValue == Color.RED && teamBlueButtonColorValue == Color.WHITE ) ||
        		( teamRedButtonColorValue == Color.WHITE && teamBlueButtonColorValue == Color.BLUE) );
		
	}
	
	public void test_2_step2()
	{	
	    
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

}