

package com.hijulmochamad.utsakb.presenter;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hijulmochamad.utsakb.model.Global;
import com.hijulmochamad.utsakb.model.Person;
import com.hijulmochamad.utsakb.view.ViewPagerActivity;

import java.util.ArrayList;
/*
        Nim   10116296
        Nama  Mochamad Hijul M
        Kelas IF-7
        Waktu 22/05/19 16:14
*/

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent intent = new Intent(this, ViewPagerActivity.class);
        startActivity(intent);
        final ArrayList<Person> teman =  new ArrayList<>();

        Person person1 = new Person("Mochamad Hijul M","10116296","IF-9","089525692775","hijul1998@gmail.com","@hijulmochamad");
        Person person2 = new Person("M Ilhan Sidiq","10116297","IF-1","089535346135","ilhasdf98@gmail.com","@bakcoamad");
        Person person3 = new Person("Asep Toni stak","10116292","IF-7","089235432775","kamana98@gmail.com","@hijjanabaamad");
        Person person4 = new Person("M Rizki A","101162913","IF-3","089522342345","disnisn98@gmail.com","@hijaudhasdmad");
        Person person5 = new Person("Reze haji oktafian","10116234","IF-4","089234125135","swoeeer98@gmail.com","@hijjahadasaad");



        Global g = Global.getInstance();
        teman.add(person1);
        teman.add(person2);
        teman.add(person3);
        teman.add(person4);
        teman.add(person5);
        g.setData(teman);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finish();
    }
}
