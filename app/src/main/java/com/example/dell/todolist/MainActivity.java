package com.example.dell.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dell.todolist.adapter.CustomAdapter;
import com.example.dell.todolist.database.Todo;
import com.example.dell.todolist.remote.DataCallBack;
import com.example.dell.todolist.remote.DataManager;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataCallBack {

    private DataManager dataManager;
    private Button sendData,getData;
    private ListView listView;
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendData=(Button)findViewById(R.id.sendData);
        getData=(Button)findViewById(R.id.getData);

        listView= (ListView)findViewById(R.id.listView);
        dataManager=new DataManager(this);

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataManager.loadData(MainActivity.this);
            }
        });

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataManager.addData(MainActivity.this,"contentone","dateone");
            }
        });

    }

    @Override
    public void dataAdded() {

        //show toast
    }

    @Override
    public void errorAdded() {

        //show toast
    }

    @Override
    public void loadTodoData(List<Todo> todoList) {


       // customAdapter=new CustomAdapter(this.todoList);
        listView.setAdapter(customAdapter);
    }

}
