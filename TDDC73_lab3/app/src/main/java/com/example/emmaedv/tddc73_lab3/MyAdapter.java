package com.example.emmaedv.tddc73_lab3;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by emmaedv on 12/12/14.
 */
public class MyAdapter extends BaseAdapter {
    Context myContext;
    //String[] names;
    List<String> nm;

    public MyAdapter(Context context, List<String> stringArray){
        Log.e("MyAdapter", "MyAdapter");
        myContext = context;
        nm = stringArray;
    }

    public int getCount() {
        return nm.size();
    }

    //Hämta namn från resultatet i sökningen
    @Override
    public Object getItem(int i) {
        Log.e("MyAdapter","getItem");
        //return names[i];
        return nm.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //Denna skapar varje nytt namn som finns i resultatet för sökningen
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.e("MyAdapter","getView");
        //ResultItem resItem = new ResultItem(myContext, names[i]);
        ResultItem resItem = new ResultItem(myContext, nm.get(i));

        return resItem;
    }
}
