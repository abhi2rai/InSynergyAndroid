package com.abc.insynergy;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public final static String USR = "username";
	public final static String PWD = "password";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar ab = getActionBar(); 
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#0F1F4C"));     
        ab.setBackgroundDrawable(colorDrawable);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/** Called when the user clicks the Login button */
	public void logIn(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, ProfilePage.class);
		EditText username = (EditText) findViewById(R.id.username);
		EditText pwd = (EditText) findViewById(R.id.password);
		if(username.getText().toString().equals("arun") && pwd.getText().toString().equals("insynergy"))
		{
			intent.putExtra(USR, username.getText().toString());
			startActivity(intent);
		}
		else
		{
			//username.setText("");
			//pwd.setText("");
			Context context = getApplicationContext();
			CharSequence text = "Incorrect Credentials!";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}
	}

}
