package com.hijulmochamad.utsakb.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hijulmochamad.utsakb.MainActivity;
import com.hijulmochamad.utsakb.R;
import com.hijulmochamad.utsakb.model.EditDataTeman;
import com.hijulmochamad.utsakb.model.Global;
import com.hijulmochamad.utsakb.model.Person;

import java.util.ArrayList;
/*
        Nim   10116296
        Nama  Mochamad Hijul M
        Kelas IF-7
        Waktu 23/05/19 14:10
*/

public class DetailTemanView extends AppCompatActivity implements DetalTemanInterface{
    private int indexArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Global g = Global.getInstance();
        setContentView(R.layout.activity_detail_teman_view);

        Intent intent = getIntent();
        String index = intent.getStringExtra("data");
        ArrayList<Person> listTeman = g.getData();
        indexArray = Integer.valueOf(index);
        Person teman = listTeman.get(indexArray);

        TextView tvEmail = (TextView) findViewById(R.id.tvDetailEmail);
        TextView tvIg = (TextView) findViewById(R.id.tvDetailIg);
        TextView tvKelas = (TextView) findViewById(R.id.tvDetailKelas);
        TextView tvNama = (TextView) findViewById(R.id.tvDetailNama);
        TextView tvNim = (TextView) findViewById(R.id.tvDetailNim);
        TextView tvTlp = (TextView) findViewById(R.id.tvDetailTlp);

        tvEmail.setText(teman.getEmail());
        tvIg.setText(teman.getInstagram());
        tvKelas.setText(teman.getKelas());
        tvNama.setText(teman.getNama());
        tvNim.setText(teman.getNim());
        tvTlp.setText(teman.getTelepon());
    }


    public void DetainTlp(View view) {
        TextView tvTlp = (TextView) findViewById(R.id.tvDetailTlp);
        String uri = (String) tvTlp.getText();
        Intent teleponPribadi = new Intent(Intent.ACTION_DIAL);
        teleponPribadi.setData(Uri.parse("tel:"+uri));
        startActivity(teleponPribadi);
    }

    public void SendMeEmail(View view) {
        TextView tvEmail = (TextView) findViewById(R.id.tvDetailEmail);
        Intent sendEmail = new Intent(Intent.ACTION_SEND);
        sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{(String) tvEmail.getText()});
        sendEmail.setType("message/rfc822");
        startActivity(sendEmail);


    }

    public void BukaIg(View view) {
        TextView tvIg = (TextView) findViewById(R.id.tvDetailIg);
        String igAcc = (String) tvIg.getText();
        String url = "https://instagram.com/"+igAcc.replace("@","");
        Intent bukaIg = new Intent(Intent.ACTION_VIEW);
        bukaIg.setData(Uri.parse(url));
        startActivity(bukaIg);
    }

    public void editDetailTeman(View view){
        Intent intentEditDataTemanView = new Intent(this, EditDataTeman.class);
        intentEditDataTemanView.setFlags(intentEditDataTemanView.getFlags()|intentEditDataTemanView.FLAG_ACTIVITY_NO_HISTORY);
        intentEditDataTemanView.putExtra("data",String.valueOf(indexArray));
        startActivity(intentEditDataTemanView);
    }

    public void hapusDetailTeman(View view){
        new AlertDialog.Builder(this)
                .setTitle("Hapus Data")
                .setMessage("Yakin hapus?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {

                        Global g = Global.getInstance();
                        ArrayList<Person> listPerson = g.getData();
                        listPerson.remove(indexArray);
                        g.setData(listPerson);
                        berhasilHapus();

                    }
                }).setNegativeButton(android.R.string.no,null).show();





    }

    public void berhasilHapus(){
        Toast.makeText(this,"Data berhasil dihapus",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void tambahTeman(View view) {

    }
}
