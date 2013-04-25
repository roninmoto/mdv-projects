package com.jbetterly.auto2;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.TextView;

public class CarDisplay extends GridLayout

{
	//going to pull Make, Model and Year from API  May add more if time allows
	
	TextView _makeName;
	TextView _modelName;
	TextView _year; 
	Context _context;

	public CarDisplay(Context context){
		super(context);
		
		_context = context;
		
		this.setColumnCount(2);
		
		TextView nameLabel = new TextView(_context);
		nameLabel.setText("Car Make: ");
		_makeName = new TextView(_context);
		_makeName.setText("");
		
		TextView modelLabel = new TextView(_context);
		modelLabel.setText("Model: ");
		_modelName = new TextView(_context);
		_modelName.setText("");
		
		TextView yearLabel = new TextView(_context);
		yearLabel.setText("Year: ");
		_year = new TextView(_context);
		_year.setText("");
		
		this.addView(nameLabel);
		this.addView(_makeName);
		
		this.addView(modelLabel);
		this.addView(_modelName);
		
		this.addView(yearLabel);
		this.addView(_year);
			}

}
