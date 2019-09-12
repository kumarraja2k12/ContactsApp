package com.example.contactsapp.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.contactsapp.db.MainRepository;
import com.example.contactsapp.models.ContactModel;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private MainRepository notesRepository;

    public LiveData<List<ContactModel>> getContacts() {
        return contactsData;
    }

    private LiveData<List<ContactModel>> contactsData;
    public MainViewModel(Application application) {
        super(application);
        notesRepository = new MainRepository(application);
        contactsData = notesRepository.getContacts();
    }

}