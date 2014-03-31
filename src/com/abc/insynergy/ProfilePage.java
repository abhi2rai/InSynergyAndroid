package com.abc.insynergy;

import java.util.Date;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class ProfilePage extends Activity {
	
	public final boolean isInternetOn()
	{
	  ConnectivityManager connec = (ConnectivityManager)
	    getSystemService(Context.CONNECTIVITY_SERVICE);

	  // ARE WE CONNECTED TO THE NET
	  if ( connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
	       connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED )
	  {
	    return true;
	  }
	  else if ( connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED
	    ||  connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED  )
	  {
	    return false;
	  }

	  return false;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_page);
		// Show the Up button in the action bar.
		setupActionBar();
		
		//Set Action Bar to Custom Color
		ActionBar ab = getActionBar(); 
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#0F1F4C"));     
        ab.setBackgroundDrawable(colorDrawable);
        
        //Receive the Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.USR);
        
        //Set the User Profile Variables
        TextView userTxt = (TextView) findViewById(R.id.usr);
        userTxt.setText("Welcome, "+username+"!");
        userTxt.setTextSize(20);
        
        //Set Date
        Date dt = new Date();
        TextView date = (TextView) findViewById(R.id.date);
        date.setText(dt.toString().substring(0,11));
        
        //Getting Device Status
        ImageView image = (ImageView) findViewById(R.id.status);
        if(isInternetOn())
        {
        	image.setImageResource(R.drawable.online);
        }
        else
        {
        	image.setImageResource(R.drawable.offline);
        }
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
