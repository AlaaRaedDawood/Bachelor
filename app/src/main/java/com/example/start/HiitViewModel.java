package com.example.start;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class HiitViewModel extends AndroidViewModel {
    private  layoutRepository layoutrepository;
    //private  profileRepository profilerepository;
    private LiveData<List<layoutTableDB>> allLayouts;
    private LiveData<List<ProfileTableDb>> allProfiles;
    private int profileTableSize ;
    public HiitViewModel(@NonNull Application application) {
        super(application);
        layoutrepository = new layoutRepository(application);
        //profilerepository = new profileRepository(application);
        allLayouts = layoutrepository.getAllLayouts();
        allProfiles =  layoutrepository.getAllProfiles();
        //profileTableSize = layoutrepository.getProfileTableSize();
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
    //Profile
    public void insertProfile(ProfileTableDb profile) {
        layoutrepository.insertProfile(profile);
    }

    public void updateProfile(ProfileTableDb profile) {
        layoutrepository.updateProfile(profile);
    }

    public void deleteProfile(ProfileTableDb profile) {
        layoutrepository.deleteProfile(profile);
    }

    public LiveData<List<ProfileTableDb>> getAllProfiles() {
        return allProfiles ;
    }
    public int getProfileSize() {
        return profileTableSize ;
    }
}
