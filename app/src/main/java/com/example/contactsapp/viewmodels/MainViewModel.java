package com.example.contactsapp.viewmodels;

import android.app.Application;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.contactsapp.db.MainRepository;
import com.example.contactsapp.models.ContactModel;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private MainRepository notesRepository;

    public LiveData<List<ContactModel>> getContacts() {
        return notesRepository.getContacts();
    }

    public ObservableArrayList<ContactModel> contactModels = new ObservableArrayList<>();
    public ObservableInt contactModelPosition = new ObservableInt(0);

    public MainViewModel(Application application) {
        super(application);
        notesRepository = new MainRepository(application);
    }

}