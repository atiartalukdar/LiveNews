package co.livenews.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import co.livenews.app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TradingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TradingFragment extends Fragment {
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
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            counter = getArguments().getInt(ARG_COUNT);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_trading, container, false);
        if (counter==2){
            view = inflater.inflate(R.layout.fragment_lead, container, false);
        }

        return  view;
    }
    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //view.setBackgroundColor(ContextCompat.getColor(getContext(), COLOR_MAP[counter]));
        //TextView textViewCounter = view.findViewById(R.id.tv_counter);
        //textViewCounter.setText("Fragment No " + (counter+1));
    }
}