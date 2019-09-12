package com.example.contactsapp.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.contactsapp.db.entities.BaseEntity;

@Entity(tableName = "extensions_table")
public class ExtensionsEntity implements BaseEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "context")
    private String context;

    @ColumnInfo(name = "phone_contact_id")
    private String phoneContactId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPhoneContactId() {
        return phoneContactId;
    }

    public void setPhoneContactId(String phoneContactId) {
        this.phoneContactId = phoneContactId;
    }
}
