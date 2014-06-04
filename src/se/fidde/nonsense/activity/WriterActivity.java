package se.fidde.nonsense.activity;

import java.util.Random;

import se.fidde.nonsense.R;
import se.fidde.nonsense.fragment.writer.OnWordSelectListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class WriterActivity extends FragmentActivity {

	private ArrayAdapter<String> wordlistAdapter;
    private TextView textFieldWithWords;
	private LinearLayout container;
	private int bgColor;
	private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writer);

        init();
        addWordsToList();
        setImage();
    }

	private void setImage() {
		// TODO Auto-generated method stub
		
	}

	private void init() {
        image = (ImageView) findViewById(R.id.writer_image);
		wordlistAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);

		ListView listView = (ListView) findViewById(R.id.wordlist);
        textFieldWithWords = (TextView) findViewById(R.id.textViewWithWords);
        listView.setAdapter(wordlistAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                    int pos, long id) {

                String word = adapterView.getItemAtPosition(pos).toString();
                String originalText = textFieldWithWords.getText().toString();
                textFieldWithWords.setText(originalText + " " + word);
            
            }
        });
	}

	private void addWordsToList() {
		wordlistAdapter.clear();
		Random rand = new Random();
		String[] words = {"lorem", "ipsum", "dolor", "amet"};
        for (int i = 0; i < 10; ++i) {
            wordlistAdapter.add(words[rand.nextInt(words.length)]);
        }
	}

    public void next(View view) {
		textFieldWithWords.setText("");
		if(container == null){
			container = (LinearLayout) findViewById(R.id.writer_container);
			bgColor = getResources().getColor(R.color.bgNormal);
		}
		container.setBackgroundColor(bgColor);
		addWordsToList();
	}
}
