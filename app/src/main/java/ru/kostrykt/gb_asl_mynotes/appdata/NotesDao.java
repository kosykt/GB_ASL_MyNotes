package ru.kostrykt.gb_asl_mynotes.appdata;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.kostrykt.gb_asl_mynotes.notes.MyNote;

@Dao
public interface NotesDao {

    @Query("SELECT * FROM MyNote")
    List<MyNote> getAll();

    @Query("SELECT * FROM MyNote")
    LiveData<List<MyNote>> getAllLiveData();

    @Query("SELECT * FROM MyNote WHERE uniqueId IN (:noteIds)")
    List<MyNote> loadAllByIds(int[] noteIds);

    @Query("SELECT * FROM MyNote WHERE uniqueId = :uniqueId LIMIT 1")
    MyNote findById(int uniqueId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MyNote... note);

    @Delete
    void delete(MyNote note);

    @Update
    void update(MyNote note);
}
