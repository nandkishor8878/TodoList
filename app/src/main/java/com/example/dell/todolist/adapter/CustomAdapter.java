package com.example.dell.todolist.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.todolist.R;
import com.example.dell.todolist.database.Todo;

import java.util.List;

/**
 * Created by Nandkishor_Kumawat on 6/19/2018 7:41 PM.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<Todo> todoList;
    private LayoutInflater layoutInflater;
    public CustomAdapter(Context context,List<Todo> todoList)
    {
        this.context=context;
        this.todoList=todoList;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int position) {
        return todoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder viewHolder= null;
        if(convertView==null)
        {
            convertView= layoutInflater.inflate(R.layout.innerlayout,null);
            viewHolder=new viewHolder();
            viewHolder.content=(TextView)convertView.findViewById(R.id.content);
            viewHolder.date=(TextView)convertView.findViewById(R.id.date);
            convertView.setTag(viewHolder);
        }

        else
        {
            viewHolder=(viewHolder)convertView.getTag();
        }
        Todo todo =(Todo)getItem(position);
        viewHolder.content.setText(todo.getContent());
        viewHolder.date.setText(todo.getDate());

        return convertView;
    }
    public class viewHolder
    {
        TextView content,date;
    }
}
