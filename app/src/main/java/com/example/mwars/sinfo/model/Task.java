package com.example.mwars.sinfo.model;

/**
 * Created by mwars on 08.04.2017.
 */

public class Task {

    private int _id, _subjectId, _taskGroupId;
    private String _name, _desc;
    private boolean _isFav, _isDone;

    public Task(int _id, int _subjectId, int _taskGroupId, String _name, String _desc) {
        this._id = _id;
        this._subjectId = _subjectId;
        this._taskGroupId = _taskGroupId;
        this._name = _name;
        this._desc = _desc;
        this._isFav = false;
        this._isDone = false;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_subjectId() {
        return _subjectId;
    }

    public void set_subjectId(int _subjectId) {
        this._subjectId = _subjectId;
    }

    public int get_taskGroupId() {
        return _taskGroupId;
    }

    public void set_taskGroupId(int _taskGroupId) {
        this._taskGroupId = _taskGroupId;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
    }


    public void setFavorite(boolean _isFav){ this._isFav = _isFav; }

    public boolean isFavorite(){
        return _isFav;
    }

    public void setDone(boolean _isDone){ this._isDone = _isDone; }

    public boolean isDone() { return _isDone; }

    @Override
    public String toString(){
        return "ID: " + String.valueOf(get_id()) + "\n"
                + "SUB_ID: " + String.valueOf(get_subjectId()) + "\n"
                + "NAME: " + get_name() + "\n"
                + "isFAV: " + isFavorite() + "\n"
                + "isDONE: " + isDone();
    }


}

