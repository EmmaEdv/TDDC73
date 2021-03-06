package com.example.emmaedv.tddc73_lab3;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emmaedv on 10/12/14.
 */
public class InteractiveSearcher extends LinearLayout {

    EditText searchField;
    ListPopupWindow popList;
    int id = 0;
    int lastShownId = 0;
    Context context;

    public InteractiveSearcher(Context theContext) {
        super(theContext);
        context = theContext;
        searchField = new EditText(context);
        searchField.addTextChangedListener(watcher);
        searchField.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        popList = new ListPopupWindow(context);
        popList.setAnchorView(searchField);
        popList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                searchField.setText(adapterView.getItemAtPosition(position).toString());
            }
        });
        //Listan behöver inte addas till view då den inte visas hela tiden. Istället kör vi "show" i run()

        addView(searchField);
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            //Log.e("InteractiveSearcher", "OnTextChanged");
            String text = charSequence.toString();
            id += 1;
            loadData(text, id);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void loadData(String text, int id) {
        //Log.e("InteractiveSearcher","loadData");
        loadWithThread(text, id);
    }

    private void loadWithThread(final String text, final int id){
        Log.e("InteractiveSearcher","loadWithThread");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
            final List<String> dataL = doNWCall(text, id);
            final MyAdapter myAdapter = new MyAdapter(context, dataL);
            if(id>lastShownId) {
                searchField.post(new Runnable() {
                    @Override
                    public void run() {
                    //Dessa bör köras i post pga de påverkar gui.
                    popList.setAdapter(myAdapter);
                    myAdapter.notifyDataSetChanged();
                    popList.show();
                    lastShownId = id;
                    }
                });
            }
            }
        });
        t.start();
    }

    private List<String> doNWCall(String name, int id){
        Log.e("InteractiveSearcher", "doNetworkCall");
        List<String> nameL = new ArrayList<String>();
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet("http://flask-afteach.rhcloud.com/getnames/"+id+"/"+name);
            HttpResponse response = null;
            response = httpclient.execute(httpget);

            BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            String result = sb.toString();

            try {
                JSONObject jObj = new JSONObject(result);
                JSONArray jArr = jObj.getJSONArray("result");

                for(int i = 0; i<jArr.length(); i++){
                    nameL.add(jArr.get(i).toString());
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return nameL;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nameL;
    }

}
