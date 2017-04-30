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
import android.widget.Toast;

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
    private FloatingActionButton floatingActionButton;
    private boolean grid;
    private ReadDataBase readDataBase;
    private Context context;
    private ArrayList<Truyen> truyens;
    private RecyclerView recyclerViewKimDung;
    private CenterZoomLayoutManager centerZoomLayoutManager;
    private KimDungAdapter kimDungAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        centerZoomLayoutManager = new CenterZoomLayoutManager(context, CenterZoomLayoutManager.VERTICAL, false);

        readDataBase = new ReadDataBase(context);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.kim_dung_fragment, container, false);
        bindView(view);
        setUpRecycleViewTruyen();
        setUpFAB();
        return view;
    }


    public void bindView(View view) {

        recyclerViewKimDung = (RecyclerView) view.findViewById(R.id.recycleViewTruyen);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fabAction);
    }

    public void setUpRecycleViewTruyen() {
        grid = true;
        truyens = readDataBase.getTruyen();
        kimDungAdapter = new KimDungAdapter(truyens, context, grid);
        recyclerViewKimDung.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerViewKimDung.setAdapter(kimDungAdapter);
        kimDungAdapter.setOnClickItemRecycleView(this);
    }

    public void setUpFAB() {
        floatingActionButton.setOnClickListener(this);

    }

    @Override
    public void OnClick(View view, int position) {

        //recycle view
        Toast.makeText(context, "click item", Toast.LENGTH_SHORT).show();


        ArrayList<Chap> chaps = readDataBase.getAllChap(String.valueOf(truyens.get(position).getId()));
        Bundle bundle = new Bundle();
        ChapFragment chapFragment = new ChapFragment();
        bundle.putSerializable("CHAPS", chaps);
        bundle.putSerializable("TRUYEN", truyens.get(position));
        chapFragment.setArguments(bundle);

        FragmentControl.goToFragmentAddBackStack(R.id.frameLayout, chapFragment, context, getClass().getName());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabAction: {
                if (!grid) {
                    recyclerViewKimDung.setLayoutManager(new GridLayoutManager(context, 2));
                    grid = true;


                } else {
                    recyclerViewKimDung.setLayoutManager(centerZoomLayoutManager);
                    grid = false;
//                    kimDungAdapter = new KimDungAdapter(truyens, context, grid);

                }
                kimDungAdapter = new KimDungAdapter(truyens, context, grid);
                recyclerViewKimDung.setAdapter(kimDungAdapter);
                kimDungAdapter.setOnClickItemRecycleView(this);
                break;
            }

        }
    }

//


}
