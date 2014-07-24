package com.abc.insynergy;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class Assessment extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_assessment);
		// Show the Up button in the action bar.
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
        
        TextView benoHead = (TextView) findViewById(R.id.benoHead);
        benoHead.setTypeface(fontReg);
        TextView impNameHead = (TextView) findViewById(R.id.impNameHead);
        impNameHead.setTypeface(fontReg);
        TextView fsHead = (TextView) findViewById(R.id.fsHead);
        fsHead.setTypeface(fontReg);
		
        
        TableLayout t1 = (TableLayout)findViewById(R.id.tableView1);
        for(int i = 0;i < 25;i++){
        	TableRow tr1 = new TableRow(this);
        	tr1.setId(i);
        	tr1.setWeightSum(6);
        	TableLayout.LayoutParams tableRowParams=
        			  new TableLayout.LayoutParams
        			  (LayoutParams.MATCH_PARENT, 64);
        	tableRowParams.setMargins(0, 6, 0, 0);
        	tr1.setLayoutParams(tableRowParams);
        	tr1.setBackgroundResource(R.drawable.shapes);
        	TextView beno = new TextView(this);
            beno.setText(String.valueOf(i+1));
            beno.setGravity(Gravity.CENTER);
            beno.setTextSize(28);
            beno.setTypeface(fontLight);
            TextView imp_name = new TextView(this);
            imp_name.setText("cust"+i);
            imp_name.setGravity(Gravity.CENTER);
            imp_name.setTextSize(28);
            imp_name.setTypeface(fontLight);
            TextView fs = new TextView(this);
            fs.setText("F");
            fs.setGravity(Gravity.CENTER);
            fs.setTextSize(28);
            fs.setTypeface(fontLight);
            TableRow.LayoutParams col1Params = new TableRow.LayoutParams();
            col1Params.height = LayoutParams.WRAP_CONTENT;
            col1Params.width = 0;
            col1Params.weight = 1.25f;
            TableRow.LayoutParams col2Params = new TableRow.LayoutParams();
            col2Params.height = LayoutParams.WRAP_CONTENT;
            col2Params.width = 0;
            col2Params.weight = 3.75f;
            TableRow.LayoutParams col3Params = new TableRow.LayoutParams();
            col3Params.height = LayoutParams.WRAP_CONTENT;
            col3Params.width = 0;
            col3Params.weight = 1f;
            tr1.addView(beno, col1Params);
            tr1.addView(imp_name, col2Params);
            tr1.addView(fs, col3Params);
            tr1.setClickable(true);
            tr1.setOnClickListener(tablerowOnClickListener);
            t1.addView(tr1);
        }
	}
	
	private OnClickListener tablerowOnClickListener = new OnClickListener() {
        public void onClick(View v) {
            //GET TEXT HERE
        	int id = v.getId();
        	TableRow tr1 = (TableRow) findViewById(id);
        	tr1.setBackgroundResource(R.drawable.shapes_clicked);
        	Context context = getApplicationContext();
			Intent intent = new Intent(context, EntryForm.class);
			startActivity(intent);
        }
    };

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
