//package adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//import bustudio.doctruyen.R;
//import customview.MatrixView;
//import model.Truyen;
//
///**
// * Created by TieuHoan on 17/04/2017.
// */
//
//public class TruyenAdapter extends BaseAdapter {
//
//    private ArrayList<Truyen> truyens;
//    private Context context;
//    private ListView listView;
//
//    public TruyenAdapter(ArrayList<Truyen> truyens, ListView listView, Context context) {
//        this.truyens = truyens;
//        this.listView = listView;
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return truyens.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return truyens.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View view, ViewGroup parent) {
//        Truyen truyen = truyens.get(position);
//        ViewHolder viewHolder;
//        if (view == null) {
//            viewHolder = new ViewHolder();
//            MatrixView matrixView = (MatrixView) LayoutInflater.from(context).inflate(R.layout.item_truyen, null, false);
//           matrixView.setParentHeight(listView.getHeight());
//            view = matrixView;
//
//            viewHolder.tenTruyen = (TextView) view.findViewById(R.id.tenTruyen);
//            view.setTag(viewHolder);
//
//        } else {
//            viewHolder = (ViewHolder) view.getTag();
//
//        }
//
//        viewHolder.tenTruyen.setText(truyen.getName());
//        return view;
//    }
//
//
//    public class ViewHolder {
//        TextView tenTruyen;
//
//    }
//}
