package com.example.mwars.sinfo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mwars.sinfo.R;
import com.example.mwars.sinfo.SubjectListActivity;
import com.example.mwars.sinfo.SubjectTaskActivity;
import com.example.mwars.sinfo.SubjectTaskDetailActivity;
import com.example.mwars.sinfo.SubjectTaskEditActivity;
import com.example.mwars.sinfo.adapter.SubjectTasklListAdapter;
import com.example.mwars.sinfo.model.Subject;
import com.example.mwars.sinfo.model.SubjectContent;
import com.example.mwars.sinfo.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A fragment representing a single Subject detail screen.
 * This fragment is either contained in a {@link SubjectListActivity}
 * in two-pane mode (on tablets) or a {@link SubjectTaskActivity}
 * on handsets.
 */
public class SubjectTaskFragment extends Fragment implements SubjectTasklListAdapter.ItemClickCallback {

    private final static String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private final static String TASK_BUDLE_EXTRAS = "TASK_BUDLE_EXTRAS";
    private final static String EXTRAS_ID = "EXTRAS_ID";
    private final static String TASK_ID = "TASK_ID";
    private final static String SUBJECT_ID = "SUBJECT_ID";


    private static ArrayList<Task> _TASK_DATA = new ArrayList<>();
    private static Map<String, Subject> _SUBJECT_DATA = new HashMap<>();
    private static Subject _SUBJECT;

    private SubjectTasklListAdapter subjectTasklListAdapter;

    public final static String ARG_ITEM_ID = "item_id";
    public final static String ARG_TASK_ID = "task_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(_SUBJECT.get_name());

            }
        }
    }


    public void initDataset() {
        String subID = getArguments().getString(ARG_ITEM_ID);
        _SUBJECT = SubjectContent.getMapItems().get(subID);
        _TASK_DATA = _SUBJECT.get_tasks();
        _SUBJECT_DATA = SubjectContent.getMapItems();
//        Log.d("__SUB_ID_: ", subID);
//        Log.d("_SUBJECT_", _SUBJECT.get_name());
//        for (Task t : _TASK_DATA)
//            Log.d("LOG: ", t.toString());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.subject_task_list, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(android.R.id.list);
        assert recyclerView != null;
//        new SubjectTasklListAdapter(getActivity().getApplicationContext(), _TASK_DATA);
        subjectTasklListAdapter = new SubjectTasklListAdapter(getActivity().getApplicationContext(), _TASK_DATA);
//        subjectTasklListAdapter.setListData(_TASK_DATA);
        subjectTasklListAdapter.setItemClickCallback(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(subjectTasklListAdapter);
        return rootView;
    }

    @Override
    public void onItemClick(int pos) {
        Intent intent = new Intent(super.getContext(), SubjectTaskDetailActivity.class);
        Bundle extras = new Bundle();
        extras.putInt(TASK_ID, _TASK_DATA.get(pos).get_id());
        extras.putInt(SUBJECT_ID, _SUBJECT.get_id());
//        SubjectTaskDetailFragment fragment = new SubjectTaskDetailFragment();
//        fragment.setArguments(extras);
//        getActivity().getSupportFragmentManager().beginTransaction()
//                .replace(R.id.subject_detail_container, fragment).commit();

        intent.putExtra(TASK_BUDLE_EXTRAS, extras);
        Toast.makeText(super.getContext(), "_TASK_ID_" + String.valueOf(pos) + ": " + _TASK_DATA.get(pos).get_name() , Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

    @Override
    public void onFavImgClick(int pos) {
//        Log.d("_ON_FAV_IMG_:", String.valueOf(pos));
//        Log.d("_TASK_DATA_SIZE_:", String.valueOf(_TASK_DATA.size()));
//        for(Task t: _TASK_DATA){
//            Log.d("_TASK_NAME_:", t.get_name());
//        }
//        ImageView imgView = (ImageView) getActivity().findViewById(R.id.img_fav);
        Toast.makeText(super.getContext(), "_TASK_ID_" + String.valueOf(pos) + ": " + _TASK_DATA.get(pos).get_name() , Toast.LENGTH_LONG).show();

        Task task = _TASK_DATA.get(pos);

        if (task.isFavorite() == true) {
            task.setFavorite(false);
        } else {
            task.setFavorite(true);
        }

        subjectTasklListAdapter.setListData(_TASK_DATA);
        subjectTasklListAdapter.notifyDataSetChanged();

    }

//        Intent share = new Intent(Intent.ACTION_SEND);
//        share.setType("text/plain");
//        share.putExtra(Intent.EXTRA_SUBJECT, "Share you subject tasks");
//        int count = 3;
//        share.putExtra(Intent.EXTRA_TEXT, _SUBJECT_DATA.get(pos).get_name() + " \n" +
//                _SUBJECT_DATA.get(pos).get_details());
//
//
////        share.createChooser(share, "SHARE VIA MSGR");
//
//        startActivity(share);
//        Toast.makeText(super.getContext(), "ON ITEM ICON CLICK", Toast.LENGTH_LONG).show();

    public void onEditImgClick(int pos) {
        Intent intent = new Intent(super.getContext(), SubjectTaskEditActivity.class);
        Bundle extras = new Bundle();
        extras.putInt(TASK_ID, _TASK_DATA.get(pos).get_id());
        intent.putExtra(TASK_BUDLE_EXTRAS, extras);
        startActivity(intent);
    }
}