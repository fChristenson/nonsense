package se.fidde.nonsense.activity;

import se.fidde.nonsense.R;
import se.fidde.nonsense.fragment.writer.OnWordSelectListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class WriterActivity extends FragmentActivity implements
        OnWordSelectListener {

    private TextView textFieldWithWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writer);

        Fragment fragment = getSupportFragmentManager().findFragmentById(
                R.id.picture_fragment);

        textFieldWithWords = (TextView) fragment.getView().findViewById(
                R.id.textView);
    }

    @Override
    public void addWordToTextfield(String word) {
        String originalText = textFieldWithWords.getText().toString();
        textFieldWithWords.setText(originalText + " " + word);
    }

}
