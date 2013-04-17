package cars.lib;

import android.widget.LinearLayout.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.content.Context;


public class LayoutView {

	public static LinearLayout create(Context context, String hint, String buttonText){
		LinearLayout ll = new LinearLayout(context);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(lp);
		
        EditText et = new EditText(context);
        lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
        et.setHint(hint);
        et.setLayoutParams(lp);
        et.setId(1);
        
        Button b = new Button(context);
        b.setText(buttonText);
        b.setId(2);
        b.setTag(et);

        ll.addView(et);
        ll.addView(b);
        
		return ll;
	}
}