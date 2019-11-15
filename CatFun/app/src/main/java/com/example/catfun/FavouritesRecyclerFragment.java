package com.example.catfun;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

public class FavouritesRecyclerFragment extends Fragment {

    private RequestQueue requestQueue;
    private ArrayList<Cat> catArrayList = new ArrayList<Cat>();

    public FavouritesRecyclerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_favourites, container, false);

        //initiating recyclerView
        final RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        recyclerView = frameLayout.findViewById(R.id.rv_favourites);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        //retrieving the favouriteCatArrayList
        catArrayList = MainActivity.favouritesCatArrayList;

        //populating the recyclerView with the list of favourited cats
        FavouritesAdapter favouritesAdapter = new FavouritesAdapter();
        favouritesAdapter.setData(catArrayList);
        recyclerView.setAdapter(favouritesAdapter);

        //returining the frameeLayout
        return frameLayout;
    }
}
