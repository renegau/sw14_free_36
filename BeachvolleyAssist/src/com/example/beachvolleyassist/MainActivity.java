package com.example.beachvolleyassist;

import com.example.beachvolleyassist.R.layout;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener {

	private Button button_Red;
	private Button button_Blue;
	private Button button_Cancel;
	private Button button_Undo;
	private Button button_TimeoutRed;
	private Button button_TimeoutBlue;
	
	private LinearLayout layout_red;
	private LinearLayout layout_blue;
	
	int counterRed = 0;
	int counterBlue = 0;
	boolean red = false;
	boolean blue = false;
	
	Settings settings;
	
	private TextView textView_TeamBlueName;
	private TextView textView_TeamRedName;
	private TextView textView_TeamBluePlayer1;
	private TextView textView_TeamBluePlayer2;
	private TextView textView_TeamRedPlayer1;
	private TextView textView_TeamRedPlayer2;
	
	public enum Team
	{
	  RED, BLUE
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		ActivityRegistry.register(this);
		
		setContentView(R.layout.mainactivity);
		
		settings = (Settings) getApplication();
		
		this.button_Red = (Button) this.findViewById(R.id.buttonRed);
		this.button_Blue = (Button) this.findViewById(R.id.buttonBlue);
		this.button_Cancel = (Button) this.findViewById(R.id.buttonCancel);
		this.button_Undo = (Button) this.findViewById(R.id.buttonUndo);
		this.button_TimeoutRed = (Button) this.findViewById(R.id.buttonTimeoutRed);
		this.button_TimeoutBlue = (Button) this.findViewById(R.id.buttonTimeoutBlue);
		
		this.layout_red = (LinearLayout) this.findViewById(R.id.LayoutRed);
		this.layout_blue = (LinearLayout) this.findViewById(R.id.LayoutBlue);
		
		this.button_Red.setOnClickListener(this);
		this.button_Blue.setOnClickListener(this);
		this.button_Cancel.setOnClickListener(this);
		this.button_Undo.setOnClickListener(this);
		this.button_TimeoutRed.setOnClickListener(this);
		this.button_TimeoutBlue.setOnClickListener(this);
		
		textView_TeamBlueName = (TextView) this.findViewById(R.id.textTeamBlueName);
		textView_TeamBlueName.setText(settings.getTeamBlueName());
		
		textView_TeamRedName = (TextView) this.findViewById(R.id.textTeamRedName);
		textView_TeamRedName.setText(settings.getTeamRedName());
		
		textView_TeamBluePlayer1 = (TextView) this.findViewById(R.id.textPlayer1Blue);
		textView_TeamBluePlayer1.setText(settings.getTeamBluePlayer1());
		
		textView_TeamBluePlayer2 = (TextView) this.findViewById(R.id.textPlayer2Blue);
		textView_TeamBluePlayer2.setText(settings.getTeamBluePlayer2());
		
		textView_TeamRedPlayer1 = (TextView) this.findViewById(R.id.textPlayer1Red);
		textView_TeamRedPlayer1.setText(settings.getTeamRedPlayer1());
		
		textView_TeamRedPlayer2 = (TextView) this.findViewById(R.id.textPlayer2Red);
		textView_TeamRedPlayer2.setText(settings.getTeamRedPlayer2());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onClick(View view) 
	{
		Button clicked = (Button) view;
		AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

		if (clicked.getId() == this.button_Red.getId()) 
		{
			this.counterRed += 1;
			this.button_Red.setText(Integer.toString(counterRed));
			
			this.red = true;
			
			if(counterRed >= 21 && counterBlue < (counterRed - 1))
			{
				dlgAlert.setMessage("'Team RED' win the game");
				dlgAlert.setTitle("Congratulation");
				dlgAlert.setPositiveButton("OK", null);
				dlgAlert.setCancelable(false);
				dlgAlert.create().show();
				
				button_Red.setEnabled(false);
				button_Blue.setEnabled(false);
			}
			
			else if(((counterRed + counterBlue) % 7) == 0)
			{
				changeLayout();
			}
		} 
		
		else if (clicked.getId() == this.button_Blue.getId())
		{
			this.counterBlue += 1;
			this.button_Blue.setText(Integer.toString(counterBlue));
			
			this.blue = true;
			
			if(counterBlue >= 21 && counterRed < (counterBlue - 1))
			{	
				dlgAlert.setMessage("'Team BLUE' win the game");
				dlgAlert.setTitle("Congratulation");
				dlgAlert.setPositiveButton("OK", null);
				dlgAlert.setInverseBackgroundForced(true);
				dlgAlert.setCancelable(false);
				dlgAlert.create().show();
				
				button_Red.setEnabled(false);
				button_Blue.setEnabled(false);
			}
			
			else if(((counterRed + counterBlue) % 7) == 0)
			{
				changeLayout();
			}
		}
		
		else if(clicked.getId() == this.button_Cancel.getId())
		{
						
			dlgAlert.setMessage("Do you really want to cancel the game?");
			dlgAlert.setTitle("Cancle game");
			dlgAlert.setCancelable(false);
			
			dlgAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					// if this button is clicked then change to start activity
					
					// new Intent
					Intent start_activity = new Intent(getApplicationContext(), StartActivity.class);
					
					// Start Intent und switch to StartActivity
					startActivity(start_activity);
				}
			});
			  
			dlgAlert.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close the dialog box and do nothing
					dialog.cancel();
				}
			});
				
			dlgAlert.create().show();
			
		}
		
		else if(clicked.getId() == this.button_Undo.getId())
		{
			if(red == true)
			{
				this.counterRed -= 1;
				this.button_Red.setText(Integer.toString(counterRed));
				this.red = false;
			}
			else if(blue == true)
			{
				this.counterBlue -= 1;
				this.button_Blue.setText(Integer.toString(counterBlue));
				this.blue = false;
			}
		}
		
		else if(clicked.getId() == this.button_TimeoutRed.getId())
		{
			Team team = Team.RED;
			timeoutDialog(team);
		}
		
		else if(clicked.getId() == this.button_TimeoutBlue.getId())
		{
			Team team = Team.BLUE;
			timeoutDialog(team);
		}
		
		
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void changeLayout()
	{
	  AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
	  
	  dlgAlert.setMessage("Change the sides");
	  dlgAlert.setPositiveButton("OK", null);
	  dlgAlert.setCancelable(false);
	  
	  dlgAlert.create().show();
	  
  	  float red_x = layout_red.getX();
	  float red_y = layout_red.getY();
	  float blue_x = layout_blue.getX();
	  float blue_y = layout_blue.getY();
			
	  layout_red.setX(blue_x);
	  layout_red.setY(blue_y);
	  layout_blue.setX(red_x);
      layout_blue.setY(red_y);     
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void timeoutDialog(Team team)
	{
		final AlertDialog timeoutDialog = new AlertDialog.Builder(this).create();
		
		//final String space = "                 ";
		
		if (team == Team.RED)
		{
			timeoutDialog.setTitle("Timeout 'Team RED'");
		}
		else if (team == Team.BLUE)
		{
			timeoutDialog.setTitle("Timeout 'Team BLUE'");
		}
		
		timeoutDialog.setMessage("30 seconds left");
		timeoutDialog.setCancelable(false);
		timeoutDialog.show();
		
		new CountDownTimer(30000, 1000) 
		{
		    public void onTick(long milliSeconds) 
		    {
		       timeoutDialog.setMessage((milliSeconds/1000) + " seconds left");
		    }

		    public void onFinish() 
		    {
		    	timeoutDialog.cancel();
		    }
		}.start();
	}
}