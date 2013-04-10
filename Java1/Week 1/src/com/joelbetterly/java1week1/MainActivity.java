/*
 * Project: Java1Week1
 * Package: com.joelbetterly.java1week1
 * @author: Joel Betterly
 * Date: 	Apr 10, 2013
 * Added to git on Apr 10 1:38pm
 */
package com.joelbetterly.java1week1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;




public class MainActivity extends Activity
{

	//Global Variables
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	EditText et;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		//setup the linear layout
		ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		ll.setLayoutParams(lp);
		
		//Add the TextView
		TextView tv = new TextView(this);
		tv.setText("% based on Tips");
		ll.addView(et);
		
		//Add edit text for click event
		et = new EditText(this);
		et.setHint("Tip Amount");
		
		//Add Button for calculation
		Button b = new Button(this);
		b.setText("Get Tip");
		b.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// Setup Integers for each group
				int adult = getResources().getInteger(R.integer.adult);
				int teen = getResources().getInteger(R.integer.teen);
				int kid = getResources().getInteger(R.integer.kid);
				int tot = getResources().getInteger(R.integer.tot);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
