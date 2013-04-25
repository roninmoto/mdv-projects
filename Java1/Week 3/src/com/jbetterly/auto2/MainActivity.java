package com.jbetterly.auto2;

import android.os.Bundle;
import android.app.Activity;
import com.jbetterly.auto2.R;
import com.jbetterly.lib.FileStore;
import com.jbetterly.lib.WebChecks;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;


public class MainActivity extends Activity
{

	//GLobal Variables
	Context _context;
	Boolean _connected = false;
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
		_makeName = (TextView) findViewById(R.id._makeName);
		_modelName = (TextView) findViewById(R.id._modelName);
		_year = (TextView) findViewById(R.id._year);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
