/*
 * Project: AutoJava2
 * Package: com.jbetterly.auto2
 * @author: Joel Betterly
 * Date: 	May 8, 2013
 */
package com.jbetterly.auto2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
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
        tv.setText("Joel Betterly \r\n" +
				"Java 1 - Week 4 \r\n\n" +
				"AutoMobile App \r\n" +
				"Find Basic information via a vehicle VIN number \r\n");
        
        Button B1 = (Button) findViewById(R.id.button1);
    	B1.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// info page button
    			Intent intent = new Intent(InfoPage.this, MainActivity.class);
    			startActivity(intent);
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