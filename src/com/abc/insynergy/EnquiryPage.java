package com.abc.insynergy;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class EnquiryPage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enquiry_page);
		// Show the Up button in the action bar.
		setupActionBar();
		
		ActionBar ab = getActionBar(); 
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#0F1F4C"));     
        ab.setBackgroundDrawable(colorDrawable);
        
        Typeface fontLight = Typeface.createFromAsset(getAssets(), "fonts/RobotoCondensed-Light.ttf");
        Typeface fontReg = Typeface.createFromAsset(getAssets(), "fonts/RobotoCondensed-Regular.ttf");
        
        int actionBarTitle = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        TextView actionBarTitleView = (TextView) getWindow().findViewById(actionBarTitle);
        if(actionBarTitleView != null){
            actionBarTitleView.setTypeface(fontReg);
        }
        EditText name = (EditText) findViewById(R.id.name);
        name.setTypeface(fontLight);
		EditText to = (EditText) findViewById(R.id.to);
		to.setTypeface(fontLight);
		EditText num = (EditText) findViewById(R.id.num);
		num.setTypeface(fontLight);
		EditText message = (EditText) findViewById(R.id.message);
		message.setTypeface(fontLight);
		Button send = (Button) findViewById(R.id.send);
        send.setTypeface(fontReg);
        
      //Adding slide-in and slide-out animation
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
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
	
	/** Called when the user clicks the Send button */
	public void sendEnquiry(View view) {
	    // Do something in response to button
		Context context = getApplicationContext();
		CharSequence text = "Message Sent";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

}
