

package com.hijulmochamad.utsakb.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hijulmochamad.utsakb.MainActivity;
import com.hijulmochamad.utsakb.R;

import java.util.ArrayList;
/*
        Nim   10116296
        Nama  Mochamad Hijul M
        Kelas IF-7
        Waktu 23/05/19 18:40
*/

public class TambahTeman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_teman);
    }

    public void tambahBaru(View view) {
        Global g = Global.getInstance();
        ArrayList<Person> data = g.getData();
        EditText etEmail = (EditText) findViewById(R.id.etDetailEmail);
        EditText etIg = (EditText) findViewById(R.id.etDetailIg);
        EditText etKelas = (EditText) findViewById(R.id.etDetailKelas);
        EditText etNama = (EditText) findViewById(R.id.etDetailNama);
        EditText etNim = (EditText) findViewById(R.id.etDetailNim);
        EditText etTlp = (EditText) findViewById(R.id.etDetailTlp);


        Person dataSimpan = new Person(
                etNama.getText().toString(),
                etNim.getText().toString(),
                etKelas.getText().toString(),
                etTlp.getText().toString(),
                etEmail.getText().toString(),
                etIg.getText().toString()
        );
        data.add(dataSimpan);
        g.setData(data);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("state","edit");
        this.startActivity(intent);
        Toast.makeText(this,"Data berhasil ditambah",Toast.LENGTH_SHORT).show();
    }


}



