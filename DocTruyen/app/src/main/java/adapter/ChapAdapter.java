package adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Random;

import bustudio.doctruyen.R;
import model.Chap;
import model.Truyen;

/**
 * Created by TieuHoan on 25/04/2017.
 */

public class ChapAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Chap> chaps;
    private Context context;
    private Truyen truyen;
    public final int TYPE_HEADER_CHAP = 0, TYPE_RECYCLE_VIEW = 1;


    public ChapAdapter(ArrayList<Chap> chaps, Context context, Truyen truyen) {
        this.chaps = chaps;
        this.context = context;
        this.truyen = truyen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view;
        if (viewType == TYPE_HEADER_CHAP) {
            view = layoutInflater.inflate(R.layout.header_chap, null, false);
            return new HeaderChapHolder(view);
        } else if (viewType == TYPE_RECYCLE_VIEW) {
            view = layoutInflater.inflate(R.layout.item_chap, null, false);
            return new ChapHolder(view);
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderChapHolder) {
            HeaderChapHolder headerChapHolder = (HeaderChapHolder) holder;
            Glide.with(context)
                    .load(truyen.getImgThumb())
                    .crossFade()
                    .into(headerChapHolder.headerImgThumb);
            headerChapHolder.headerTenTruyen.setText(truyen.getName());
            headerChapHolder.headerWebDescrible.loadData(truyen.getDescribe(), "text/html; charset=utf-8", "utf-8");
        } else if (holder instanceof ChapHolder) {
            ChapHolder chapHolder = (ChapHolder) holder;
            chapHolder.nameChap.setText(chaps.get(position).getNameChap());
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            chapHolder.nameChap.setTextColor(color);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == TYPE_HEADER_CHAP) return TYPE_HEADER_CHAP;
        return TYPE_RECYCLE_VIEW;

    }

    @Override
    public int getItemCount() {
        return chaps.size();
    }

    class HeaderChapHolder extends RecyclerView.ViewHolder {
        ImageView headerImgThumb;
        TextView headerTenTruyen;
        WebView headerWebDescrible;

        public HeaderChapHolder(View itemView) {
            super(itemView);
            headerImgThumb = (ImageView) itemView.findViewById(R.id.headerImgThumb);
            headerTenTruyen = (TextView) itemView.findViewById(R.id.headerTenTruyen);
            headerWebDescrible = (WebView) itemView.findViewById(R.id.headerWebDescrible);
        }
    }

    class ChapHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nameChap;

        public ChapHolder(View itemView) {
            super(itemView);
            nameChap = (TextView) itemView.findViewById(R.id.nameChap);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickItemRecycleView.OnClick(v, getPosition());
        }
    }

    public OnClickItemRecycleView onClickItemRecycleView;

    public void setOnClickItemRecycleView(OnClickItemRecycleView onClickItemRecycleView) {
        this.onClickItemRecycleView = onClickItemRecycleView;
    }

    public interface OnClickItemRecycleView {
        void OnClick(View view, int position);

    }
}
