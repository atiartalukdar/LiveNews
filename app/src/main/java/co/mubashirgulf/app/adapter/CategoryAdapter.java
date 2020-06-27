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

public class CategoryAdapter extends BaseAdapter {
    final String tag = getClass().getSimpleName() + "Atiar - ";
    private Context context;
    private Activity activity;
    private LayoutInflater inflater;
    private List<TradingModel.AllRecord> data;
    private String id;

    private final String TAG = getClass().getSimpleName() + " Atiar= ";

    public CategoryAdapter(Activity activity, List<TradingModel.AllRecord> data, String id) {
        this.activity = activity;
        this.data = data;
        this.id = id;
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
        final TradingModel.AllRecord tradingModel = data.get(position);

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, null);



        LinearLayout _item = convertView.findViewById(R.id.item);
        TextView _title = convertView.findViewById(R.id.titleText);
        TextView _date = convertView.findViewById(R.id.publishedDate);
        ShapeableImageView _image = convertView.findViewById(R.id.titleImage);

        _title.setText(tradingModel.getPostTitle());
        _date.setText(tradingModel.getPostDate());

        Picasso.get()
                .load(tradingModel.getImage())
                .centerCrop()
                .fit()
                .into(_image);

        _item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(activity, ArticleActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("img",tradingModel.getImage());
                intent.putExtra("art",tradingModel.getPostContent());
                intent.putExtra("postLink",tradingModel.getPostLink());
                context.startActivity(intent);
            }
        });



        return convertView;

    }

    //To update the searchView items in TransportList Activity
    public void update(List<TradingModel.AllRecord> resuls){
        data = new ArrayList<>();
        data.addAll(resuls);
        notifyDataSetChanged();
    }
}