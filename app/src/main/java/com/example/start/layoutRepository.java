package com.example.start;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

public class layoutRepository {
    private layoutDAO layoutDao;
    private LiveData<List<layoutTableDB>> allLayout;

    public layoutRepository(Application application) {
        HiitDB database = HiitDB.getInstance(application);
        layoutDao = database.layoutdao();
        allLayout = layoutDao.getAllLayout();
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
}