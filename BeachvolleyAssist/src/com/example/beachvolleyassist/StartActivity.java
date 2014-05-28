package com.example.beachvolleyassist;

import com.example.beachvolleyassist.R.layout;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class StartActivity extends Activity implements OnClickListener {

	private Button button_Start;
	private Button button_Exit;

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    
		super.onCreate(savedInstanceState);
		ActivityRegistry.register(this);
		
		setContentView(R.layout.startactivity);
		
		this.button_Start = (Button) this.findViewById(R.id.buttonStort);
		this.button_Exit = (Button) this.findViewById(R.id.buttonExit);
		
		this.button_Start.setOnClickListener(this);
		this.button_Exit.setOnClickListener(this);
		
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
		
		if (clicked.getId() == this.button_Start.getId()) 
		{
			//AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
			//dlgAlert.setMessage("Button START pressed");
			//dlgAlert.create().show();
			
			// new Intent
            Intent main_activity = new Intent(getApplicationContext(), MainActivity.class);

            //Intent mit den Daten füllen
            //settings_activity.putExtra("Vorname", inputVorname.getText().toString());
            //settings_activity.putExtra("Nachname", inputNachname.getText().toString());

            // Intent starten und zur zweiten Activity wechseln
            startActivity(main_activity);
		}
		
		else if (clicked.getId() == this.button_Exit.getId())
		{
			AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
			
			dlgAlert.setMessage("Do you really want to exit Beachvollay Assist?");
			dlgAlert.setTitle("Exit Beachvolley Assist");
			dlgAlert.setCancelable(false);
			
			dlgAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					// if this button is clicked, close current activity
					//App.close();
					//finish();
					ActivityRegistry.finishAll();
					//finish();
				}
			});
			  
			dlgAlert.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close
					// the dialog box and do nothing
					dialog.cancel();
				}
			});
				
			dlgAlert.create().show();
			
		}
			
		
	}

}
