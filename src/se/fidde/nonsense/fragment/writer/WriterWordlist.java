package se.fidde.nonsense.fragment.writer;

import se.fidde.nonsense.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WriterWordlist extends Fragment {

    private ArrayAdapter<String> wordlistAdapter;

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

        return view;
    }
}
