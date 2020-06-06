package co.livenews.app.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.hbb20.CountryCodePicker;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.List;

import co.livenews.app.R;
import co.livenews.app.adapter.CategoryAdapter;
import co.livenews.app.models.SubmitData;
import co.livenews.app.models.TradingModel;
import co.livenews.app.retrofit.APIManager;
import co.livenews.app.retrofit.RequestListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TradingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TradingFragment extends Fragment {
    private final String TAG = getClass().getName() + " Atiar - ";
    EditText _name,_phone;
    String _country;
    CountryCodePicker ccp;
    APIManager _apiManager;
    ListView listView;
    CategoryAdapter categoryAdapter;

    List<TradingModel.AllRecord> tradingModelList = new ArrayList<>();;

    private static final String ARG_COUNT = "param1";
    private Integer counter;
    private int[] COLOR_MAP = {
            R.color.red_100, R.color.red_300, R.color.red_500, R.color.red_700, R.color.blue_100,
            R.color.blue_300, R.color.blue_500, R.color.blue_700, R.color.green_100, R.color.green_300,
            R.color.green_500, R.color.green_700
    };

    public TradingFragment() {
        // Required empty public constructor
    }

    public static TradingFragment newInstance(Integer counter) {
        TradingFragment fragment = new TradingFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COUNT, counter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _apiManager = new APIManager();
        if (getArguments() != null) {
            counter = getArguments().getInt(ARG_COUNT);
        }
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_trading, container, false);
        switch (counter){
            case 0:
                categoryFragment(view,"24");
                break;
            case 1:
                categoryFragment(view,"25");
                break;
            case 2:
                view = inflater.inflate(R.layout.fragment_lead, container, false);
                leadFragment(view);
                break;
        }

        return  view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //view.setBackgroundColor(ContextCompat.getColor(getContext(), COLOR_MAP[counter]));
        //TextView textViewCounter = view.findViewById(R.id.tv_counter);
        //textViewCounter.setText("Fragment No " + (counter+1));
    }

    public void showDialog(String title, String message) {
        AlertDialog alert;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alert = builder.create();
        alert.show();
    }

    private void leadFragment(View view){
        _name = view.findViewById(R.id.name);
        _phone = view.findViewById(R.id.phone);
        ccp = view.findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(_phone);
        _country = ccp.getSelectedCountryName();

        Button submitButton = view.findViewById(R.id.submitLead);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()){
                    _apiManager.sendLead(_name.getText().toString() + "", ccp.getFullNumberWithPlus(), ccp.getSelectedCountryName(), new RequestListener<SubmitData>() {
                        @Override
                        public void onSuccess(SubmitData response) {
                            if (response !=  null && response.getStatus().equals("ok")){
                                showDialog(getResources().getString(R.string.thank_you_ar)+ _name.getText().toString(),getResources().getString(R.string.submit_ar));
                                _name.setText("");
                                _phone.setText("");
                            }
                        }

                        @Override
                        public void onError(Throwable t) {
                            showDialog("Please try again later" + _name.getText().toString(),"Something is wrong. \n"+t.getMessage());
                        }
                    });
                }
            }
        });
    }

    private void categoryFragment(View view, String categoryID) {
        listView = view.findViewById(R.id.listView);
        categoryAdapter = new CategoryAdapter(getActivity(), tradingModelList,categoryID);
        listView.setAdapter(categoryAdapter);
        final KProgressHUD kProgressHUD = KProgressHUD.create(getActivity())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel(getResources().getString(R.string.please_wait_ar))
                .setDetailsLabel(getResources().getString(R.string.downloadin_ar))
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();

        _apiManager.getArticleList(categoryID, "DESC", new RequestListener<TradingModel>() {
            @Override
            public void onSuccess(TradingModel response) {
                kProgressHUD.dismiss();
                Log.e(TAG, response.getStatus());
                if (response!=null && response.getStatus().equals("ok")){
                    //List<TradingModel.AllRecord> allRecords = response.getAllRecord();
                    tradingModelList.clear();
                    tradingModelList.addAll(response.getAllRecord());
                    Log.e(TAG, tradingModelList.size()+"");
                    categoryAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(Throwable t) {
                kProgressHUD.dismiss(); }
        });
    }

    private boolean validateInput(){
        boolean v = false;
        String n = _name.getText().toString();
        String p = _phone.getText().toString();

        if (_name == null || n == null || n.equals("")){
            _name.setError("خطأ");
            v = false;
        }else {
            _name.setError(null);
            v=true;
        }

        if (_phone == null || p == null || p.equals("")){
            _phone.setError("خطأ");
            v = false;
        }else {
            _phone.setError(null);
            v=true;
        }

        return v;
    }
}