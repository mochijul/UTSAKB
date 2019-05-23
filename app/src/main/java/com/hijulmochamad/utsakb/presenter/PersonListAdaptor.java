package com.hijulmochamad.utsakb.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.hijulmochamad.utsakb.view.DetailTemanView;
import com.hijulmochamad.utsakb.R;
import com.hijulmochamad.utsakb.model.Person;

import java.util.ArrayList;
/*
        Nim   10116296
        Nama  Mochamad Hijul M
        Kelas IF-7
        Waktu 23/05/19 7:30
*/
public class PersonListAdaptor extends ArrayAdapter<Person> {
    private  static final String TAG = "PersonListAdapter";

    private Context mContext;
    int mResource;

    public PersonListAdaptor(Context context, int resource, ArrayList<Person> objects){
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        String nama = getItem(position).getNama();
        String noTLp = getItem(position).getTelepon();

        Person person = new Person(nama,noTLp);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvName = (TextView) convertView.findViewById(R.id.tvNameAdapter);
        TextView tvTlp = (TextView) convertView.findViewById(R.id.tvTlpAdapter);
        Button btnMore = (Button) convertView.findViewById(R.id.buttonMore);
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDetailTemanView = new Intent(getContext(), DetailTemanView.class);
                intentDetailTemanView.setFlags(intentDetailTemanView.getFlags()|intentDetailTemanView.FLAG_ACTIVITY_NO_HISTORY);
                intentDetailTemanView.putExtra("data",String.valueOf(position));
                getContext().startActivity(intentDetailTemanView);
            }
        });

        tvName.setText(nama);
        tvTlp.setText(noTLp);
        return convertView;
    }


}
