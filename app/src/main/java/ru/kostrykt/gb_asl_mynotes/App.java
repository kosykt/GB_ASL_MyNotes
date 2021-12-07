package ru.kostrykt.gb_asl_mynotes;

import android.app.Application;

import androidx.room.Room;

import ru.kostrykt.gb_asl_mynotes.appdata.AppDataBase;
import ru.kostrykt.gb_asl_mynotes.appdata.NotesDao;

public class App extends Application {

    private AppDataBase dataBase;
    private NotesDao notesDao;

    private static App instance;

    public static App getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        dataBase = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class, "myWH")
                .allowMainThreadQueries()
                .build();

        notesDao = dataBase.notesDao();
    }

    public AppDataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(AppDataBase dataBase) {
        this.dataBase = dataBase;
    }

    public NotesDao getNotesDao() {
        return notesDao;
    }

    public void setNotesDao(NotesDao notesDao) {
        this.notesDao = notesDao;
    }
}
