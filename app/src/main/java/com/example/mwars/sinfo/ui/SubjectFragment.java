package com.example.mwars.sinfo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mwars.sinfo.R;
import com.example.mwars.sinfo.SubjectTaskActivity;
import com.example.mwars.sinfo.adapter.SubjectListAdapter;
import com.example.mwars.sinfo.model.Subject;
import com.example.mwars.sinfo.model.SubjectContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwars on 08.04.2017.
 */

public class SubjectFragment extends Fragment  implements SubjectListAdapter.ItemClickCallback{

    private final static String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private final static String EXTRAS_ID = "EXTRAS_ID";

    private static ArrayList<Subject> _SUBJECT_DATA;
    private static Map<String, Subject> _SUBJECT_MAP = new HashMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }

    private void initDataset(){
        _SUBJECT_DATA = SubjectContent.getSubjectItems();
        _SUBJECT_MAP = SubjectContent.getMapItems();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.subject_list, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        assert recyclerView != null;
        SubjectListAdapter subListAdapter = new SubjectListAdapter(getActivity().getApplicationContext(), _SUBJECT_DATA);
        subListAdapter.setItemClickCallback(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(subListAdapter);
        return rootView;
//        setupRecyclerView(recyclerView);


//        return inflater.inflate(R.layout.subject_list, container, false);
    }

    @Override
    public void onItemClick(int pos) {
        Intent intent = new Intent(super.getContext(), SubjectTaskActivity.class);
        Bundle extras = new Bundle();
        extras.putInt(EXTRAS_ID, _SUBJECT_DATA.get(pos).get_id());
        intent.putExtra(BUNDLE_EXTRAS, extras);
        startActivity(intent);
    }

    @Override
    public void onItemIconClick(int pos) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,
                        _SUBJECT_DATA.get(pos).get_name() + " \n" +
                        _SUBJECT_DATA.get(pos).get_details());
        startActivity(Intent.createChooser(intent, "Udostępniasz: " + _SUBJECT_DATA.get(pos).get_name()));
    }
}


