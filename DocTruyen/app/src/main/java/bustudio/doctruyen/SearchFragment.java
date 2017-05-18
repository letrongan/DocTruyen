package bustudio.doctruyen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.ResultAdapter;
import search.SearchResult;
import ulti.FragmentControl;

/**
 * Created by TieuHoan on 11/05/2017.
 */

public class SearchFragment extends Fragment {
    private ArrayList<SearchResult> searchResults;
    private ListView lvResult;
    private ResultAdapter resultAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Bundle bundle = getArguments();
        if (bundle != null) {
            searchResults = (ArrayList<SearchResult>) bundle.getSerializable("SEARCH_RESULT");
//            for (SearchResult searchResult : searchResults) {
//                Log.e("tieuhoan", searchResult.getSsearchContent());
//            }
        }
        View view = inflater.inflate(R.layout.dialog_search, null, false);
        lvResult = (ListView) view.findViewById(R.id.lv_result);
        resultAdapter = new ResultAdapter(searchResults, getActivity());
        lvResult.setAdapter(resultAdapter);
        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.e("tieuhoan", searchResults.get(position).getChapterID());

                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("READ_CHAPS", ViewPagerChapFragment.chaps);
                bundle1.putInt("POSITION", Integer.parseInt(searchResults.get(position).getChapterID()));
                bundle1.putFloat("SCROLL", searchResults.get(position).getScroll());
                ViewPagerChapFragment viewPagerChapFragment = new ViewPagerChapFragment();
                viewPagerChapFragment.setArguments(bundle1);

                FragmentControl.goToFragmentAddBackStack(R.id.frameLayout, viewPagerChapFragment, getActivity(), getClass().getName());
            }
        });

        return view;
    }


}
