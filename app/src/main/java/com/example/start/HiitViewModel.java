package com.example.start;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class HiitViewModel extends AndroidViewModel {
    private  layoutRepository layoutrepository;
    private  performanceRepository performancerepository;
    private LiveData<List<layoutTableDB>> allLayouts;
    private LiveData<List<ProfileTableDb>> allProfiles;
    private LiveData<Integer>   profileTableSize ;
    private LiveData<List<PerformanceTableDB>> allPerformance;
    private LiveData<Integer>   performanceTablesize ;
    public HiitViewModel(@NonNull Application application) {
        super(application);
        layoutrepository = new layoutRepository(application);
        performancerepository = new performanceRepository(application);
        allLayouts = layoutrepository.getAllLayouts();
        allProfiles =  layoutrepository.getAllProfiles();
        profileTableSize = layoutrepository.getProfileRowsCount();
        allPerformance = performancerepository.getAllPerformnce();
        performanceTablesize = performancerepository.getPerformanceCount();
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
    public LiveData<Integer>   getProfileSize() {
        return profileTableSize ;
    }
    //performance
    public void insertPerformance(PerformanceTableDB performance) {
        performancerepository.insertPerformance(performance);
    }

    public void updatePerformance(PerformanceTableDB performance) {
        performancerepository.updatePerformance(performance);
    }

    public void deletePerformance(PerformanceTableDB performance) {
        performancerepository.deletePerformance(performance);
    }

    public LiveData<List<PerformanceTableDB>> getAllPerformance() {
        return allPerformance ;
    }
    public LiveData<Integer>   getPerformanceSize() {
        return performanceTablesize ;
    }
}
