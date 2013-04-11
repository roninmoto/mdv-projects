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
	double tip = .01;
	TextView outcome;
	TextView giveMoney;
	boolean displayTextView;
	TextView jBool;
	
	
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
				int adult2 = getResources().getInteger(R.integer.adult2);
				int teen = getResources().getInteger(R.integer.teen);
				int teen2 = getResources().getInteger(R.integer.teen2);
				int kid = getResources().getInteger(R.integer.kid);
				int kid2 = getResources().getInteger(R.integer.kid2);
				int tot = getResources().getInteger(R.integer.tot);
				int tot2 = getResources().getInteger(R.integer.tot2);
				
				//Get value from field convert to string
				int valueInput = Integer.parseInt(et.getText().toString());
				
				double numAdult = (tip*adult)*valueInput;
				double numAdult2 = (tip*adult2)*valueInput;
				double numTeen = (tip*teen)*valueInput;
				double numTeen2 = (tip*teen2)*valueInput;
				double numKid = (tip*kid)*valueInput;
				double numKid2 = (tip*kid2)*valueInput;
				double numTot = (tip*tot)*valueInput;
				double numTot2 = (tip*tot2)*valueInput;
				
				//Conditional statement determining what to do with the tips
				if(valueInput >= 100)
				{
					outcome.setText("Adult Tips: " + numAdult + "\r\n" +
							"Teen Tips: " + numTeen + "\r\n" +
							"Kid Tips: " + numKid + "\r\n" +
							"Tot Tips: " + numTot + "\r\n");
					
					//Loop to figure out who gets paid what amount, include array with Strings
					String[] adultPeople = {"Joe - 25", "Ben -22"};
					int adtPpl = adultPeople.length;
					for (int i=0; i<adtPpl; i++)
					{
						//Create a float value for tips for each group
						double tip1;
						tip1 = numAdult;
						giveMoney.append("Tips " + adultPeople[i] + "- $" + tip1 + " earned /n");
					}
					String[] teenPeople = {"Suzy - 18", "Cheryl - 17"};
					int teenPpl = teenPeople.length;
					for (int i=0; i<teenPpl; i++)
					{
						double tip2;
						tip2 = numTeen;
						giveMoney.append("Tips " + teenPeople[i] + "- $" + tip2 + " earned /n");
					}
					String[] kidPeople = {"Carl - 12", "Herman - 8"};
					int kidPpl = kidPeople.length;
					for (int i=0; i<kidPpl; i++)
					{
						double tip3;
						tip3 = numKid;
						giveMoney.append("Tips " + kidPeople[i] + "- $" + tip3 + " earned /n");
					}
					String[] totPeople = {"Bella - 1", "Jada - 2"};
					int totPpl = totPeople.length;
					for (int i=0; i<totPpl; i++)
					{
						double tip4;
						tip4 = numTot;
						giveMoney.append("Tips " + totPeople[i] + "- $" + tip4 + " earned /n");
					}		
				}else{
					outcome.setText("Adult Tips: " + numAdult2 + "\r\n" +
							"Teen Tips: " + numTeen2 + "\r\n" +
							"Kid Tips: " + numKid2 + "\r\n" +
							"Tot Tips: " + numTot2 + "\r\n");
					
					String[] adultPeople = {"Joe - 25", "Ben -22"};
					int adtPpl = adultPeople.length;
					for (int i=0; i<adtPpl; i++)
					{
						//Create a float value for tips for each group
						double tip5;
						tip5 = numAdult2;
						giveMoney.append("Tips " + adultPeople[i] + "- $" + tip5 + " earned /n");
					}
					
					String[] teenPeople = {"Suzy - 18", "Cheryl - 17"};
					int teenPpl = teenPeople.length;
					for (int i=0; i<teenPpl; i++)
					{
						double tip6;
						tip6 = numTeen2;
						giveMoney.append("Tips " + teenPeople[i] + "- $" + tip6 + " earned /n");
					}
					String[] kidPeople = {"Carl - 12", "Herman - 8"};
					int kidPpl = kidPeople.length;
					for (int i=0; i<kidPpl; i++)
					{
						double tip7;
						tip7 = numKid2;
						giveMoney.append("Tips " + kidPeople[i] + "- $" + tip7 + " earned /n");
					}
					String[] totPeople = {"Bella - 1", "Jada - 2"};
					int totPpl = totPeople.length;
					for (int i=0; i<totPpl; i++)
					{
						double tip8;
						tip8 = numTot2;
						giveMoney.append("Tips " + totPeople[i] + "- $" + tip8 + " earned /n");
					}
				}
			}
		});
		
			//Reset Button to clear value
			Button c = new Button(this);
			c.setText("Reset");
			
			//EventListner for Button
			c.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					et.setText("");
					outcome.setText("");
					giveMoney.setText("");
				}
			});
			
			//Create LinearLayOut form
			LinearLayout form = new LinearLayout(this);
	        form.setOrientation(LinearLayout.HORIZONTAL);
	        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
	        form.setLayoutParams(lp);
	        
	        jBool = new TextView(this);
	        jBool.setText("Bool was false.");
	        
	        String input = "true";
	        if (input.equals("true")) {
	        	
	           displayTextView = true;
	           form.addView(et);
	           form.addView(b);
	           form.addView(c);
	        } else {
	        	displayTextView = false;
	        	ll.addView(jBool);
	        }

	    
	        ll.addView(form);
	        
	        outcome = new TextView(this);
	        ll.addView(outcome);
	        
	        giveMoney = new TextView(this);
	        ll.addView(giveMoney);
	        
	        setContentView(ll);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
