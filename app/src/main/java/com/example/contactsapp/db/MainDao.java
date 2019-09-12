package com.example.contactsapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RoomWarnings;

import com.example.contactsapp.db.entities.AccountsEntity;
import com.example.contactsapp.db.entities.ContactsEntity;
import com.example.contactsapp.db.entities.ExtensionsEntity;
import com.example.contactsapp.models.ContactModel;

import java.util.List;

@Dao
public interface MainDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertContacts(List<ContactsEntity> contacts);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertExtensions(List<ExtensionsEntity> extensions);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAccounts(List<AccountsEntity> accounts);

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT c.contact_id as contactId," +
            " c.staging_id as stagingId," +
            " e.context as context," +
            " a.status as status," +
            " a.user_id as userId FROM contacts_table as c" +
            " join extensions_table as e on c._id = e.phone_contact_id" +
            " join accounts_table as a on e.context = a.context;")
    public LiveData<List<ContactModel>> getContacts();

    @Query("DELETE FROM contacts_table")
    public void deleteContacts();

    @Query("DELETE FROM extensions_table")
    public void deleteExtensions();

    @Query("DELETE FROM accounts_table")
    public void deleteAccounts();
}
