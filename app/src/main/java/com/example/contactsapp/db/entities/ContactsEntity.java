package com.example.contactsapp.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts_table")
public class ContactsEntity implements BaseEntity {

    @PrimaryKey
    @ColumnInfo(name = "_id")
    private int id;

    @ColumnInfo(name = "contact_id")
    private String contactId;

    @ColumnInfo(name = "staging_id")
    private String stagingId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getStagingId() {
        return stagingId;
    }

    public void setStagingId(String stagingId) {
        this.stagingId = stagingId;
    }


}
