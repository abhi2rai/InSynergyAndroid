package com.abc.insynergy;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.MenuItem;
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
        
        TextView total = (TextView) findViewById(R.id.total);
        total.setText("TOTAL : 9373");
        
        TextView totalFiling = (TextView) findViewById(R.id.totalFiling);
        totalFiling.setText("Today's Filing : 3773");
        
        TextView fileUnderFC = (TextView) findViewById(R.id.fileUnderFC);
        fileUnderFC.setText("Files Under FC : 1073");
        
        TextView fileUnderSC = (TextView) findViewById(R.id.fileUnderSC);
        fileUnderSC.setText("Files Under SC : 2073");
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
