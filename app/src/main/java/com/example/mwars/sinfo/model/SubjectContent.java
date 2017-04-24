package com.example.mwars.sinfo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwars on 08.04.2017.
 */

public class SubjectContent {

    public static final ArrayList<Subject> SUBJECT_ITEMS = new ArrayList<Subject>();
    public static final Map<String, Subject> SUBJECT_MAP = new HashMap<String, Subject>();

//    static {
//        for (Subject s : getSubList()) {
//            addItem(s);
//            Log.d("___SUBJECT: ", s.get_id() + ". " + s.get_name());
//        }
//    }

    static {
        Subject sub = new Subject(1, 1, "Podstawy programowania komputerów", "PPK to w skrócie podstawy programowania");

        Task task = new Task(1,sub.get_id(),1,"Stworzyć stronę internetową",
                "Zaliczenie polega na stworzeniu strony internetowej za pomocą wybranych przez nas narzędzi wraz z użyciem bazy danych MySQL");
        task.setFavorite(true);

        Task task1 = new Task(2,sub.get_id(),1,"Stworzyć aplikację internetową",
                "Zaliczenie polega na stworzeniu aplikacji internetowej za pomocą JavaScript");
        task1.setFavorite(false);
        task1.setDone(true);

        Task task2 = new Task(3,sub.get_id(),1,"Stworzyć aplikację mobilną",
                "Zaliczenie polega na stworzeniu strony aplikacji mobilnej na platformę Android przy użyciu frameworka Hibernate");
        task2.setFavorite(true);
        task2.setDone(true);

        sub.addTask(task);
        sub.addTask(task1);
        sub.addTask(task2);

        sub.addTask(new Task(4,sub.get_id(),2,"Dokumentacja techniczna projektu",
                "Przesłać dokumentacje techniczną projektu na wirtualnej uczelni"));
        sub.addTask(new Task(5,sub.get_id(),2,"Dokumentacja uzytkowa projektu",
                "Przeslać dokumentacje użytkownika końcowego projektu na wirtualnej uczelni"));
        sub.addTask(new Task(6,sub.get_id(),3,"Test z calego semestru",
                "Test z całego semestru"));

        addItem(sub);

        Subject sub1 = new Subject(2, 6, "Programowanie obiektowe", "Programowanie obiektowe w języku Java, wykorzystanie dziedziczenia, polimorfizmu oraz hermetyzacji danych");
        sub1.addTask(new Task(1,sub1.get_id(),1,"Stworzyć stronę internetową",
                "Zaliczenie polega na stworzeniu strony internetowej za pomocą wybranych przez nas narzędzi wraz z użyciem bazy danych MySQL"));
        sub1.addTask(new Task(2,sub1.get_id(),1,"Stworzyć aplikację internetową",
                "Zaliczenie polega na stworzeniu aplikacji internetowej za pomocą JavaScript"));
        sub1.addTask(new Task(3,sub1.get_id(),1,"Stworzyć aplikację mobilną",
                "Zaliczenie polega na stworzeniu strony aplikacji mobilnej na platformę Android przy użyciu frameworka Hibernate"));
        addItem(sub1);
//        addItem(new Subject(1, 1, "Podstawy programowania komputerów", "PPK to w skrócie podstawy programowania"));
//        addItem(new Subject(2, 3, "Programowanie obiektowe", "Programowanie obiektowe w języku Java, wykorzystanie dziedziczenia, polimorfizmu oraz hermetyzacji danych"));
        addItem(new Subject(3, 4, "Grafika komputerowa", "Grafika komputerowa w tym tworzenie gier, architektur, ikon etc."));
        addItem(new Subject(4, 5, "Język Angielski", "Sprawdzenie umiejętności z posługiwania się językiem angielskim na poziomie średniozaawansowanym B1"));
        addItem(new Subject(5, 1, "Podstawy programowania komputerów", "PPK to w skrócie podstawy programowania"));
        addItem(new Subject(6, 3, "Programowanie obiektowe", "Programowanie obiektowe w języku Java, wykorzystanie dziedziczenia, polimorfizmu oraz hermetyzacji danych"));
        addItem(new Subject(7, 4, "Grafika komputerowa", "Grafika komputerowa w tym tworzenie gier, architektur, ikon etc."));
        addItem(new Subject(8, 1, "Podstawy programowania komputerów", "PPK to w skrócie podstawy programowania"));
        addItem(new Subject(9, 3, "Programowanie obiektowe", "Programowanie obiektowe w języku Java, wykorzystanie dziedziczenia, polimorfizmu oraz hermetyzacji danych"));
        addItem(new Subject(10, 4, "Grafika komputerowa", "Grafika komputerowa w tym tworzenie gier, architektur, ikon etc."));
        addItem(new Subject(11, 5, "Język Angielski", "Sprawdzenie umiejętności z posługiwania się językiem angielskim na poziomie średniozaawansowanym B1"));
        addItem(new Subject(12, 1, "Podstawy programowania komputerów", "PPK to w skrócie podstawy programowania"));
        addItem(new Subject(13, 3, "Programowanie obiektowe", "Programowanie obiektowe w języku Java, wykorzystanie dziedziczenia, polimorfizmu oraz hermetyzacji danych"));
        addItem(new Subject(14, 4, "Grafika komputerowa", "Grafika komputerowa w tym tworzenie gier, architektur, ikon etc."));
        addItem(new Subject(15, 5, "Język Angielski", "Sprawdzenie umiejętności z posługiwania się językiem angielskim na poziomie średniozaawansowanym B1"));
    }

    public static ArrayList<Subject> getSubjectItems(){
        return SUBJECT_ITEMS;
    }
    public static Map<String, Subject> getMapItems() { return SUBJECT_MAP; }

    private static void addItem(Subject item){
        SUBJECT_ITEMS.add(item);
        SUBJECT_MAP.put(String.valueOf(item.get_id()), item);
    }
}
