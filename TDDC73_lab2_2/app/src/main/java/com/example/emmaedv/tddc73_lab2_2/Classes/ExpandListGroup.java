package com.example.emmaedv.tddc73_lab2_2.Classes;

import java.util.ArrayList;

/**
 * Created by emmaedv on 04/12/14.
 */
public class ExpandListGroup {
    private String Name;
    private ArrayList<ExpandListChild> Items;

    public String getName(){
        return Name;
    }

    public void setName(String theName){
        this.Name = theName;
    }

    public ArrayList<ExpandListChild> getItems(){
        return Items;
    }

    public void setItems(ArrayList<ExpandListChild> theItems){
        this.Items = theItems;
    }
}
