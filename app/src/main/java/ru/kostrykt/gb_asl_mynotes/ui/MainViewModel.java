package ru.kostrykt.gb_asl_mynotes.ui;

import androidx.lifecycle.LiveData;

import java.util.List;

import ru.kostrykt.gb_asl_mynotes.App;
import ru.kostrykt.gb_asl_mynotes.notes.MyNote;

public class MainViewModel {

    private LiveData<List<MyNote>> myNotesLiveData = App.getInstance().getNotesDao().getAllLiveData();

    public LiveData<List<MyNote>> getMyNotesLiveData() {
        return myNotesLiveData;
    }
}
