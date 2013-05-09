/*
 * Project: AutoJava2
 * Package: com.jbetterly.auto2
 * @author: Joel Betterly
 * Date: 	May 8, 2013
 */
package com.jbetterly.auto2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONException;

import android.os.Bundle;
import android.os.AsyncTask;

import android.app.Activity;
import android.app.AlertDialog;

import com.jbetterly.auto2.R;
import com.jbetterly.lib.FileStore;
import com.jbetterly.lib.WebChecks;
import android.net.Uri;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View.OnClickListener;


public class MainActivity extends Activity
{

	// GLobal Variables
	Context _context;
	Boolean _connected = false;
	TextView _vin;
	TextView _makeName;
	TextView _modelName;
	TextView _year;
	Intent intent;
	int request_code = 0;
	
	class CarInfo
	{
		String carURL = "null";
	}
	
	private CarInfo carInfo = new CarInfo();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button searchButton = (Button) findViewById(R.id.goButton);
		final EditText et = (EditText) findViewById(R.id.productField);
		_vin = (TextView) findViewById(R.id._vin);
		_makeName = (TextView) findViewById(R.id._makeName);
		_modelName = (TextView) findViewById(R.id._modelName);
		_year = (TextView) findViewById(R.id._year);

		searchButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// Check Network Status
				if (WebChecks.haveNetworkConnection(MainActivity.this))
				{
					Log.i("NETWORK CONNECTION", "Connection Available");
				}
				else
				{
					// No Network Connection Error

					Log.i("NETWORK CONNECTION", "Connection Unavailable");
					AlertDialog.Builder alt_bld2 = new AlertDialog.Builder(
							MainActivity.this);
					alt_bld2.setMessage("No Network Connection Detected")

							.setCancelable(false)
							.setPositiveButton("OK",
									new DialogInterface.OnClickListener()
									{
										public void onClick(
												DialogInterface dialog, int id)
										{

										}
									});

					AlertDialog alert = alt_bld2.create();

					// Title for AlertDialog
					alert.setTitle("Alert");

					// Icon for AlertDialog
					alert.setIcon(R.drawable.ic_launcher);
					alert.show();
				}

				Log.i("USER TYPED:", et.getText().toString());
				getCar(et.getText().toString());
			}
		});
		
		
		// button for about page.
		Button B = (Button) findViewById(R.id.infoPage);
		B.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				// info page button
				//Intent intent = new Intent(MainActivity.this, InfoPage.class);
				//startActivity(intent);
				
				/* This starts the implicit intent and pulls data from infoPage.java
				 * which allows the second button to pull data from the edmunds.com website  */
				
		    	Intent intent = new Intent(MainActivity.this, InfoPage.class);

		    	if(carInfo.carURL != "null")
		    	{
		    		intent.putExtra("API",  "http://www.edmunds.com/");
		    	}else
		    	{
		    		intent.putExtra("API",  "http://www.edmunds.com/");
		    	}
		    	startActivityForResult(intent,0);
				
			}
		});		
		

		// network detection - Create Methods to Detect Network Connectivity

		if (WebChecks.haveNetworkConnection(this))
		{
			Log.i("NETWORK CONNECTION", "Connection Established");
		}
		else
		{

			// No Network Connection Error

			Log.i("NETWORK CONNECTION", "Connection Lost");
			AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
			alt_bld.setMessage("No Network Connection Detected")
					.setCancelable(false)
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener()
							{
								public void onClick(DialogInterface dialog,
										int id)
								{

								}
							});

			AlertDialog alert = alt_bld.create();

			// Title for AlertDialog
			alert.setTitle("AlertDialogExample");

			// Icon for AlertDialog
			alert.setIcon(R.drawable.ic_launcher);
			alert.show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    //Creates URL from API
    
    private void getCar(String text){
    	Log.i("CLICK",text);
    	
    	String baseURL = "http://api.edmunds.com/api/v1/vehicle/vin/" + text + "/configuration?api_key=65hk4m7bhhxb3hz2hsvgf98z";
    	
    	URL finalURL;
    	try{
    		finalURL = new URL(baseURL);
    		Log.i("my url:", baseURL);
    		CarRequest cr = new CarRequest();
    		cr.execute(finalURL);
    		
    	} catch (MalformedURLException e){
    		Log.e("BAD URL", "MALFORMED URL", e);
    		finalURL = null;
    	}
    }
	
	
    //Function to get saved storage - log out when app launches.
    @SuppressWarnings("unused")
	private ArrayList<String> getSave() 
    {
		String stored = FileStore.readStringFile(_context, "temp", true);
		
		ArrayList<String> mySave = new ArrayList<String>();
		mySave.add("Select Saved");
		if(stored == null){
			Log.i("PROBLEM", "NO SAVED FILE FOUND");
		} else 
		{
			String[] saves = stored.split(",");
			for(int i=0; i<saves.length; i++)
			{
				mySave.add(saves[i]);
			}
		}
		return mySave;
	}

    //Call my API URL and update data that is shown in app. 
    
    public class CarRequest extends AsyncTask<URL, Void, String>{
    	
    	@Override
    	protected String doInBackground(URL... urls)
    	{
    		String response ="";
    		for(URL url: urls)
    		{
    			response = WebChecks.getURLStringResponse(url);
    		}
    		return response;
    	}
    	
    	@Override
    	protected void onPostExecute(String result)
    	{
    		Log.i("URL RESPONSE", result);
    		
    		try
    		{
				
    			JSONObject json = new JSONObject(result);

	    			String carMake = json.getJSONObject("make").getString("name");
	    			Log.i("MAKE", carMake.toString());
	    			String carModel = json.getJSONObject("model").getString("name");
	    			Log.i("MODEL", carModel.toString());
    			    String carYear = json.getString("year");
    			    Log.i("YEAR", carYear.toString());
    			    String carStyle = json.getString("vehicleStyle");
	    			Log.i("STYLE", carStyle.toString());
	    			
					String edmake = json.getJSONObject("make").getString("name");
					String edmodel = json.getJSONObject("model").getString("name");
					String edstyle = json.getString("vehicleStyle");
					String edyear = json.getString("year");
					
					carInfo.carURL = json.getString("vinModelGroup");

					_makeName.setText(edmake);
					_modelName.setText(edmodel);
					_vin.setText(edstyle);
					_year.setText(edyear);

					Log.i("JSON RESULTS",edmake.toString());
					Log.i("JSON RESULTS",edmodel.toString());

			}catch (JSONException e)
			{
				Log.e("JSON","JSON OBJECT EXCEPTION", e);
			}
    		
    	}
		
	}    
    
    // TEST VIN NUMBER TO USE IN SIMULATOR JM1BJ227X30644735

    @Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
    	super.onActivityResult(requestCode, resultCode, data);
    	
		if (requestCode == request_code)
			Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG);
			Log.i("TOAST ISSUE", "Not passing data");
			
		{
			if (resultCode == RESULT_OK)
			{
				Log.i("TOAST OKAY", "Toast was sucessful");
				Toast.makeText(this, data.getData().toString(),
						Toast.LENGTH_LONG).show();
			}
		}
	}    

}	//ends code
