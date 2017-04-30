package bustudio.doctruyen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapter.ChapAdapter;
import model.Chap;
import model.Truyen;

/**
 * Created by TieuHoan on 25/04/2017.
 */

public class ChapFragment extends Fragment {

    private ArrayList<Chap> chaps;
    private Truyen truyen;
    private ChapAdapter chapAdapter;
    private Context context;
    private RecyclerView recyclerViewChap;
    private LinearLayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            chaps = (ArrayList<Chap>) bundle.getSerializable("CHAPS");
            truyen = (Truyen) bundle.getSerializable("TRUYEN");
            Log.e("img" , truyen.getImgThumb());
            Log.e("chap size", String.valueOf(chaps.size()));

        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chap_fragment, null, false);
        bindView(view);
        setUpRecyclerViewChap();

        return view;
    }

    public void setUpRecyclerViewChap() {
        chapAdapter = new ChapAdapter(chaps, context, truyen);
        recyclerViewChap.setLayoutManager(layoutManager);
        recyclerViewChap.setAdapter(chapAdapter);
    }

    public void bindView(View view) {
        recyclerViewChap = (RecyclerView) view.findViewById(R.id.recycleViewChap);

    }
}
