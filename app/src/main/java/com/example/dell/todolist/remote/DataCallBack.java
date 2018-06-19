package com.example.dell.todolist.remote;

import com.example.dell.todolist.database.Todo;

import java.util.List;

/**
 * Created by Nandkishor_Kumawat on 6/19/2018 6:34 PM.
 */

public interface DataCallBack {
    void dataAdded();
    void errorAdded();
    void loadTodoData(List<Todo>todoList);

}
