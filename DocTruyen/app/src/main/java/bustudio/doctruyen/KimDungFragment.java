package bustudio.doctruyen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import adapter.KimDungAdapter;
import customview.CenterZoomLayoutManager;
import model.Chap;
import model.Truyen;
import ulti.FragmentControl;
import ulti.ReadDataBase;

/**
 * Created by TieuHoan on 08/04/2017.
 */

public class KimDungFragment extends Fragment implements KimDungAdapter.OnClickItemRecycleView, View.OnClickListener {
    public FloatingActionButton floatingActionButton;
    public boolean grid;
    public ReadDataBase readDataBase;
    public Context context;
    public ArrayList<Truyen> truyens;
    public RecyclerView recyclerViewKimDung;
    private CenterZoomLayoutManager centerZoomLayoutManager;
    public KimDungAdapter kimDungAdapter;
    private int columGridView;


    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        columGridView = 3;
        grid = true;
        context = getActivity();
        centerZoomLayoutManager = new CenterZoomLayoutManager(context, CenterZoomLayoutManager.VERTICAL, false);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kim_dung_fragment, container, false);
        readDataBase = new ReadDataBase(context);
        truyens = readDataBase.getTruyen();
        bindView(view);
        setUpRecycleViewTruyen(truyens, true);
        setUpFAB();
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabAction: {
                eventFAB();
                break;
            }

        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void sendData(Truyen truyen) {
        ArrayList<Chap> chaps = readDataBase.getAllChap(String.valueOf(truyen.getId()));
        Bundle bundle = new Bundle();
        bundle.putSerializable("CHAPS", chaps);
        bundle.putSerializable("TRUYEN", truyen);
        ChapFragment chapFragment = new ChapFragment();
        chapFragment.setArguments(bundle);
        FragmentControl.goToFragmentAddBackStack(R.id.frameLayout, chapFragment, context, getClass().getName());


    }

    public void setUpFAB() {
        floatingActionButton.setOnClickListener(this);

    }

    public void eventFAB() {
        if (!grid) {
            recyclerViewKimDung.setLayoutManager(new GridLayoutManager(context, columGridView));
            floatingActionButton.setImageResource(R.drawable.grid);
            grid = true;
        } else {
            recyclerViewKimDung.setLayoutManager(centerZoomLayoutManager);
            floatingActionButton.setImageResource(R.drawable.list);
            grid = false;
        }
        kimDungAdapter = new KimDungAdapter(truyens, context, grid);
        recyclerViewKimDung.setAdapter(kimDungAdapter);
        kimDungAdapter.setOnClickItemRecycleView(this);
    }

    public void bindView(View view) {
        recyclerViewKimDung = (RecyclerView) view.findViewById(R.id.recycleViewTruyen);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fabAction);
    }

    public void setUpRecycleViewTruyen(ArrayList<Truyen> truyens, boolean grid) {
        grid = true;
        kimDungAdapter = new KimDungAdapter(truyens, context, grid);
        recyclerViewKimDung.setLayoutManager(new GridLayoutManager(context, columGridView));
        recyclerViewKimDung.setAdapter(kimDungAdapter);
        kimDungAdapter.setOnClickItemRecycleView(this);
    }

    @Override
    public void OnClick(View view, int position) {
        Truyen truyen = truyens.get(position);

        //add view count
        readDataBase.addViewCount(truyen.getViewCount() + 1, String.valueOf(truyen.getId()));

        //send data
        sendData(truyen);

    }


    static int favorite;

    @Override
    public void OnClickFavorite(View view, int position, ImageView imageFavorite) {
        Truyen truyen = truyens.get(position);
        //add favorite

        favorite = truyen.getFavorite();

        if (favorite == 0) {
            readDataBase.addFavorite(1, String.valueOf(truyen.getId()));
            favorite = 1;
            imageFavorite.setImageResource(R.drawable.ic_favorite);
//            Log.e("set", "favorite");
        } else {
            readDataBase.addFavorite(0, String.valueOf(truyen.getId()));
            favorite = 0;
            imageFavorite.setImageResource(R.drawable.ic_not_favorite);
//            Log.e("set", "not favorite");
        }


    }
}
