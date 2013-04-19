/*
 * Project: automobile
 * Package: com.jbetterly.automobile
 * @author: Joel Betterly
 * Date: 	Apr 17, 2013
 * Hoping to use http://developer.edmunds.com/docs/The_Vehicle_API/ for API
 */

package com.jbetterly.automobile;

import android.os.Bundle;
import android.app.Activity;
import cars.lib.CarInfo;
import cars.lib.CarList;
import cars.lib.Cars;
import cars.lib.LayoutView;
import cars.lib.MadeIn;
import android.view.View;
import java.util.Arrays;
import java.util.ArrayList;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.LinearLayout;
import android.widget.TextView;




public class MainActivity extends Activity
{

	private ListView theCarList;
	private ArrayAdapter<String> listAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		android.view.View myll =  findViewById(R.id.info);

        LinearLayout ll = new LinearLayout(this);
        // creating my initial view with the text box and the go button. this will search the list of cars
        LinearLayout mysearch = LayoutView.create(this, "List Cars", "Find");
        Button goButton = (Button) mysearch.findViewById(2);
        goButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				EditText carSearch = (EditText) v.getTag();
				// CONDITIONAL - Car Search empty per requirement
				if(carSearch.getText().toString().length() > 0)   
				{
					//log out a message
					Log.i("Go Button Action: ", carSearch.getText().toString());  
				
				}else{
					
					String logstuff = "Please enter text";
					//log out a message
					Log.i("Go Button Action: ", logstuff);
				}
			}
		});
		
        //Using my interface to add to my CarList - all static for now. 
        ArrayList<Cars> cars = new ArrayList<Cars>();
        cars.add(new CarList("BMW", "Mini Cooper"));
        cars.add(new CarList("Jeep", "Wrangler"));
        cars.add(new CarList("Chrysler", "Pacifica"));
        
        // For loop to log out to String
        for (Cars data : cars) 
        {
            Log.i("New cars ",data.toString());
        }
                        
        ll.addView(mysearch);
        ((LinearLayout) myll).addView(ll);
		
        //Static data for xml import.
        CarInfo car1 = new CarInfo(getString(R.string.usa_name), getString(R.string.usa_make), getString(R.string.usa_price), MadeIn.HOMEMADE.toString());
        CarInfo car2 = new CarInfo(getString(R.string.usa2_name), getString(R.string.usa2_make), getString(R.string.usa2_price), MadeIn.HOMEMADE.toString());
        CarInfo car3 = new CarInfo(getString(R.string.usa3_name), getString(R.string.usa3_make), getString(R.string.usa3_price), MadeIn.HOMEMADE.toString());
        CarInfo car4 = new CarInfo(getString(R.string.intntl_name), getString(R.string.intntl_make), getString(R.string.intntl_price), MadeIn.CHINAMADE.toString());
        CarInfo car5 = new CarInfo(getString(R.string.intntl2_name), getString(R.string.intntl2_make), getString(R.string.intntl2_price), MadeIn.CHINAMADE.toString());
	

	// setting up array using CarInfo class
    final CarInfo[] Auto = { car1, car2, car3, car4, car5 };
    
    // setting up array using car names
    String[] AutoNames = { car1.name, car2.name, car3.name, car4.name, car5.name };
    
    // Calling my list view... 
    theCarList = (ListView) findViewById(R.id.theCarList);
    
    // Created ArrayList Names
    ArrayList<String> allCarNamesList = new ArrayList<String>();  
    allCarNamesList.addAll( Arrays.asList(AutoNames) );
    
    // Created ArrayAdapter 
    listAdapter = new ArrayAdapter<String>(this, R.layout.row, allCarNamesList); 
    
    // Set the ArrayAdapter   
    theCarList.setAdapter(listAdapter);

	
	
    theCarList.setOnItemClickListener(new OnItemClickListener() 
    {
		@Override
		public void onItemClick(AdapterView<?> arg0,
				View theListAdapter, int arg2, long arg3) 
				{
			TextView s = (TextView) theListAdapter;
			
			// UI Output 
			Log.i("Name: ", s.getText().toString());
			String chosenCar = s.getText().toString();
			for(int i=0; i<Auto.length; i++)
        {
            	CarInfo carStr = Auto[i];
            	if (chosenCar == carStr.name) 
            	{
            		String carPrice = carStr.price;
            		//logging output when row is clicked
            		Log.i("Price: ", carPrice);
            		
            		String carMake = carStr.make;
            		//logging output when row is clicked
            		Log.i("Make: ", carMake);
            		
            		String carMadeIn = carStr.madeIn;
            		//logging output when row is clicked
            		Log.i("Type: ", carMadeIn);
            	} 
        }
			
      }
    });
	
	
	
	}	
	
}
