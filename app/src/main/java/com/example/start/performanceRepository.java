package com.example.start;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class performanceRepository {
    private PerformanceDAO performancedao;
    private LiveData<List<PerformanceTableDB>> allPerformance;
    private LiveData<Integer> performanceCount;
    public performanceRepository(Application application) {
        HiitDB database = HiitDB.getInstance(application);
        performancedao = database.performancedao();
        allPerformance = performancedao.getPerformance();
        performanceCount = performancedao.getPerformanceRowsCount();
    }
    //Performance
    public void insertPerformance(PerformanceTableDB performanceTableDB) {
        new performanceRepository.InsertPerforamnceAsyncTask(performancedao).execute(performanceTableDB);
    }

    public void updatePerformance(PerformanceTableDB performanceTableDB) {
        new performanceRepository.UpdatePerformanceAsyncTask(performancedao).execute(performanceTableDB);
    }

    public void deletePerformance(PerformanceTableDB performanceTableDB) {
        new performanceRepository.DeletePerformanceAsyncTask(performancedao).execute(performanceTableDB);
    }


    public LiveData<Integer> getPerformanceCount(){
        Log.i("DB" , ""+ performanceCount);
        return performanceCount ;
    }

    public LiveData<List<PerformanceTableDB>> getAllPerformnce() {

        return allPerformance;
    }
    //Perforamnce
    private static class InsertPerforamnceAsyncTask extends AsyncTask<PerformanceTableDB, Void, Void> {
        private PerformanceDAO performancedao;

        private InsertPerforamnceAsyncTask(PerformanceDAO performancedao) {
            this.performancedao = performancedao;
        }

        @Override
        protected Void doInBackground(PerformanceTableDB... performances) {
            performancedao.insert(performances[0]);
            return null;
        }
    }

    private static class UpdatePerformanceAsyncTask extends AsyncTask<PerformanceTableDB, Void, Void> {
        private PerformanceDAO performancedao;

        private UpdatePerformanceAsyncTask(PerformanceDAO performancedao) {
            this.performancedao = performancedao;
        }

        @Override
        protected Void doInBackground(PerformanceTableDB... performances) {
            performancedao.insert(performances[0]);
            return null;
        }
    }
    private static class DeletePerformanceAsyncTask extends AsyncTask<PerformanceTableDB, Void, Void> {
        private PerformanceDAO performancedao;


        private DeletePerformanceAsyncTask(PerformanceDAO performancedao) {
            this.performancedao = performancedao;
        }
        protected Void doInBackground(PerformanceTableDB... performances) {
            performancedao.delete(performances[0]);
            return null;
        }

    }

}
