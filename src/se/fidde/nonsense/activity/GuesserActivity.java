package se.fidde.nonsense.activity;

import se.fidde.nonsense.R;
import se.fidde.nonsense.guesser.SetBackgroundListener;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GuesserActivity extends FragmentActivity implements SetBackgroundListener{

	private LinearLayout container;
	private int bgColor;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guesser);
    }

    public void checkAnswer(View view) {
    	if(container == null){
    		container = (LinearLayout) findViewById(R.id.guesser_container);
    		bgColor = getResources().getColor(R.color.bgCorrect);
    	}

    	if(view.getId() == R.id.img_1){
			container.setBackgroundColor(bgColor);
    	
    	} else {
    		container.setBackgroundColor(getResources().getColor(R.color.bgWrong));
        		
		}
	}

	@Override
	public void setBackground(int bgId) {
		container.setBackgroundColor(getResources().getColor(bgId));
	}
}