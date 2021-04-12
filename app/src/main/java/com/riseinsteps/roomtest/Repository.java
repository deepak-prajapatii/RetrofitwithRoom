package com.riseinsteps.roomtest;

import android.app.Application;
import android.os.AsyncTask;

import com.riseinsteps.roomtest.roomdbservices.ModelDatabase;
import com.riseinsteps.roomtest.roomdbservices.RoomDao;

public class Repository {
    private ModelDatabase modelDatabase;
    private RoomDao roomDao;
    private Model model;

    public Repository(Application application) {
        modelDatabase = ModelDatabase.getInstance(application);
        roomDao = modelDatabase.roomDao();
        model = roomDao.getModel();
    }

    public Model getModel() {
        return model;
    }

    public void insert(Model model) {
        new InsertAsyncTask(roomDao).execute(model);
    }

    private class InsertAsyncTask extends AsyncTask<Model, Void, Void> {
        private RoomDao roomDao;

        public InsertAsyncTask(RoomDao roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(Model... models) {
            roomDao.insert(models[0]);
            return null;
        }
    }
}
