package com.example.mwars.sinfo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mwars.sinfo.R;
import com.example.mwars.sinfo.model.Task;

import java.util.ArrayList;

/**
 * Created by mwars on 11.04.2017.
 */

public class SubjectTasklListAdapter extends RecyclerView.Adapter<SubjectTasklListAdapter.SubjectDetailHolder> {
    private LayoutInflater _layInf;
    private Context _context;
    private ArrayList<Task> _taskList;

    private ItemClickCallback _itemClickCallback;

    public void setItemClickCallback(final ItemClickCallback _itemClickCallback){
        this._itemClickCallback = _itemClickCallback;
    }

    public interface ItemClickCallback{
        void onItemClick(int pos);
        void onFavImgClick(int pos);
        void onEditImgClick(int pos);
        void onIsDoneClick(int pos);
    }

    public SubjectTasklListAdapter(Context _context){
        this._context = _context;
        this._layInf = LayoutInflater.from(_context);
    }

    public SubjectTasklListAdapter(Context _context, ArrayList<Task> _taskList) {
        this._context = _context;
        this._taskList = _taskList;
        this._layInf = LayoutInflater.from(_context);

    }

    public void setListData(ArrayList<Task> taskList) {
//        Log.d("__LIST_SIZE_BEFORE: ", String.valueOf(this._taskList.size()));
//        Log.d("__LIST_PARAM_SIZE ", String.valueOf(taskList.size()));
//        this._taskList.clear();
        this._taskList.clear();
        this._taskList.addAll(taskList);
//        Log.d("__LIST_SIZE_AFTER: ", String.valueOf(_taskList.size()));
    }


    @Override
    public SubjectDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Log.d("_HOLDER_:", "ON CREATE VIEW HOLDER");
        View view = this._layInf.inflate(R.layout.subject_task_list_content, parent, false);
        return new SubjectDetailHolder(view);
    }


    @Override
    public void onBindViewHolder(SubjectDetailHolder holder, int position) {
        Task task = this._taskList.get(position);
//        Log.d("_ID_:", String.valueOf(sub.get_id()));
//        Log.d("_SEM_:", String.valueOf(sub.get_sem()));
//        Log.d("_NAME_:", String.valueOf(sub.get_name()));
//        Log.d("_DETAILS_:", String.valueOf(sub.get_details()));
//        Log.d("_HOLDER_ID_", String.valueOf(holder.getItemId()));
        holder.ID.setText(String.valueOf(task.get_id()));
        holder.SUB_ID.setText(String.valueOf(task.get_subjectId()));
        holder.GROUP_ID.setText(String.valueOf(task.get_taskGroupId()));
        holder.NAME.setText(task.get_name());
        holder.DETAILS.setText(task.get_desc());
        if (task.isDone())
            holder.IS_DONE.setChecked(true);
        else
            holder.IS_DONE.setChecked(false);
        if (task.isFavorite())
            holder.IMG_FAV.setImageResource(android.R.drawable.btn_star_big_on);
        else
            holder.IMG_FAV.setImageResource(android.R.drawable.btn_star_big_off);
        holder.IMG_EDIT.setImageResource(R.drawable.ic_menu_manage);
    }


    @Override
    public int getItemCount() {
        return _taskList.size();
    }


    public class SubjectDetailHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView ID, SEM, SUB_ID, GROUP_ID, NAME, DETAILS;
        public ImageView IMG_FAV, IMG_EDIT;
        public CheckBox IS_DONE;
        public View CONTAINER;

        public SubjectDetailHolder(View itemView) {
            super(itemView);
            CONTAINER = itemView.findViewById(R.id.subject_detail_item_root);
            ID = (TextView) itemView.findViewById(R.id.text_id);
            SUB_ID = (TextView) itemView.findViewById(R.id.text_sub_id);
            GROUP_ID = (TextView) itemView.findViewById(R.id.text_group_id);
            SEM = (TextView) itemView.findViewById(R.id.text_sem);
            NAME = (TextView) itemView.findViewById(R.id.text_name);
            DETAILS = (TextView) itemView.findViewById(R.id.text_details);
            IMG_FAV = (ImageView) itemView.findViewById(R.id.img_fav);
            IMG_EDIT = (ImageView) itemView.findViewById(R.id.img_edit);
            IS_DONE = (CheckBox) itemView.findViewById(R.id.check_box_is_done);

            CONTAINER.setOnClickListener(this);
            IMG_FAV.setOnClickListener(this);
            IMG_EDIT.setOnClickListener(this);
            IS_DONE.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.subject_detail_item_root){
                _itemClickCallback.onItemClick(getAdapterPosition());
            } else if (view.getId() == R.id.img_fav) {
                _itemClickCallback.onFavImgClick(getAdapterPosition());
            } else if (view.getId() == R.id.img_edit) {
                _itemClickCallback.onEditImgClick(getAdapterPosition());
            } else if (view.getId() == R.id.switch_is_done) {
                _itemClickCallback.onIsDoneClick(getAdapterPosition());
            }
        }
    }


}
