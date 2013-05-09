/*
 * Project: AutoJava2
 * Package: com.jbetterly.auto2
 * @author: Joel Betterly
 * Date: 	May 8, 2013
 */
package com.jbetterly.auto2;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InfoPage extends Activity {

	TextView tv;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.infopage);
		
		tv = (TextView) findViewById(R.id.textView1);
		
		tv.setTextColor(Color.parseColor("#006633"));
		tv.setTextSize(18.f);
		
		//Basic information to display on top of page
        tv.setText("Joel Betterly \r\n" +
				"Java 1 - Week 4 \r\n\n" +
				"AutoMobile App \r\n" +
				"Find Basic information via a vehicle VIN number \r\n");
        
        
        //My button to return back to MainActivity
        
        Button B1 = (Button) findViewById(R.id.button1);
    	B1.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// info page button
    			Intent intent = new Intent(InfoPage.this, MainActivity.class);
    			startActivity(intent);
    		}
    	});
        
        
        //When clicking button 2, should use implicit intent to activate web page
        Button B2 = (Button) findViewById(R.id.btnImplicit);
    	B2.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) 
    		{

    			Intent internetIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(getIntent().getExtras().getString("API")));
     	 		Log.i("API txt", getIntent().getExtras().getString("API"));
     			 internetIntent.setComponent(new ComponentName("com.android.browser","com.android.browser.BrowserActivity"));
     			 internetIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     			 startActivity(internetIntent);
    			
    		}
    	});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//@Override  //for some reason IDE wont let me make this an overide method
	public void onMainPage() 
	{
		Intent intent = new Intent(InfoPage.this, MainActivity.class);
		intent.putExtra("OK",  "http://www.edmunson.com");
		startActivity(intent);
		
		//Set the data to pass back to MainActivity
		intent.setData(Uri.parse("Working!"));
		setResult(RESULT_OK, intent);
		
		
		//Close the activity
		finish();	
	
	}
}