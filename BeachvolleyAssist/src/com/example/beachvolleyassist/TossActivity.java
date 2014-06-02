package com.example.beachvolleyassist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TossActivity extends Activity implements OnClickListener {

	Settings mySettings;
	
	private Button button_Next;
	private Button button_Cancel;
	
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		ActivityRegistry.register(this);
		
		setContentView(R.layout.tossactivity);
		
		mySettings = (Settings) getApplication();
		
		this.button_Next = (Button) this.findViewById(R.id.buttonNext);
		this.button_Cancel = (Button) this.findViewById(R.id.buttonCancel);
		
		this.button_Next.setOnClickListener(this);
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
		
		if (clicked.getId() == this.button_Next.getId()) 
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
