package com.example.contactsapp.db;

import android.content.Context;

import com.example.contactsapp.db.entities.AccountsEntity;
import com.example.contactsapp.db.entities.ContactsEntity;
import com.example.contactsapp.db.entities.ExtensionsEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStreamReader;
import java.util.*;

public class DataModel {

    private List<ContactsEntity> contacts;
    private List<ExtensionsEntity> extensions;
    private List<AccountsEntity> accounts;

    public List<ContactsEntity> getContacts() {
        return contacts;
    }

    public List<ExtensionsEntity> getExtensions() {
        return extensions;
    }

    public List<AccountsEntity> getAccounts() {
        return accounts;
    }

    public static DataModel process(Context context, int id)
    {
        try {
            Gson gson = new GsonBuilder().create();
            DataModel dataModel = gson.fromJson(new InputStreamReader(context.getResources().openRawResource(id)), DataModel.class);
            return dataModel;
        } catch (Exception ex) {}
        return null;
    }
}
