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
				"Java 2 \r\n\n" +
				"AutoMobile App \r\n" +
				"Find Basic information via a vehicle VIN number \r\n");
        
        
        //My button to return back to MainActivity
        
        Button B1 = (Button) findViewById(R.id.button1);
    	B1.setOnClickListener(new OnClickListener() 
    	{
    		
    		@Override
    		public void onClick(View v) 
    		{
    			// info page button
    			Intent intent = new Intent(InfoPage.this, MainActivity.class);
    			    			
    			//Pass back this data to the MainActivity
    			intent.setData(Uri.parse("Cars are awesome"));
    			//startActivityForResult(intent, 1);
    			
    			setResult(RESULT_OK, intent);
    			Log.i("EXPLICIT", "String sent");
    			
    			finish();
    		}
    	});
        
        
        //When clicking button 2, should use implicit intent to activate web page
        Button B2 = (Button) findViewById(R.id.btnImplicit);
    	B2.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) 
    		{
    			//URl is passed from the MainActivity from the Public void onclick method
    			Intent internetIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(getIntent().getExtras().getString("API")));
     	 		Log.i("API TXT", getIntent().getExtras().getString("API"));
     	 		
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

}