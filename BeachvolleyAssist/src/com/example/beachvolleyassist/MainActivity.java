package com.example.beachvolleyassist;

import com.example.beachvolleyassist.Settings.Player;
import com.example.beachvolleyassist.Settings.Team;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener 
{
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
	
	int timeoutleft_red = 2;
	int timeoutleft_blue = 2;
	
	boolean ball_red_player1 = true;
	boolean ball_blue_player1 = true;
	
	int redSet = 0;
	int blueSet = 0;
	
	boolean finish_red = false;
	boolean finish_blue = false;
	
	boolean first_service_red = true;
	boolean first_service_blue = true;
	
	boolean switched = false;
	
	Settings mySettings;
	
	private TextView textView_TeamBlueName;
	private TextView textView_TeamRedName;
	private TextView textView_TeamBluePlayer1;
	private TextView textView_TeamBluePlayer2;
	private TextView textView_TeamRedPlayer1;
	private TextView textView_TeamRedPlayer2;
	
	private ImageView imageView_Timeout1_Red;
	private ImageView imageView_Timeout2_Red;
	private ImageView imageView_Timeout1_Blue;
	private ImageView imageView_Timeout2_Blue;
	
	private ImageView imageView_Ball1_Red;
	private ImageView imageView_Ball2_Red;
	private ImageView imageView_Ball1_Blue;
	private ImageView imageView_Ball2_Blue;
	
	private RatingBar rb_blue;
	private RatingBar rb_red;
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		ActivityRegistry.register(this);
		
		setContentView(R.layout.mainactivity);
		
		mySettings = (Settings) getApplication();
		
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
		textView_TeamBlueName.setText(mySettings.getTeamBlueName());
		
		textView_TeamRedName = (TextView) this.findViewById(R.id.textTeamRedName);
		textView_TeamRedName.setText(mySettings.getTeamRedName());
		
		textView_TeamBluePlayer1 = (TextView) this.findViewById(R.id.textPlayer1Blue);
		textView_TeamBluePlayer1.setText(mySettings.getTeamBluePlayer1());
		
		textView_TeamBluePlayer2 = (TextView) this.findViewById(R.id.textPlayer2Blue);
		textView_TeamBluePlayer2.setText(mySettings.getTeamBluePlayer2());
		
		textView_TeamRedPlayer1 = (TextView) this.findViewById(R.id.textPlayer1Red);
		textView_TeamRedPlayer1.setText(mySettings.getTeamRedPlayer1());
		
		textView_TeamRedPlayer2 = (TextView) this.findViewById(R.id.textPlayer2Red);
		textView_TeamRedPlayer2.setText(mySettings.getTeamRedPlayer2());
		
		imageView_Timeout1_Red = (ImageView) findViewById(R.id.viewTimeoutRed1);
		imageView_Timeout2_Red = (ImageView) findViewById(R.id.viewTimeoutRed2);
		imageView_Timeout1_Blue = (ImageView) findViewById(R.id.viewTimeoutBlue1);
		imageView_Timeout2_Blue = (ImageView) findViewById(R.id.viewTimeoutBlue2);
		
		imageView_Ball1_Red = (ImageView) findViewById(R.id.viewBallRed1);
		imageView_Ball2_Red = (ImageView) findViewById(R.id.viewBallRed2);
		imageView_Ball1_Blue = (ImageView) findViewById(R.id.viewBallBlue1);
		imageView_Ball2_Blue = (ImageView) findViewById(R.id.viewBallBlue2);
		
		imageView_Ball1_Red.setVisibility(View.INVISIBLE);
		imageView_Ball2_Red.setVisibility(View.INVISIBLE);
		imageView_Ball1_Blue.setVisibility(View.INVISIBLE);
		imageView_Ball2_Blue.setVisibility(View.INVISIBLE);
		
		rb_red  = (RatingBar) findViewById(R.id.ratingBarRed);
		rb_blue = (RatingBar) findViewById(R.id.ratingBarBlue);	
	      
		if (mySettings.getBeginningSideLeft() == Team.BLUE)
		{	
			changeLayoutStart();
		}
		else if(mySettings.getBeginningSideRight() == Team.RED)
		{
			changeLayoutStart();
		}
		
		if (mySettings.getFirstServiceTeam() == Team.RED)
		{
		    if (mySettings.getFirstServicePlayerRed() == Player.ONE)
		    {
		    	imageView_Ball1_Red.setVisibility(View.VISIBLE);
				imageView_Ball2_Red.setVisibility(View.INVISIBLE);
				imageView_Ball1_Blue.setVisibility(View.INVISIBLE);
				imageView_Ball2_Blue.setVisibility(View.INVISIBLE);
				
				ball_red_player1 = true;
		    }
		    else
		    {
		    	imageView_Ball1_Red.setVisibility(View.INVISIBLE);
				imageView_Ball2_Red.setVisibility(View.VISIBLE);
				imageView_Ball1_Blue.setVisibility(View.INVISIBLE);
				imageView_Ball2_Blue.setVisibility(View.INVISIBLE);
				
				ball_red_player1 = false;
		    }
		    
		}
		else // First service -> Team.BLUE
		{
			if (mySettings.getFirstServicePlayerBlue() == Player.ONE)
		    {
		    	imageView_Ball1_Red.setVisibility(View.INVISIBLE);
				imageView_Ball2_Red.setVisibility(View.INVISIBLE);
				imageView_Ball1_Blue.setVisibility(View.VISIBLE);
				imageView_Ball2_Blue.setVisibility(View.INVISIBLE);
				
				ball_blue_player1 = true;
		    }
		    else
		    {
		    	imageView_Ball1_Red.setVisibility(View.INVISIBLE);
				imageView_Ball2_Red.setVisibility(View.INVISIBLE);
				imageView_Ball1_Blue.setVisibility(View.INVISIBLE);
				imageView_Ball2_Blue.setVisibility(View.VISIBLE);
				
				ball_blue_player1 = false;
		    }
		}	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
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
			switched = false;
			
			this.red = true;
			
			if(counterRed >= 21 && counterBlue < (counterRed - 1))
			{
				redSet++;
				rb_red.setRating(redSet);
				
				if(redSet >= 2)
				{
					dlgAlert.setMessage("'Team RED' win the game!");
					dlgAlert.setTitle("Congratulation");
					dlgAlert.setPositiveButton("OK", null);
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();
					
					button_Red.setEnabled(false);
					button_Blue.setEnabled(false);
				    button_TimeoutRed.setEnabled(false);
					button_TimeoutBlue.setEnabled(false);
				}
				else
				{
					dlgAlert.setMessage("'Team RED' win this set!");
					dlgAlert.setTitle("Congratulation");
					dlgAlert.setPositiveButton("OK", null);
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();
					setAllNull();
				}
				
				first_service_red = true;
				first_service_blue = true;
				finish_red = true;
			}
			else if(((counterRed + counterBlue) % 7) == 0)
			{
				changeLayoutDialoge();
				changeLayout();
			}
			
			if(ball_red_player1 == true)
			{
		        imageView_Ball1_Red.setVisibility(View.VISIBLE);
			    imageView_Ball2_Red.setVisibility(View.INVISIBLE);
			    imageView_Ball1_Blue.setVisibility(View.INVISIBLE);
			    imageView_Ball2_Blue.setVisibility(View.INVISIBLE);
			  
			    if(first_service_red == true)
			    {
			      first_service_red = false;
			    }
			    else
			    {
			      ball_blue_player1 = true;
			    }
			}
			else if(ball_red_player1 == false)
			{
		        imageView_Ball2_Red.setVisibility(View.VISIBLE);
			    imageView_Ball1_Red.setVisibility(View.INVISIBLE);
			    imageView_Ball1_Blue.setVisibility(View.INVISIBLE);
			    imageView_Ball2_Blue.setVisibility(View.INVISIBLE);
			  
			    if(first_service_red == true)
			    {
			      first_service_red = false;
			    }
			    else
			    {
			      ball_blue_player1 = true;
			    }
			}
		} 
		else if (clicked.getId() == this.button_Blue.getId())
		{
			this.counterBlue += 1;
			this.button_Blue.setText(Integer.toString(counterBlue));
			
			this.blue = true;
			
			if(counterBlue >= 21 && counterRed < (counterBlue - 1))
			{					
				blueSet++;
				rb_blue.setRating(blueSet);
				switched = false;
				
				if(blueSet >= 2)
				{
					dlgAlert.setMessage("'Team BLUE' win the game!");
					dlgAlert.setTitle("Congratulation");
					dlgAlert.setPositiveButton("OK", null);
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();
					
					button_Red.setEnabled(false);
					button_Blue.setEnabled(false);
				    button_TimeoutRed.setEnabled(false);
					button_TimeoutBlue.setEnabled(false);
				}
				else
				{
					dlgAlert.setMessage("'Team BLUE' win this set!");
					dlgAlert.setTitle("Congratulation");
					dlgAlert.setPositiveButton("OK", null);
					dlgAlert.setCancelable(false);
					dlgAlert.create().show();
					setAllNull();
				}
				
				finish_blue = true;
				first_service_red = true;
				first_service_blue = true;
			  }
			  else if(((counterRed + counterBlue) % 7) == 0)
			  {
				changeLayoutDialoge();
				changeLayout();
			  }
			
			if(ball_blue_player1 == true)
			{
		      imageView_Ball1_Blue.setVisibility(View.VISIBLE);
			  imageView_Ball1_Red.setVisibility(View.INVISIBLE);
			  imageView_Ball2_Red.setVisibility(View.INVISIBLE);
			  imageView_Ball2_Blue.setVisibility(View.INVISIBLE);
			  
			  if(first_service_blue == true)
			  {
		        first_service_blue = false;
			  }
			  else
			  {
			    ball_red_player1 = false;
			  }
			}
			else if(ball_blue_player1 == false)
			{
		      imageView_Ball2_Blue.setVisibility(View.VISIBLE);
			  imageView_Ball1_Red.setVisibility(View.INVISIBLE);
			  imageView_Ball2_Red.setVisibility(View.INVISIBLE);
			  imageView_Ball1_Blue.setVisibility(View.INVISIBLE);
			  
			  if(first_service_blue == true)
			  {
			    first_service_blue = false;
			  }
			  else
			  {
			    ball_red_player1 = true;
			  }
			}
		}
		else if(clicked.getId() == this.button_Cancel.getId())
		{	
			dlgAlert.setMessage("Do you really want to cancel the game?");
			dlgAlert.setTitle("Cancle game");
			dlgAlert.setCancelable(false);
			
			dlgAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() 
			{
				public void onClick(DialogInterface dialog, int id) 
				{
					// if this button is clicked then change to start activity
					
					// new Intent
					Intent start_activity = new Intent(getApplicationContext(), StartActivity.class);
					
					// Start Intent and switch to StartActivity
					startActivity(start_activity);
				}
			});
			  
			dlgAlert.setNegativeButton("No",new DialogInterface.OnClickListener() 
			{
				public void onClick(DialogInterface dialog,int id) 
				{
					// if this button is clicked, just close the dialog box and do nothing
					dialog.cancel();
				}
			});
				
			dlgAlert.create().show();			
		}
		else if(clicked.getId() == this.button_Undo.getId())
		{
			if(finish_red == true || finish_blue == true)
			{
				makeUndo();
				
				if(timeoutleft_red != 0)
				{
				   button_TimeoutRed.setEnabled(true);
				}
				
				if(timeoutleft_blue != 0)
				{
				  button_TimeoutBlue.setEnabled(true);
				}

				button_Red.setEnabled(true);
				button_Blue.setEnabled(true);
				
				if(finish_red == true)
				{
				  redSet--;
				}
				else if(finish_blue == true)
				{
				  blueSet--;
				}
			}
			else
			{
				makeUndo();	
			}
		}
		else if(clicked.getId() == this.button_TimeoutRed.getId())
		{
			Team team = Team.RED;
			timeoutDialog(team);
			
			if(timeoutleft_red == 2)
			{
		      imageView_Timeout1_Red.setImageResource(R.drawable.ic_delete);
		      timeoutleft_red--;
			}
			else if(timeoutleft_red == 1)
			{
		      imageView_Timeout2_Red.setImageResource(R.drawable.ic_delete);
		      timeoutleft_red--;
			}
			
			if(timeoutleft_red == 0)
			{
				button_TimeoutRed.setEnabled(false);
			}
		}
		else if(clicked.getId() == this.button_TimeoutBlue.getId())
		{
			Team team = Team.BLUE;
			timeoutDialog(team);
			
			if(timeoutleft_blue == 2)
			{
		      imageView_Timeout1_Blue.setImageResource(R.drawable.ic_delete);
		      timeoutleft_blue--;
			}
			else if(timeoutleft_blue == 1)
			{
		      imageView_Timeout2_Blue.setImageResource(R.drawable.ic_delete);
		      timeoutleft_blue--;
			}
			
			if(timeoutleft_blue == 0)
			{
		      button_TimeoutBlue.setEnabled(false);
			}
		}	
	}
	
	private void makeUndo()
	{
		if(red == true)
		{
			counterRed--;
			button_Red.setText(Integer.toString(counterRed));
			red = false;
		}
		else if(blue == true)
		{
			counterBlue--;
			button_Blue.setText(Integer.toString(counterBlue));
			blue = false;
		}
		
		if(switched == true)
		{
		    changeLayoutDialoge();
		    changeLayout();
		}
		
		finish_red = false;
		finish_blue = false;
	}
	
	private void setAllNull() 
	{
	  counterRed = 0;
	  counterBlue = 0;
		
	  red = false;
	  blue = false;
		
	  timeoutleft_red = 2;
	  timeoutleft_blue = 2;
		
	  ball_red_player1 = true;
      ball_blue_player1 = true;
	  
	  button_Blue.setText(Integer.toString(counterBlue));
	  button_Red.setText(Integer.toString(counterRed));
	  
      button_TimeoutRed.setEnabled(true);
	  button_TimeoutBlue.setEnabled(true);
	  
	  imageView_Timeout1_Red.setImageResource(R.drawable.ic_media_pause);
	  imageView_Timeout2_Red.setImageResource(R.drawable.ic_media_pause);
	  imageView_Timeout1_Blue.setImageResource(R.drawable.ic_media_pause);
	  imageView_Timeout2_Blue.setImageResource(R.drawable.ic_media_pause);
	}

	@SuppressLint("NewApi")
	private void changeLayoutStart() 
	{
	  layout_red.setX(240);
	  layout_red.setY(0);
		
	  layout_blue.setX(-240);
	  layout_blue.setY(0);
	}
	
	private void changeLayoutDialoge()
	{
	  AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
	  
	  dlgAlert.setMessage("Change the sides");
	  dlgAlert.setPositiveButton("OK", null);
	  dlgAlert.setCancelable(false);
	  
	  dlgAlert.create().show();
	}
	
	@SuppressLint("NewApi")
	private void changeLayout()
	{ 
  	  float red_x = layout_red.getX();
	  float red_y = layout_red.getY();
	  float blue_x = layout_blue.getX();
	  float blue_y = layout_blue.getY();
			
	  layout_red.setX(blue_x);
	  layout_red.setY(blue_y);
	  layout_blue.setX(red_x);
      layout_blue.setY(red_y);
      
      switched = true;
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void timeoutDialog(Team team)
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
		
		new CountDownTimer(3000, 1000)
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