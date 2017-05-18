package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import bustudio.doctruyen.R;
import model.Truyen;

/**
 * Created by TieuHoan on 20/04/2017.
 */

public class KimDungAdapter extends RecyclerView.Adapter<KimDungAdapter.KimDungHolder> {


    private ArrayList<Truyen> truyens;
    private Context context;
    private boolean grid;
    private ImageView imageFavorite;

    public ImageView getImageFavorite() {
        return imageFavorite;
    }

    public KimDungAdapter(ArrayList<Truyen> truyens, Context context, boolean grid) {
        this.truyens = truyens;
        this.context = context;
        this.grid = grid;
    }

    @Override
    public KimDungHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view;

        if (grid) {
            view = layoutInflater.inflate(R.layout.item_truyen2, null, false);

        } else {
            view = layoutInflater.inflate(R.layout.item_truyen, null, false);
        }

        return new KimDungHolder(view);

    }

    @Override
    public void onBindViewHolder(KimDungHolder kimDungHolder, int position) {
        Truyen truyen = truyens.get(position);
        kimDungHolder.nameTruyen.setText(truyen.getName());
        Glide.with(context)
                .load(truyen.getImgThumb())
                .centerCrop()
                .crossFade()
                .into(kimDungHolder.imageTruyen);
        if (!grid) {
            kimDungHolder.webDescrible.loadData(truyen.getDescribe(), "text/html; charset=utf-8", "utf-8");
        }

        if (grid) {
            kimDungHolder.viewCount.setText(String.valueOf(truyen.getViewCount()));
            if (truyen.getFavorite() == 1) {
                kimDungHolder.favorite.setImageResource(R.drawable.ic_favorite);
            } else {
                kimDungHolder.favorite.setImageResource(R.drawable.ic_not_favorite);
            }
        }
    }

    @Override
    public int getItemCount() {
        return truyens.size();
    }


    class KimDungHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageTruyen;
        TextView nameTruyen;
        WebView webDescrible;
        TextView viewCount;
        ImageView favorite;

        public ImageView getFavorite() {
            return favorite;
        }

        public void setFavorite(ImageView favorite) {
            this.favorite = favorite;
        }

        public KimDungHolder(View itemView) {
            super(itemView);

            if (grid) {
                imageTruyen = (ImageView) itemView.findViewById(R.id.imgThumb);
                nameTruyen = (TextView) itemView.findViewById(R.id.tenTruyen);
                viewCount = (TextView) itemView.findViewById(R.id.viewCount);
                favorite = (ImageView) itemView.findViewById(R.id.favorite);
                favorite.setOnClickListener(this);

                imageFavorite = favorite;

            } else {
                imageTruyen = (ImageView) itemView.findViewById(R.id.imageTruyen);
                nameTruyen = (TextView) itemView.findViewById(R.id.nameTruyen);
                webDescrible = (WebView) itemView.findViewById(R.id.webDescrible);
                webDescrible.setOnClickListener(this);

            }


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (v.getId() != R.id.favorite) {
                onClickItemRecycleView.OnClick(v, getPosition());
            } else {
                onClickItemRecycleView.OnClickFavorite(v, getPosition(), getFavorite());
            }

        }
    }


    public void setOnClickItemRecycleView(OnClickItemRecycleView onClickItemRecycleView) {
        this.onClickItemRecycleView = onClickItemRecycleView;

    }

    public interface OnClickItemRecycleView {
        void OnClick(View view, int position);

        void OnClickFavorite(View view, int position, ImageView imageFavorite);

    }


    public OnClickItemRecycleView onClickItemRecycleView;


    public void swap(ArrayList<Truyen> truyens) {
        this.truyens.clear();
        this.truyens.addAll(truyens);
        notifyDataSetChanged();
    }


}
