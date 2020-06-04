package co.livenews.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.livenews.app.R;
import co.livenews.app.models.TradingModel;

public class CategoryAdapter extends BaseAdapter {
    final String tag = getClass().getSimpleName() + "Atiar - ";
    private Context context;
    private Activity activity;
    private LayoutInflater inflater;
    private List<TradingModel> data;

    private final String TAG = getClass().getSimpleName() + " Atiar= ";

    public CategoryAdapter(Activity activity, List<TradingModel> data) {
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
        TradingModel tradingModel = data.get(position);

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, null);


/*
        TextView _website = convertView.findViewById(R.id.weebsite);
        Button _allNumbers = convertView.findViewById(R.id.allNumbersButton);
        Button _visitWebsite = convertView.findViewById(R.id.visitWebview);

*/

        //_website.setText(websitesModel.getWebsite());

/*
        _allNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(activity, NumberDialActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("website",websitesModel.getWebsite());
                intent.putExtra("websiteID",websitesModel.getWebsiteID());
                context.startActivity(intent);
            }
        });
*/


        return convertView;

    }

    //To update the searchView items in TransportList Activity
    public void update(List<TradingModel> resuls){
        data = new ArrayList<>();
        data.addAll(resuls);
        notifyDataSetChanged();
    }
}