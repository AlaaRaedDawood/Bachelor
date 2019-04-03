package com.example.start;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class profileRepository {
    private profileDAO profiledao;
    private LiveData<List<ProfileTableDb>> allProfile;
    private int profileTableSize ;
    public profileRepository(Application application) {
        HiitDB database = HiitDB.getInstance(application);
        profiledao = database.profiledao();
        allProfile = profiledao.getProfile();
        profileTableSize = profiledao.getProfileRowsCount();
    }
    //Profile
    public void insertProfile(ProfileTableDb profileTableDb) {
        new profileRepository.InsertProfileAsyncTask(profiledao).execute(profileTableDb);
    }

    public void updateProfile(ProfileTableDb profileTableDb) {
        new profileRepository.UpdateProfileAsyncTask(profiledao).execute(profileTableDb);
    }

    public void deleteProfile(ProfileTableDb profileTableDb) {
        new profileRepository.DeleteProfileAsyncTask(profiledao).execute(profileTableDb);
    }


    public LiveData<List<ProfileTableDb>> getAllProfiles() {

        return allProfile;
    }
    public int getProfileTableSize() {

        return profileTableSize;
    }
    //Profile
    private static class InsertProfileAsyncTask extends AsyncTask<ProfileTableDb, Void, Void> {
        private profileDAO profiledao;

        private InsertProfileAsyncTask(profileDAO profiledao) {
            this.profiledao = profiledao;
        }

        @Override
        protected Void doInBackground(ProfileTableDb... profiles) {
            profiledao.insert(profiles[0]);
            return null;
        }
    }

    private static class UpdateProfileAsyncTask extends AsyncTask<ProfileTableDb, Void, Void> {
        private profileDAO profiledao;

        private UpdateProfileAsyncTask(profileDAO profiledao) {
            this.profiledao = profiledao;
        }

        @Override
        protected Void doInBackground(ProfileTableDb... profiles) {
            profiledao.update(profiles[0]);
            return null;
        }
    }
    private static class DeleteProfileAsyncTask extends AsyncTask<ProfileTableDb, Void, Void> {
        private profileDAO profiledao;

        private DeleteProfileAsyncTask(profileDAO profiledao) {
            this.profiledao = profiledao;
        }

        @Override
        protected Void doInBackground(ProfileTableDb... profiles) {
            profiledao.delete(profiles[0]);
            return null;
        }
    }

}
