

package com.hijulmochamad.utsakb.model;

import java.util.ArrayList;
/*
        Nim   10116296
        Nama  Mochamad Hijul M
        Kelas IF-7
        Waktu 23/05/19 14:00
*/
public class Global {
    private static Global instance;

    private ArrayList<Person> data;

    private Global(){}

    public void setData(ArrayList<Person> data){
        this.data=data;
    }

    public ArrayList<Person> getData(){
        return this.data;
    }

    public static synchronized Global getInstance(){
        if(instance == null){
            instance = new Global();
        }
        return instance;
    }

}
