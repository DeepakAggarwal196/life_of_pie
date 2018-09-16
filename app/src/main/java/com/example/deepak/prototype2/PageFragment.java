package com.example.deepak.prototype2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Product> productList;
    List<StepsCard> stepsList;
    StepsAdapter stepsAdapter;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(mPage==1)
        {
            View view1 = inflater.inflate(R.layout.fragment_location_tracker, container, false);
            productList = new ArrayList<>();
            recyclerView = (RecyclerView) view1;
            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            productList.add(
                    new Product(
                            5,
                            "15 May",
                            "1 hr 20 min",
                            "Friday",
                            "Steps",
                            "Calories",
                            R.drawable.calendar,
                            R.drawable.car));

            productList.add(
                    new Product(
                            5,
                            "SLEEP",
                            "22:31 - 07:08",
                            "8 hr 39 min",
                            "0",
                            "0",
                            R.drawable.moon));

            productList.add(
                    new Product(
                            1,
                            "HOME",
                            "07:08 - 08:36",
                            "1 hr 28 min",
                            "321",
                            "31",
                            R.drawable.home));

            productList.add(
                    new Product(
                            2,
                            "WORK",
                            "09:06 - 17:18",
                            "8 hr 12 min",
                            "1056",
                            "92",
                            R.drawable.luggage));

            productList.add(
                    new Product(
                            3,
                            "Café Coffee Day",
                            "17:32 - 18:08",
                            "36 min",
                            "86",
                            "8",
                            R.drawable.coffee));

            productList.add(
                    new Product(
                            4,
                            "GYM",
                            "18:32 - 20:01",
                            "1 hr 29 min",
                            "4020",
                            "322",
                            R.drawable.gym));

            productList.add(
                    new Product(
                            5,
                            "HOME",
                            "20:21 - 22:42",
                            "1 hr 21 min",
                            "255",
                            "47",
                            R.drawable.home));
            adapter = new ProductAdapter(getActivity(), productList);
            recyclerView.setAdapter(adapter);
            return view1;
        }
        else if(mPage == 2)
        {
            View stepsTabView = inflater.inflate(R.layout.fragment_steps, container, false);
            stepsList = new ArrayList<>();
            recyclerView = (RecyclerView) stepsTabView;
            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


            stepsList.add(
                    new StepsCard(
                            1,
                            1,
                            "5468"));

            stepsList.add(
                    new StepsCard(
                            2,
                            2,
                            "456"));


            stepsAdapter = new StepsAdapter(getActivity(), stepsList);
            recyclerView.setAdapter(stepsAdapter);
            return stepsTabView;
        }
        else{
            View view = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) view;
            textView.setText("Fragment #" + mPage);
            return view;


        }

    }
}
