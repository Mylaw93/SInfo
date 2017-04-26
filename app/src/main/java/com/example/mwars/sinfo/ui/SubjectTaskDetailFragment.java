package com.example.mwars.sinfo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mwars.sinfo.R;
import com.example.mwars.sinfo.model.SubjectContent;
import com.example.mwars.sinfo.model.Task;

/**
 * Created by mwars on 26.04.2017.
 */

public class SubjectTaskDetailFragment extends Fragment {

    private final static String TASK_ID = "TASK_ID";
    private final static String SUBJECT_ID = "SUBJECT_ID";

    private Task _TASK;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        initDataset();
        super.onCreate(savedInstanceState);
    }

    private void initDataset() {
        int taskID = getArguments().getInt(TASK_ID);
        int subID = getArguments().getInt(SUBJECT_ID);
        Log.d("_TASK ID:" + taskID, "\n_SUB_ID:" + subID);
        _TASK = SubjectContent.getMapItems().get(String.valueOf(subID)).get_tasks().get(taskID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.subject_task_detail, container, false);
        LinearLayout ll = (LinearLayout) rootView.findViewById(R.id.linear_layout);
        assert ll != null;
        return rootView;

//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
