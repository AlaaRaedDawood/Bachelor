package com.example.start;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class HiitViewModel extends AndroidViewModel {
    private  layoutRepository layoutrepository;
    private LiveData<List<layoutTableDB>> allLayouts;

    public HiitViewModel(@NonNull Application application) {
        super(application);
        layoutrepository = new layoutRepository(application);
        allLayouts = layoutrepository.getAllLayouts();
    }

    public void insert(layoutTableDB layout) {
        layoutrepository.insert(layout);
    }

    public void update(layoutTableDB layout) {
        layoutrepository.update(layout);
    }

    public void delete(layoutTableDB layout) {
        layoutrepository.delete(layout);
    }
    public void deleteAllNotes() {
        layoutrepository.deleteAllNotes();

    }
    public LiveData<List<layoutTableDB>> getAllLayouts() {
        return allLayouts;
    }
}
