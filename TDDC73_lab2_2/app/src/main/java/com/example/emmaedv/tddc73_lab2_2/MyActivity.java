package com.example.emmaedv.tddc73_lab2_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.emmaedv.tddc73_lab2_2.Adapter.ExpandListAdapter;
import com.example.emmaedv.tddc73_lab2_2.Classes.ExpandListChild;
import com.example.emmaedv.tddc73_lab2_2.Classes.ExpandListGroup;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.TextView;

import java.util.ArrayList;

public class MyActivity extends Activity {
    private ExpandListAdapter ExpAdapter;
    private ArrayList<ExpandListGroup> ExpListItems;
    private ExpandableListView ExpandList;
    private EditText TextField;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandList = (ExpandableListView) findViewById(R.id.ExpList);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(MyActivity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
        TextField = (EditText)findViewById(R.id.editText);

        ExpandList.setOnGroupClickListener(new OnGroupClickListener() {
           @Override
           public boolean onGroupClick(ExpandableListView expandablelistview,
                                       View clickedView, int groupPosition, long groupId) {
               ExpandListGroup group = (ExpandListGroup) ExpAdapter.getGroup(groupPosition);
               String groupPath = group.getName().toString();

               TextField.setText(groupPath, TextView.BufferType.EDITABLE);
               return false;
           }
       });

        ExpandList.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandablelistview,
                                        View clickedView, int groupPosition, int childPosition, long childId) {
                ExpandListChild child = (ExpandListChild) ExpAdapter.getChild(groupPosition, childPosition);
                String path = "/" + child.getName().toString();

                ExpandListGroup group = (ExpandListGroup) ExpAdapter.getGroup(groupPosition);
                String groupPath = group.getName().toString();

                path = groupPath.concat(path);
                TextField.setText(path, TextView.BufferType.EDITABLE);
                return false;
            }
        });
    }

    public ArrayList<ExpandListGroup> SetStandardGroups(){
        ArrayList<ExpandListGroup> list = new ArrayList<ExpandListGroup>();
        ArrayList<ExpandListChild> list2 = new ArrayList<ExpandListChild>();

        ExpandListGroup group1 = new ExpandListGroup();
        group1.setName("Namn");
        ExpandListChild child1_1 = new ExpandListChild();
        child1_1.setName("Emma");
        child1_1.setTag(null);
        list2.add(child1_1);

        ExpandListChild child1_2 = new ExpandListChild();
        child1_2.setName("Johan");
        child1_2.setTag(null);
        list2.add(child1_2);

        ExpandListChild child1_3 = new ExpandListChild();
        child1_3.setName("Molgan");
        child1_3.setTag(null);
        list2.add(child1_3);

        group1.setItems(list2);

        list2 = new ArrayList<ExpandListChild>();

        ExpandListGroup group2 = new ExpandListGroup();
        group2.setName("Mellannamn");
        ExpandListChild child2_1 = new ExpandListChild();
        child2_1.setName("Marie Caroline");
        child2_1.setTag(null);
        list2.add(child2_1);

        ExpandListChild child2_2 = new ExpandListChild();
        child2_2.setName("Carl August");
        child2_2.setTag(null);
        list2.add(child2_2);

        ExpandListChild child2_3 = new ExpandListChild();
        child2_3.setName("Molganne");
        child2_3.setTag(null);
        list2.add(child2_3);

        group2.setItems(list2);

        list2 = new ArrayList<ExpandListChild>();

        ExpandListGroup group3 = new ExpandListGroup();
        group3.setName("Efternamn");
        ExpandListChild child3_1 = new ExpandListChild();
        child3_1.setName("Edvardsson");
        child3_1.setTag(null);
        list2.add(child3_1);

        ExpandListChild child3_2 = new ExpandListChild();
        child3_2.setName("Dagvall");
        child3_2.setTag(null);
        list2.add(child3_2);

        ExpandListChild child3_3 = new ExpandListChild();
        child3_3.setName("Molgansson");
        child3_3.setTag(null);
        list2.add(child3_3);

        group3.setItems(list2);

        list.add(group1);
        list.add(group2);
        list.add(group3);

        return list;
    }

}