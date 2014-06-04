package se.fidde.nonsense;

import se.fidde.nonsense.activity.GuesserActivity;
import se.fidde.nonsense.activity.WriterActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.os.Build;

public class StartMenu extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_menu);

	}

	public void findOtherDevices(View view) {
		if(view.getId() == R.id.btn_host){
			showWaitingDialog("Waiting for writer");
			startWriterActivity();
			
		} else {
			showWaitingDialog("Waiting for guesser");
			startGuesserActivity();
		}
	}

	private void startWriterActivity() {
		Intent intent = new Intent(this, WriterActivity.class);
		startActivity(intent);
	}

	private void startGuesserActivity() {
		Intent intent = new Intent(this, GuesserActivity.class);
		startActivity(intent);
	}

	private void showWaitingDialog(String msg) {
		ProgressDialog spinner = new ProgressDialog(this);
		spinner.setTitle("Waiting");
		spinner.setMessage(msg);
		spinner.show();
	}

}
