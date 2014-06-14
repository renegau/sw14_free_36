package com.example.beachvolleyassist;

import java.util.Random;

import com.example.beachvolleyassist.Settings.Player;
import com.example.beachvolleyassist.Settings.Team;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TossActivity extends Activity implements OnClickListener {
	
	Settings mySettings;
	
	private Button button_Next;
	private Button button_Cancel;
	
	private Button button_TeamRed;
	private Button button_TeamBlue;
	
	private TextView textView_Step2;
	private TextView textView_Step3;
	
	private Button button_PlayerRed1;
	private Button button_PlayerRed2;
	private Button button_PlayerBlue1;
	private Button button_PlayerBlue2;
	
	private Button button_Step2Service;
	private Button button_Step2Return;
	private Button button_Step2Leftside;
	private Button button_Step2Rightside;
	
	private Button button_Step3Service;
	private Button button_Step3Return;
	private Button button_Step3Leftside;
	private Button button_Step3Rightside;
	
	boolean winner_blue = false;
	boolean winner_red = false;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		ActivityRegistry.register(this);
		
		setContentView(R.layout.tossactivity);
		
		mySettings = (Settings) getApplication();
		
		this.button_Next = (Button) this.findViewById(R.id.buttonNext);
		this.button_Cancel = (Button) this.findViewById(R.id.buttonCancel);
		
		this.button_TeamRed = (Button) this.findViewById(R.id.buttonTeamRed);
		this.button_TeamBlue = (Button) this.findViewById(R.id.buttonTeamBlue);
		
		this.textView_Step2 = (TextView) this.findViewById(R.id.textViewStep2);
		this.textView_Step3 = (TextView) this.findViewById(R.id.textViewStep3);
		
		this.button_PlayerRed1 = (Button) this.findViewById(R.id.buttonPlayerRed1);
		this.button_PlayerRed2 = (Button) this.findViewById(R.id.buttonPlayerRed2);
		this.button_PlayerBlue1 = (Button) this.findViewById(R.id.buttonPlayerBlue1);
		this.button_PlayerBlue2 = (Button) this.findViewById(R.id.buttonPlayerBlue2);
		
		this.button_Step2Service = (Button) this.findViewById(R.id.buttonStep2Service);
		this.button_Step2Return = (Button) this.findViewById(R.id.buttonStep2Return);
		this.button_Step2Leftside = (Button) this.findViewById(R.id.buttonStep2Leftside);
		this.button_Step2Rightside = (Button) this.findViewById(R.id.buttonStep2Rightside);
		
		this.button_Step3Service = (Button) this.findViewById(R.id.buttonStep3Service);
		this.button_Step3Return = (Button) this.findViewById(R.id.buttonStep3Return);
		this.button_Step3Leftside = (Button) this.findViewById(R.id.buttonStep3Leftside);
		this.button_Step3Rightside = (Button) this.findViewById(R.id.buttonStep3Rightside);
		
		this.button_Next.setOnClickListener(this);
		this.button_Cancel.setOnClickListener(this);
		
		this.button_PlayerRed1.setOnClickListener(this);
		this.button_PlayerRed2.setOnClickListener(this);
		this.button_PlayerBlue1.setOnClickListener(this);
		this.button_PlayerBlue2.setOnClickListener(this);
		
		this.button_Step2Service.setOnClickListener(this);
		this.button_Step2Return.setOnClickListener(this);
		this.button_Step2Leftside.setOnClickListener(this);
		this.button_Step2Rightside.setOnClickListener(this);
		
		this.button_Step3Service.setOnClickListener(this);
		this.button_Step3Return.setOnClickListener(this);
		this.button_Step3Leftside.setOnClickListener(this);
		this.button_Step3Rightside.setOnClickListener(this);
		
		RandomNumber();
		
		this.button_PlayerRed1.setText(mySettings.getTeamRedPlayer1());
		this.button_PlayerRed2.setText(mySettings.getTeamRedPlayer2());
		this.button_PlayerBlue1.setText(mySettings.getTeamBluePlayer1());
		this.button_PlayerBlue2.setText(mySettings.getTeamBluePlayer2());
	}

	private void RandomNumber() 
	{
		Random r = new Random();
		
		final int r_number = r.nextInt(100) + 1;
		
		new CountDownTimer(5000, 100)
		{
		    public void onTick(long milliSeconds) 
		    {
		       if(milliSeconds % 2 == 0)
		       {
		    	   button_TeamRed.setBackgroundColor(Color.RED);
		    	   button_TeamBlue.setBackgroundColor(Color.WHITE);
		       }
		       else
		       {
		    	   button_TeamBlue.setBackgroundColor(Color.BLUE);
		    	   button_TeamRed.setBackgroundColor(Color.WHITE);
		       }
		    }

		    public void onFinish() 
		    {
		    	if(r_number %2 == 0)
		    	{
		    		button_TeamRed.setBackgroundColor(Color.RED);
			    	button_TeamBlue.setBackgroundColor(Color.WHITE);
			    	
			    	winner_red = true;
			    	winner_blue = false;
		    	}
			    else
			    {
			    	button_TeamBlue.setBackgroundColor(Color.BLUE);
			    	button_TeamRed.setBackgroundColor(Color.WHITE);

			    	winner_blue = true;
			    	winner_red = false;
			    }
		    	
				if(winner_red == true)
				{
					textView_Step2.setText("Step 2/4: Winner of the toss TEAM RED is choosing?");      
					textView_Step3.setText("Step 3/4: Looser of the toss TEAM BLUE is choosing?"); 
				}
				else if(winner_blue == true)
				{
					textView_Step2.setText("Step 2/4: Winner of the toss TEAM BLUE is choosing?");
					textView_Step3.setText("Step 3/4: Looser of the toss TEAM RED is choosing?");
				}
		    }
		}.start();
	}

	@Override
	public void onClick(View view) {
		
		Button clicked = (Button) view;
		AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
		
		if(clicked.getId() == this.button_Cancel.getId())
		{			
			dlgAlert.setMessage("Do you really want to cancel the game settings?");
			dlgAlert.setTitle("Cancle game settings");
			dlgAlert.setCancelable(false);
			
			dlgAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() 
			{
				public void onClick(DialogInterface dialog, int id) {
					// if this button is clicked then change to start activity
					
					// new Intent
					Intent start_activity = new Intent(getApplicationContext(), StartActivity.class);
					
					// Start Intent und switch to StartActivity
					startActivity(start_activity);
					
				}
			});
			  
			dlgAlert.setNegativeButton("No",new DialogInterface.OnClickListener() 
			{
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close the dialog box and do nothing
					dialog.cancel();
				}
			});
				
			dlgAlert.create().show();
		}
		
		else if (clicked.getId() == this.button_Next.getId()) 
		{			
			// new Intent
            Intent main_activity = new Intent(getApplicationContext(), MainActivity.class);
            
            // start Intent and change to MainActivity
            startActivity(main_activity);
		}
		
		else if (clicked.getId() == this.button_Step2Service.getId()) 
		{
			this.button_Step2Return.setEnabled(false);
			this.button_Step2Rightside.setEnabled(false);
			this.button_Step2Leftside.setEnabled(false);
			this.button_Step3Service.setEnabled(false);
			this.button_Step3Return.setEnabled(false);
			
			button_Step2Service.setClickable(false);
			
			if(winner_red == true)
			{
			  // mySettings.setServiceRed(true);
			  mySettings.setFirstServiceTeam(Team.RED);
			}
			else if(winner_blue == true)
			{
				mySettings.setFirstServiceTeam(Team.BLUE);
			}
		}
		
		else if (clicked.getId() == this.button_Step2Return.getId()) 
		{
			this.button_Step2Service.setEnabled(false);
			this.button_Step2Rightside.setEnabled(false);
			this.button_Step2Leftside.setEnabled(false);
			this.button_Step3Service.setEnabled(false);
			this.button_Step3Return.setEnabled(false);
			
			button_Step2Return.setClickable(false);
			
			if(winner_red == true)
			{
			  //mySettings.setReturnRed(true);
			  mySettings.setFirstServiceTeam(Team.BLUE);
			  
			}
			else if(winner_blue == true)
			{
			  //mySettings.setReturnRed(false);
			  mySettings.setFirstServiceTeam(Team.RED);
			}
		}
		
		else if (clicked.getId() == this.button_Step2Leftside.getId()) 
		{
			this.button_Step2Rightside.setEnabled(false);
			this.button_Step2Service.setEnabled(false);
			this.button_Step2Return.setEnabled(false);
			this.button_Step3Leftside.setEnabled(false);
			this.button_Step3Rightside.setEnabled(false);
			
			button_Step2Leftside.setClickable(false);
			
			if(winner_red == true)
			{
			  //mySettings.setLeftSideRed(true);
			  mySettings.setBeginningSideLeft(Team.RED);
			  mySettings.setBeginningSideRight(Team.BLUE);
			  
			}
			else if(winner_blue == true)
			{
			  //mySettings.setLeftSideRed(false);
				mySettings.setBeginningSideLeft(Team.BLUE);
				mySettings.setBeginningSideRight(Team.RED);
			}
		}
		
		else if (clicked.getId() == this.button_Step2Rightside.getId()) 
		{
			this.button_Step2Leftside.setEnabled(false);
			this.button_Step2Service.setEnabled(false);
			this.button_Step2Return.setEnabled(false);
			this.button_Step3Leftside.setEnabled(false);
			this.button_Step3Rightside.setEnabled(false);
			
			button_Step2Rightside.setClickable(false);

			if(winner_red == true)
			{
			  //mySettings.setRightSideRed(true);
				mySettings.setBeginningSideRight(Team.RED);
				mySettings.setBeginningSideLeft(Team.BLUE);
			}
			else if(winner_blue == true)
			{
			  //mySettings.setRightSideRed(false);
				mySettings.setBeginningSideRight(Team.BLUE);
				mySettings.setBeginningSideLeft(Team.RED);
			}
		}
		
		else if (clicked.getId() == this.button_Step3Service.getId()) 
		{
			this.button_Step3Return.setEnabled(false);
			
			button_Step3Service.setClickable(false);
			
			if(winner_red == true)
			{
			  //mySettings.setServiceRed(true);
			  mySettings.setFirstServiceTeam(Team.RED);
			}
			else if(winner_blue == true)
			{
			  //mySettings.setServiceRed(false);
				mySettings.setFirstServiceTeam(Team.BLUE);
			}
		}
		
		else if (clicked.getId() == this.button_Step3Return.getId()) 
		{
			this.button_Step3Service.setEnabled(false);
			
			button_Step3Return.setClickable(false);
			
			if(winner_red == true)
			{
			  //mySettings.setReturnRed(true);
				mySettings.setFirstServiceTeam(Team.RED);
			}
			else if(winner_blue == true)
			{
			  //mySettings.setReturnRed(false);
				mySettings.setFirstServiceTeam(Team.BLUE);
			}
		}
		
		else if (clicked.getId() == this.button_Step3Leftside.getId()) 
		{
			this.button_Step3Rightside.setEnabled(false);
			
			button_Step3Leftside.setClickable(false);
			
			if(winner_red == true)
			{
			  //mySettings.setLeftSideRed(true);
			  mySettings.setBeginningSideLeft(Team.RED);
		      mySettings.setBeginningSideRight(Team.BLUE);
			}
			else if(winner_blue == true)
			{
			  //mySettings.setLeftSideRed(false);
			  mySettings.setBeginningSideLeft(Team.BLUE);
		      mySettings.setBeginningSideRight(Team.RED);
			}
		}
		
		else if (clicked.getId() == this.button_Step3Rightside.getId()) 
		{
			this.button_Step3Leftside.setEnabled(false);
			
			this.button_Step3Rightside.setClickable(false);
			
			if(winner_red == true)
			{
			  //mySettings.setRightSideRed(true);
			  mySettings.setBeginningSideRight(Team.RED);
			  mySettings.setBeginningSideLeft(Team.BLUE);
			}
			else if(winner_blue == true)
			{
			  //mySettings.setRightSideRed(false);
			  mySettings.setBeginningSideRight(Team.BLUE);
			  mySettings.setBeginningSideLeft(Team.RED);
			}
		}
		
		else if (clicked.getId() == this.button_PlayerRed1.getId()) 
		{
			this.button_PlayerRed2.setEnabled(false);
			//mySettings.setServicePlayer1_red(true);
			mySettings.setFirstServicePlayerRed(Player.ONE);
			this.button_PlayerRed2.setClickable(false);
		}
		
		else if (clicked.getId() == this.button_PlayerRed2.getId()) 
		{
			this.button_PlayerRed1.setEnabled(false);
			//mySettings.setServicePlayer2_red(true);
			mySettings.setFirstServicePlayerRed(Player.TWO);
			this.button_PlayerRed2.setClickable(false);
		}
		
		else if (clicked.getId() == this.button_PlayerBlue1.getId()) 
		{
			this.button_PlayerBlue2.setEnabled(false);
			//mySettings.setServicePlayer1_red(false);
			mySettings.setFirstServicePlayerBlue(Player.ONE);
			this.button_PlayerBlue1.setClickable(false);
		}
		
		else if (clicked.getId() == this.button_PlayerBlue2.getId()) 
		{
			this.button_PlayerBlue1.setEnabled(false);
			//mySettings.setServicePlayer2_red(false);
			mySettings.setFirstServicePlayerBlue(Player.TWO);
			this.button_PlayerBlue2.setClickable(false);
		}
	}

}
