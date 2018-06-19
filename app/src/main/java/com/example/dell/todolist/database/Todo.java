package com.example.dell.todolist.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Nandkishor_Kumawat on 6/19/2018 5:53 PM.
 */

@Entity(tableName = "todo")
public class Todo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "content")
    public String content;
    @ColumnInfo(name = "date")
    public String date;

    public Todo(String content, String date) {
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
