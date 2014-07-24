package com.abc.insynergy;

import com.abc.insynergy.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static final String PREFS_NAME = "UserDetails";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
        
        EditText username = (EditText) findViewById(R.id.username);
        username.setTypeface(fontLight);
		EditText pwd = (EditText) findViewById(R.id.password);
		pwd.setTypeface(fontLight);
		Button login = (Button) findViewById(R.id.login);
        login.setTypeface(fontReg);
        
        String mPhoneNumber = getMobileNumber();    
        SharedPreferences sharedPreferences = getSharedPreferences("UserDetails",0);
        String userNumber = sharedPreferences.getString("userNumber", "UserNumber");
        
        if(mPhoneNumber != null){
        	if(mPhoneNumber.equals(userNumber)){
            	Intent intent = new Intent(this, ProfilePage.class);
            	savePreferences("userName","arun");
    			startActivity(intent);
            }
        }
        
	}
	public String getMobileNumber(){
		TelephonyManager tMgr = (TelephonyManager)getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
		return tMgr.getLine1Number();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
            	Intent intent = new Intent(this, SettingPage.class);
            	startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
	
	/** Called when the user clicks the Login button */
	public void logIn(View view) {
	    // Do something in response to button
		EditText username = (EditText) findViewById(R.id.username);
		EditText pwd = (EditText) findViewById(R.id.password);
		if(username.getText().toString().equals("arun") && pwd.getText().toString().equals("insynergy"))
		{
			String mPhoneNumber = getMobileNumber();
			createAlertDialogue(username.getText().toString(),mPhoneNumber);
		}
		else
		{
			username.setText("");
			pwd.setText("");
			Context context = getApplicationContext();
			CharSequence text = "Incorrect Credentials!";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}
	}
	
	public void savePreferences(String key, String value){
		SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,0);
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}
	
	public void createAlertDialogue(final String username,final String phonenumber){
		final Intent intent = new Intent(this, ProfilePage.class);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	        	   savePreferences("userNumber",phonenumber);
	       			savePreferences("accountLinked","true");
	       			savePreferences("userName",username);
	       			startActivity(intent);
	           }
	       });
		builder.setCancelable(false);
		builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	       		savePreferences("userName",username);
	       		startActivity(intent);
	           }
	       });
		Typeface fontLight = Typeface.createFromAsset(getAssets(), "fonts/RobotoCondensed-Light.ttf");
		TextView numDialog = new TextView(this);
		numDialog.setTypeface(fontLight);
		numDialog.setText("Primary number on device: \n"+phonenumber+"\n\nDo you want to link it" +
				" to the account?");
		numDialog.setTextSize(20);
		numDialog.setGravity(Gravity.CENTER_HORIZONTAL);
		builder.setView(numDialog);
		// create alert dialog
		AlertDialog alertDialog = builder.create();
		// show it
		alertDialog.show();
	}

}
