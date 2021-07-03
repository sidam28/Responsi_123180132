package com.example.responsi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.responsi.R;
import com.example.responsi.adapter.HarianAdapter;
import com.example.responsi.model.kasus.ContentItem;
import com.example.responsi.view.viewmodel.HarianViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HarianFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HarianFragment extends Fragment {

    private HarianAdapter harianAdapter;
    private RecyclerView recyclerView;
    private HarianViewModel harianViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HarianFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KasusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HarianFragment newInstance(String param1, String param2) {
        HarianFragment fragment = new HarianFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_harian, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        harianAdapter = new HarianAdapter(getContext());
        harianAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.fragment_harian_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

        harianViewModel = new ViewModelProvider(this).get(HarianViewModel.class);
        harianViewModel.setKasusData();
        harianViewModel.getKasusContentItem().observe(getViewLifecycleOwner(),getKasusItems);

        recyclerView.setAdapter(harianAdapter);
    }

    private Observer<ArrayList<ContentItem>> getKasusItems = new Observer<ArrayList<ContentItem>>() {
        @Override
        public void onChanged(ArrayList<ContentItem> contentItems) {
            if (contentItems!=null){
                harianAdapter.setData(contentItems);
            }
        }
    };

}