package com.example.contactsapp.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "accounts_table")
public class AccountsEntity implements BaseEntity {

    @PrimaryKey
    @ColumnInfo(name = "status")
    private int status;

    @ColumnInfo(name = "user_id")
    private String userId;

    @ColumnInfo(name = "context")
    private String context;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
