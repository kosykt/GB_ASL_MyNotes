package ru.kostrykt.gb_asl_mynotes.appdata;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.kostrykt.gb_asl_mynotes.notes.MyNote;

@Database(entities = {MyNote.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract NotesDao notesDao();
}
