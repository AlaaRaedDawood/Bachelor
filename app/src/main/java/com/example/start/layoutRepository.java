package com.example.start;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class layoutRepository {
    private layoutDAO layoutDao;
    private profileDAO profiledao;
    private LiveData<List<layoutTableDB>> allLayout;
    private LiveData<List<layoutTableDB>> checkedTrueLayout;
    private LiveData<List<ProfileTableDb>> allProfile;
    private LiveData<Integer> profileCount;
    public layoutRepository(Application application) {
        HiitDB database = HiitDB.getInstance(application);
        layoutDao = database.layoutdao();
        allLayout = layoutDao.getAllLayout();
        checkedTrueLayout = layoutDao.getCheckedTrueLayout();
        profiledao = database.profiledao();
        allProfile = profiledao.getProfile();
        profileCount = profiledao.getProfileRowsCount();

    }

    public void insert(layoutTableDB layoutTableDB) {
        new InsertNoteAsyncTask(layoutDao).execute(layoutTableDB);
    }

    public void update(layoutTableDB layoutTableDB) {
        new UpdateNoteAsyncTask(layoutDao).execute(layoutTableDB);
    }

    public void delete(layoutTableDB layoutTableDB) {
        new DeleteNoteAsyncTask(layoutDao).execute(layoutTableDB);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask(layoutDao).execute();
    }

    public LiveData<List<layoutTableDB>> getAllLayouts() {
        return allLayout;
    }
    public LiveData<List<layoutTableDB>> getCheckedTrueLayout() {
        return checkedTrueLayout;
    }
    //Profile
    public void insertProfile(ProfileTableDb profileTableDb) {
        new layoutRepository.InsertProfileAsyncTask(profiledao).execute(profileTableDb);
    }

    public void updateProfile(ProfileTableDb profileTableDb) {
        new layoutRepository.UpdateProfileAsyncTask(profiledao).execute(profileTableDb);
    }

    public void deleteProfile(ProfileTableDb profileTableDb) {
        new layoutRepository.DeleteProfileAsyncTask(profiledao).execute(profileTableDb);
    }

    public LiveData<Integer> getProfileRowsCount(){
        Log.i("DB" , ""+ profileCount);
        return profileCount ;
    }

    public LiveData<List<ProfileTableDb>> getAllProfiles() {

        return allProfile;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<layoutTableDB, Void, Void> {
        private layoutDAO layoutDao;

        private InsertNoteAsyncTask(layoutDAO layoutDao) {
            this.layoutDao = layoutDao;
        }

        @Override
        protected Void doInBackground(layoutTableDB... layouts) {
            layoutDao.insert(layouts[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<layoutTableDB, Void, Void> {
        private layoutDAO layoutDao;

        private UpdateNoteAsyncTask(layoutDAO layoutDao) {
            this.layoutDao = layoutDao;
        }

        @Override
        protected Void doInBackground(layoutTableDB... layouts) {
            layoutDao.update(layouts[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<layoutTableDB, Void, Void> {
        private layoutDAO layoutDao;

        private DeleteNoteAsyncTask(layoutDAO layoutDao) {
            this.layoutDao = layoutDao;
        }

        @Override
        protected Void doInBackground(layoutTableDB... layouts){
            layoutDao.delete(layouts[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private layoutDAO layoutDao;

        private DeleteAllNotesAsyncTask(layoutDAO layoutDao) {
            this.layoutDao = layoutDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            layoutDao.deleteAllNotes();
            return null;
        }
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
