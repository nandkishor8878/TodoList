package com.example.dell.todolist.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Nandkishor_Kumawat on 6/19/2018 6:21 PM.
 */

@Database(entities = Todo.class,version = 1)
public abstract class TodoDataBase extends RoomDatabase {

    public abstract TodoDao getTododao();
}
