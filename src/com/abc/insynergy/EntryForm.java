package com.abc.insynergy;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class EntryForm extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entry_form);
		
		setupActionBar();
		
		ActionBar ab = getActionBar(); 
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#0F1F4C"));     
        ab.setBackgroundDrawable(colorDrawable);
        
      //Adding slide-in and slide-out animation
       // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
        Typeface fontLight = Typeface.createFromAsset(getAssets(), "fonts/RobotoCondensed-Light.ttf");
        Typeface fontReg = Typeface.createFromAsset(getAssets(), "fonts/RobotoCondensed-Regular.ttf");
        
        int actionBarTitle = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        TextView actionBarTitleView = (TextView) getWindow().findViewById(actionBarTitle);
        if(actionBarTitleView != null){
            actionBarTitleView.setTypeface(fontReg);
        }
        
        Button assess = (Button) findViewById(R.id.save);
        Button enq = (Button) findViewById(R.id.cancel);
        assess.setTypeface(fontReg);
        enq.setTypeface(fontReg);
        
        TextView total = (TextView) findViewById(R.id.total);
        total.setText("TOTAL : 9373");
        total.setTypeface(fontReg);
        
        TextView totalFiling = (TextView) findViewById(R.id.totalFiling);
        totalFiling.setText("Today's Filing : 3773");
        totalFiling.setTypeface(fontReg);
        
        TextView fileUnderFC = (TextView) findViewById(R.id.fileUnderFC);
        fileUnderFC.setText("Files Under FC : 1073");
        fileUnderFC.setTypeface(fontReg);
        
        TextView fileUnderSC = (TextView) findViewById(R.id.fileUnderSC);
        fileUnderSC.setText("Files Under SC : 2073");
        fileUnderSC.setTypeface(fontReg);
        
        TextView name = (TextView) findViewById(R.id.name);
        name.setText("Name : InSynergy");
        name.setTypeface(fontReg);
        
        TextView benoDate = (TextView) findViewById(R.id.benoDate);
        benoDate.setText("BE No. & Date : 2073");
        benoDate.setTypeface(fontReg);
        
        TextView goods = (TextView) findViewById(R.id.goods);
        goods.setText("Goods : 12");
        goods.setTypeface(fontReg);
        
        TextView grossWeight = (TextView) findViewById(R.id.grossWeight);
        grossWeight.setText("Gross Weight : 30 lbs");
        grossWeight.setTypeface(fontReg);
        
        TextView presentStatus = (TextView) findViewById(R.id.presentStatus);
        presentStatus.setText("Present Status : In Process");
        presentStatus.setTypeface(fontReg);
        
        TextView packages = (TextView) findViewById(R.id.packages);
        packages.setText("Packages : 32");
        packages.setTypeface(fontReg);
        
        TextView dutyAmount = (TextView) findViewById(R.id.dutyAmount);
        dutyAmount.setTypeface(fontReg);
        
        EditText amount = (EditText) findViewById(R.id.amount);
        amount.setTypeface(fontLight);
        
        Switch inRMS = (Switch) findViewById(R.id.inRMS);
        inRMS.setTypeface(fontReg);
        Switch underFirstCheck = (Switch) findViewById(R.id.underFirstCheck);
        underFirstCheck.setTypeface(fontReg);
        Switch finalAssessed = (Switch) findViewById(R.id.finalAssessed);
        finalAssessed.setTypeface(fontReg);
        finalAssessed.setChecked(true);
        Switch provAssessed = (Switch) findViewById(R.id.provAssessed);
        provAssessed.setTypeface(fontReg);
        Switch dutyChanged = (Switch) findViewById(R.id.dutyChanged);
        dutyChanged.setTypeface(fontReg);
        dutyChanged.setChecked(true);
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
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
