package com.example.beachvolleyassist;

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

public class SettingsActivity extends Activity implements OnClickListener {

	private Button button_Ok;
	private Button button_Cancel;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		ActivityRegistry.register(this);
		
		setContentView(R.layout.settingsactivity);
		
		this.button_Ok = (Button) this.findViewById(R.id.buttonOk);
		this.button_Cancel = (Button) this.findViewById(R.id.buttonCancel);
		
		this.button_Ok.setOnClickListener(this);
		this.button_Cancel.setOnClickListener(this);
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
		
		if (clicked.getId() == this.button_Ok.getId()) 
		{			
			// new Intent
            Intent main_activity = new Intent(getApplicationContext(), MainActivity.class);

            //Set main_activity Intent with data
            //settings_activity.putExtra("Vorname", inputVorname.getText().toString());
            //settings_activity.putExtra("Nachname", inputNachname.getText().toString());

            // start Intent and change to MainActivity
            startActivity(main_activity);
		}
	}

}
