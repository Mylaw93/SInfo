package com.example.mwars.sinfo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwars on 08.04.2017.
 */

public class TaskContent {

    public static final ArrayList<Subject> TASK_ITEMS = new ArrayList<Subject>();
    public static final Map<String, Subject> TASKS_MAP = new HashMap<String, Subject>();

//    static {
//        for (Subject s : getSubList()) {
//            addItem(s);
//            Log.d("___SUBJECT: ", s.get_id() + ". " + s.get_name());
//        }
//    }

    static {
    }

    public static ArrayList<Subject> getSubjectItems(){
        return TASK_ITEMS;
    }
    public static Map<String, Subject> getMapItems() { return TASKS_MAP; }

    private static void addItem(Subject item){
        TASK_ITEMS.add(item);
        TASKS_MAP.put(String.valueOf(item.get_id()), item);
    }
}
