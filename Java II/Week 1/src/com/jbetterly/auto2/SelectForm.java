/*
 * Project: AutoJava2
 * Package: com.jbetterly.auto2
 * @author: Joel Betterly
 * Date: 	May 8, 2013
 */
package com.jbetterly.auto2;

import android.content.Context;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SelectForm extends LinearLayout {
	
	EditText _searchField;
	Button _searchButton;
	
	//Search field and button layout.
	public SelectForm(Context context, String hint, String buttonText){
		super(context);
		
		LayoutParams lp;
		
		_searchField = new EditText(context);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		_searchField.setLayoutParams(lp);
		_searchField.setHint(hint);
		_searchField.setInputType(InputType.TYPE_CLASS_NUMBER);
		_searchButton = new Button(context);
		_searchButton.setText(buttonText);
		
		this.addView(_searchField);
		this.addView(_searchButton);
		
		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
		
	}
	
	public EditText getField(){
		return _searchField;
	}
	
	public Button getButton(){
		return _searchButton;
	}

}

