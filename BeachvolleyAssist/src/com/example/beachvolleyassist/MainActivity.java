package com.example.beachvolleyassist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.AlertDialog;

public class MainActivity extends Activity implements OnClickListener {

	private Button button_Red;
	private Button button_Blue;
	
	int counterRed = 0;
	int counterBlue = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainactivity);

		this.button_Red = (Button) this.findViewById(R.id.buttonRed);
		this.button_Blue = (Button) this.findViewById(R.id.buttonBlue);

		this.button_Red.setOnClickListener(this);
		this.button_Blue.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) 
	{
		Button clicked = (Button) view;
		AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

		if (clicked.getId() == this.button_Red.getId()) 
		{
			this.counterRed += 1;
			this.button_Red.setText(Integer.toString(counterRed));
			
			if(counterRed >= 21 && counterBlue < (counterRed - 1))
			{
				dlgAlert.setMessage("TEAM RED WIN THE GAME");
				dlgAlert.setTitle("CONGRATULATION");
				dlgAlert.setPositiveButton("OK", null);
				dlgAlert.create().show();
				
				button_Red.setEnabled(false);
				button_Blue.setEnabled(false);
			}
		} 
		
		else if (clicked.getId() == this.button_Blue.getId())
		{
			this.counterBlue += 1;
			this.button_Blue.setText(Integer.toString(counterBlue));
			
			if(counterBlue >= 21 && counterRed < (counterBlue - 1))
			{
				dlgAlert.setMessage("TEAM BLUE WIN THE GAME");
				dlgAlert.setTitle("CONGRATULATION");
				dlgAlert.setPositiveButton("OK", null);
				dlgAlert.create().show();
				
				button_Red.setEnabled(false);
				button_Blue.setEnabled(false);
			}
		} 
	}
}