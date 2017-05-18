package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bustudio.doctruyen.R;
import search.SearchResult;


/**
 * Created by TieuHoan on 11/05/2017.
 */

public class ResultAdapter extends BaseAdapter {
    private ArrayList<SearchResult> searchResults;
    private LayoutInflater layoutInflater;

    public ResultAdapter(ArrayList<SearchResult> searchResults, Context context) {
        this.searchResults = searchResults;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return searchResults.size();
    }

    @Override
    public Object getItem(int position) {
        return searchResults.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.item_search_result, null, false);
        ResultHolder resultHolder;

        resultHolder = new ResultHolder();
        resultHolder.tvChapterName = (TextView) convertView.findViewById(R.id.tvChapterName);
        resultHolder.tvSearchContent = (TextView) convertView.findViewById(R.id.tvSearchContent);

        resultHolder.tvChapterName.setText(searchResults.get(position).getChapterName());
        resultHolder.tvSearchContent.setText(searchResults.get(position).getSsearchContent());

        Log.d("khoa", resultHolder.tvChapterName.getText().toString());

        return convertView;
    }


    public class ResultHolder {
        public TextView tvChapterName;
        public TextView tvSearchContent;
    }
}
