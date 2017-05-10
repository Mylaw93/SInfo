package com.example.mwars.sinfo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

/**
 * A fragment representing a single Subject detail screen.
 * This fragment is either contained in a {@link SubjectListActivity}
 * in two-pane mode (on tablets) or a {@link SubjectTaskActivity}
 * on handsets.
 */
public class SubjectTaskFragment extends Fragment implements SubjectTasklListAdapter.ItemClickCallback {

    private final static String TASK_BUDLE_EXTRAS = "TASK_BUDLE_EXTRAS";
    private final static String TASK_ID = "TASK_ID";
    private final static String SUBJECT_ID = "SUBJECT_ID";


    private static ArrayList<Task> _TASK_DATA = new ArrayList<>();
//    private static Map<String, Subject> _SUBJECT_DATA = new HashMap<>();
    private static Subject _SUBJECT;

    private SubjectTasklListAdapter subjectTasklListAdapter;

    public final static String ARG_ITEM_ID = "item_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            Activity activity = this.getActivity();
            AppBarLayout appBarLayout = (AppBarLayout) activity.findViewById(R.id.app_bar);
//            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
//                appBarLayout.setTitle(_SUBJECT.get_name());
            }
        }
    }


    public void initDataset() {
        String subID = getArguments().getString(ARG_ITEM_ID);
        _SUBJECT = SubjectContent.getMapItems().get(subID);
        _TASK_DATA = _SUBJECT.get_tasks();
//        _SUBJECT_DATA = SubjectContent.getMapItems();
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
        subjectTasklListAdapter = new SubjectTasklListAdapter(getActivity().getApplicationContext(), _TASK_DATA);
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

        if (_TASK_DATA.get(pos).isFavorite())
            _TASK_DATA.get(pos).setFavorite(false);
        else
            _TASK_DATA.get(pos).setFavorite(true);

//        subjectTasklListAdapter.setListData(_TASK_DATA);
        subjectTasklListAdapter.notifyDataSetChanged();
        SubjectFragment.subListAdapter.notifyDataSetChanged();
    }

    public void onEditImgClick(int pos) {
        Intent intent = new Intent(super.getContext(), SubjectTaskEditActivity.class);
        Bundle extras = new Bundle();
        extras.putInt(TASK_ID, _TASK_DATA.get(pos).get_id());
        extras.putInt(SUBJECT_ID, _SUBJECT.get_id());
        intent.putExtra(TASK_BUDLE_EXTRAS, extras);
        startActivity(intent);
    }

    @Override
    public void onIsDoneClick(int pos) {
        if (_TASK_DATA.get(pos).isDone())
            _TASK_DATA.get(pos).setDone(false);
        else
            _TASK_DATA.get(pos).setDone(true);
        subjectTasklListAdapter.notifyDataSetChanged();
        SubjectFragment.subListAdapter.notifyDataSetChanged();
    }
}