package com.example.contactsapp.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.contactsapp.R;
import com.example.contactsapp.db.entities.AccountsEntity;
import com.example.contactsapp.db.entities.ContactsEntity;
import com.example.contactsapp.db.entities.ExtensionsEntity;

@androidx.room.Database(entities = {ContactsEntity.class, ExtensionsEntity.class, AccountsEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static Database instance;

    public abstract MainDao mainDao();

    public static synchronized Database getInstance(final Context context)
    {
        if(instance == null) {
            instance = Room.databaseBuilder(context, Database.class, "contacts_database")
                    .addCallback(new Callback() {
                        @Override
                        public void onOpen(@NonNull SupportSQLiteDatabase db) {
                            super.onOpen(db);
                            new DBAsyncTask(context).execute();

                        }
                    })
                    .build();
        }
        return instance;
    }

    private static class DBAsyncTask extends AsyncTask<Void, Void, Void> {
        private final Context context;

        public DBAsyncTask(Context context) {
            this.context = context;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            MainDao mainDao = instance.mainDao();
            DataModel dataModel = DataModel.process(context, R.raw.contacts);
            if(dataModel != null)
            {
                mainDao.deleteContacts();
                mainDao.deleteExtensions();
                mainDao.deleteAccounts();

                mainDao.insertAccounts(dataModel.getAccounts());
                mainDao.insertContacts(dataModel.getContacts());
                mainDao.insertExtensions(dataModel.getExtensions());
            }
            return null;
        }
    }
}
