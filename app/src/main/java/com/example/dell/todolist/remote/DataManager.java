package com.example.dell.todolist.remote;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.AndroidException;

import com.example.dell.todolist.database.Todo;
import com.example.dell.todolist.database.TodoDataBase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Nandkishor_Kumawat on 6/19/2018 6:26 PM.
 */

public class DataManager {

    private Context context;
    private TodoDataBase todoDataBase;
    public DataManager(Context context)
    {
        this.context=context;
        todoDataBase= Room.databaseBuilder(context,TodoDataBase.class,"todo.db").build();
    }

    public void addData(final DataCallBack dataCallBack,final String content,final String date)
    {

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {

                Todo todo=new Todo(content, date);
                todoDataBase.getTododao().insertTodo(todo);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {

                dataCallBack.dataAdded();
            }

            @Override
            public void onError(Throwable e) {

                dataCallBack.errorAdded();
            }
        });
    }


    public void loadData(final DataCallBack dataCallBack)
    {
        todoDataBase.getTododao().getTodo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Todo>>() {
            @Override
            public void accept(List<Todo> todoList) throws Exception {
                dataCallBack.loadTodoData(todoList);
            }
        });

    }
}
