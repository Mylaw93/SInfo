package com.example.mwars.sinfo.model;

/**
 * Created by mwars on 08.04.2017.
 */

import java.util.ArrayList;


public class Subject {

    private int _id, _sem;
    private String _name, _details;
    private boolean _isFav;
    private ArrayList<Task> _lsTasks = new ArrayList<>();


    public Subject(){}

    public Subject(int _id, int _sem, String _name, String _details){
        this._id = _id;
        this._sem = _sem;
        this._name = _name;
        this._details = _details;
        this._isFav = false;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_sem() {
        return _sem;
    }

    public void set_sem(int _sem) {
        this._sem = _sem;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_details() {
        return _details;
    }

    public void set_details(String _details) {
        this._details = _details;
    }

    public ArrayList<Task> get_tasks(){
        return this._lsTasks;
    }

    public void addTask(Task task){
        _lsTasks.add(task);
    }

    public void setFavorite(boolean _isFav){
        this._isFav = _isFav;
    }

    public boolean isFavorite(){
        return _isFav;
    }

    public String getTaskList(){
        StringBuilder sb = new StringBuilder();
        for(Task t : _lsTasks){
            sb.append(t.get_id() + "\n");
            sb.append(t.get_name() + "\n");
        }
        return sb.toString();
    }
}
