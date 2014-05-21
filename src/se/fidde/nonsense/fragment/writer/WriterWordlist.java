package se.fidde.nonsense.fragment.writer;

import se.fidde.nonsense.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WriterWordlist extends Fragment {

    private ArrayAdapter<String> wordlistAdapter;
    private OnWordSelectListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        wordlistAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1);

        for (int i = 0; i < 20; ++i) {
            wordlistAdapter.add("Test");
        }

        View view = inflater.inflate(R.layout.fragment_writer_wordlist,
                container, false);

        ListView listView = (ListView) view.findViewById(R.id.listWithWords);
        listView.setAdapter(wordlistAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                    int pos, long id) {

                String word = adapterView.getItemAtPosition(pos).toString();
                listener.addWordToTextfield(word);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (OnWordSelectListener) activity;
    }
}
