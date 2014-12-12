package com.example.emmaedv.tddc73_lab3;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import twoberg.se.testthread.R;


public class MainActivity extends Activity {

    EditText search;
    EditText searchResult;
    EditText pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchResult = (EditText) findViewById(R.id.resultText);
        search = (EditText) findViewById(R.id.editText);
        pop = (EditText) findViewById(R.id.pop);
        Button n = (Button) findViewById(R.id.button);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
            }
        });
    }

    private void loadData() {
        loadWithThread();
        //loadWithAsync();
    }

    private void loadWithAsync() {
        new NetWorker().execute();
    }

    private void loadWithThread(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                final String data = doNetworkCall();
                //List<SuggestGetSet> new_suggestions = onPostExecute(data);
                searchResult.post(new Runnable() {
                    @Override
                    public void run() {
                        searchResult.setText(data);
                    }
                });
            }
        });
        t.start();
    }

    private String doNetworkCall(){
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            EditText editText = (EditText) findViewById(R.id.editText);
            HttpGet httpget = new HttpGet("http://flask-afteach.rhcloud.com/getnames/3/"+ editText.getText().toString());
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
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.my, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class NetWorker extends AsyncTask<Void,Void,String> {


        @Override
        protected String doInBackground(Void... params) {
            return doNetworkCall();
        }

        @Override
        protected void onPostExecute(String s) {
            searchResult.setText(s);
        }
    }

}