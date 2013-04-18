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
				if(carSearch.getText().toString().length() > 0)   // CONDITIONAL - Car Search empty
				{
					Log.i("Go Button Action: ", carSearch.getText().toString());  //log out a message
				
				}else{
					String logstuff = "Please enter text";
					Log.i("Go Button Action: ", logstuff);
				}
			}
		});
		
        //Using my interface to add to my CarList - all static for now. 
        //pg 132 in class book -  Learn Java for Android Development
        
        ArrayList<Cars> cars = new ArrayList<Cars>();
        cars.add(new CarList("BMW", "Mini Cooper"));
        cars.add(new CarList("Jeep", "Wrangler"));
        cars.add(new CarList("Chrysler", "Pacifica"));
        
        // need to find a better way, but this works for now...
        for (Cars data : cars) 
        {
            Log.i("New cars ",data.toString());
        }
                        
        ll.addView(mysearch);
        ((LinearLayout) myll).addView(ll);
		
        //Static data for xml import.
        CarInfo Car1 = new CarInfo(getString(R.string.usa_name), getString(R.string.usa_make), getString(R.string.usa_price), MadeIn.HOMEMADE.toString());
        CarInfo Car2 = new CarInfo(getString(R.string.usa2_name), getString(R.string.usa2_make), getString(R.string.usa2_price), MadeIn.HOMEMADE.toString());
        CarInfo Car3 = new CarInfo(getString(R.string.usa3_name), getString(R.string.usa3_make), getString(R.string.usa3_price), MadeIn.HOMEMADE.toString());
        CarInfo Car4 = new CarInfo(getString(R.string.intntl_name), getString(R.string.intntl_make), getString(R.string.intntl_price), MadeIn.CHINAMADE.toString());
        CarInfo Car5 = new CarInfo(getString(R.string.intntl2_name), getString(R.string.intntl2_make), getString(R.string.intntl2_price), MadeIn.CHINAMADE.toString());
	}



	
	
	
	
	
	
	
	
}
