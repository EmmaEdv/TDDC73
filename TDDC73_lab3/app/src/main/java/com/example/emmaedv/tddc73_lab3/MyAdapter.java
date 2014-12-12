package com.example.emmaedv.tddc73_lab3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by emmaedv on 12/12/14.
 */
public class MyAdapter extends BaseAdapter {
    Context myContext;
    String[] names;

    public MyAdapter(Context context, String[] stringArray){
        myContext = context;
        names = stringArray;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    //Hämta namn från resultatet i sökningen
    public Object getItem(int i) {
        return names[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    //Denna skapar varje nytt namn som finns i resultatet för sökningen
    public View getView(int i, View view, ViewGroup viewGroup) {
        ResultItem resItem = new ResultItem(myContext, names[i]);

        return resItem;
    }
}
