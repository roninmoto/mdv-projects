package com.jbetterly.auto2;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;

import com.jbetterly.auto2.R;
import com.jbetterly.lib.FileStore;
import com.jbetterly.lib.WebChecks;

import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.content.DialogInterface;
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

	
	
	
	
	
	
}
