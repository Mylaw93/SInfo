package com.example.mwars.sinfo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mwars.sinfo.R;
import com.example.mwars.sinfo.model.Subject;
import com.example.mwars.sinfo.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwars on 08.04.2017.
 */

public class SubjectListAdapter extends RecyclerView.Adapter<SubjectListAdapter.SubjectHolder> {

    private LayoutInflater _layInf;
    private Context _context;
    private List<Subject> _subList;

    private ItemClickCallback _itemClickCallback;



    public interface ItemClickCallback{
        void onItemClick(int pos);
        void onItemShareIconClick(int pos);
        void onItemEditIconClick(int pos);
    }


    public SubjectListAdapter(Context _context, ArrayList<Subject> _subList) {
        this._context = _context;
        this._subList = _subList;
        this._layInf = LayoutInflater.from(_context);
    }


    public void setItemClickCallback(final ItemClickCallback _itemClickCallback){
        this._itemClickCallback = _itemClickCallback;
    }


    @Override
    public SubjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Log.d("_HOLDER_:", "ON CREATE VIEW HOLDER");
        View view = this._layInf
                .inflate(R.layout.subject_list_content, parent, false);
        return new SubjectHolder(view);
    }


    @Override
    public void onBindViewHolder(SubjectHolder holder, int position) {
        Subject sub = this._subList.get(position);
//        Log.d("_ID_:", String.valueOf(sub.get_id()));
//        Log.d("_SEM_:", String.valueOf(sub.get_sem()));
//        Log.d("_NAME_:", String.valueOf(sub.get_name()));
//        Log.d("_DETAILS_:", String.valueOf(sub.get_details()));
//        Log.d("_HOLDER_ID_", String.valueOf(holder.getItemId()));
        holder.ID.setText(String.valueOf(sub.get_id()));
        holder.SEM.setText(String.valueOf(sub.get_sem()));
        holder.NAME.setText(sub.get_name());
        holder.DETAILS.setText(sub.get_details());
        int done = 0;
        for(Task t : sub.get_tasks()){
            if(t.isDone()){
                done += 1;
            }
        }
        String status = done + "/" + sub.get_tasks().size();
        holder.TASKS_STATUS.setText(status);
        holder.PROG_BAR.setMax(sub.get_tasks().size());
        holder.PROG_BAR.setProgress(done);
        holder.IMG_SHARE.setImageResource(R.drawable.ic_menu_share);
        holder.IMG_EDIT.setImageResource(R.drawable.ic_edit_doc);
//        holder.IMG_SHARE.setImageResource(android.R.drawable.ic_menu_share);
    }


    @Override
    public int getItemCount() {
        return _subList.size();
    }

    public class SubjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView ID, SEM, NAME, DETAILS, TASKS_STATUS;
        public ImageView IMG_SHARE, IMG_EDIT;
        public ProgressBar PROG_BAR;
        public View CONTAINER;

        public SubjectHolder(View itemView) {
            super(itemView);
            CONTAINER = (View) itemView.findViewById(R.id.subject_item_root);
            ID = (TextView) itemView.findViewById(R.id.text_id);
            SEM = (TextView) itemView.findViewById(R.id.text_sem);
            NAME = (TextView) itemView.findViewById(R.id.text_name);
            DETAILS = (TextView) itemView.findViewById(R.id.text_details);
            TASKS_STATUS = (TextView) itemView.findViewById(R.id.text_tasks_status);
            IMG_SHARE = (ImageView) itemView.findViewById(R.id.img_share_sub);
            IMG_EDIT = (ImageView) itemView.findViewById(R.id.img_edit_sub);
            PROG_BAR = (ProgressBar) itemView.findViewById(R.id.subject_progress_bar);

            CONTAINER.setOnClickListener(this);
            IMG_SHARE.setOnClickListener(this);
            IMG_EDIT.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.subject_item_root){
                _itemClickCallback.onItemClick(getAdapterPosition());
            } else if (view.getId() == R.id.img_share_sub) {
                _itemClickCallback.onItemShareIconClick(getAdapterPosition());
            } else if (view.getId() == R.id.img_edit) {
                _itemClickCallback.onItemEditIconClick(getAdapterPosition());
            }
        }
    }
}
