package com.example.dell.todolist.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Nandkishor_Kumawat on 6/19/2018 6:09 PM.
 */

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todo")
    Flowable<List<Todo>> getTodo();

    @Insert
    void insertTodo(Todo todo);

}
