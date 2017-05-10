package bustudio.doctruyen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ulti.ReadDataBase;

/**
 * Created by TieuHoan on 08/04/2017.
 */

public class FavoriteFragment extends KimDungFragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kim_dung_fragment, null, false);

        readDataBase = new ReadDataBase(context);
        truyens = readDataBase.getFavoriteTruyen();
        bindView(view);
        setUpRecycleViewTruyen(truyens, false);
        setUpFAB();

        return view;
    }
//


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void OnClickFavorite(View view, int position, ImageView imageFavorite) {
        super.OnClickFavorite(view, position, imageFavorite);
        kimDungAdapter.swap(readDataBase.getFavoriteTruyen());

    }
}
