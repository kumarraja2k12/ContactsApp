package com.example.contactsapp.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.contactsapp.models.ContactModel;

import java.util.List;

public class MainRepository {

    private MainDao mainDao;
    private LiveData<List<ContactModel>> contactsLiveDate;

    public MainRepository(Context context) {
        Database database = Database.getInstance(context);
        mainDao = database.mainDao();
        contactsLiveDate = mainDao.getContacts();
    }

    public LiveData<List<ContactModel>> getContacts() {
        return contactsLiveDate;
    }

}
