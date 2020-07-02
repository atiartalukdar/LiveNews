package co.mubashirgulf.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import co.mubashirgulf.app.ArticleActivity;
import co.mubashirgulf.app.R;
import co.mubashirgulf.app.models.TradingModel;

public class CommentAdapter extends BaseAdapter {
    final String tag = getClass().getSimpleName() + "Atiar - ";
    private Context context;
    private Activity activity;
    private LayoutInflater inflater;
    private List<TradingModel.Comment> data;

    private final String TAG = getClass().getSimpleName() + " Atiar= ";

    public CommentAdapter(Activity activity, List<TradingModel.Comment> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int location) {
        return data.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = activity.getApplicationContext();
        final TradingModel.Comment tradingModel = data.get(position);

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item_comment, null);



        LinearLayout _item = convertView.findViewById(R.id.item);
        TextView _author = convertView.findViewById(R.id.author);
        TextView _title = convertView.findViewById(R.id.content);
        TextView _date = convertView.findViewById(R.id.publishedDate);

        _author.setText(tradingModel.getCommentAuthor());
        _title.setText(tradingModel.getCommentContent());
        _date.setText(tradingModel.getCommentDate());

        return convertView;

    }

    //To update the searchView items in TransportList Activity
    public void update(List<TradingModel.Comment> resuls){
        data = new ArrayList<>();
        data.addAll(resuls);
        notifyDataSetChanged();
    }
}