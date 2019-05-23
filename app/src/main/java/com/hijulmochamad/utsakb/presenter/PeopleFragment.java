

package com.hijulmochamad.utsakb.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.hijulmochamad.utsakb.model.Global;
import com.hijulmochamad.utsakb.model.Person;
import com.hijulmochamad.utsakb.R;
import com.hijulmochamad.utsakb.model.TambahTeman;

import java.util.ArrayList;
/*
        Nim   10116296
        Nama  Mochamad Hijul M
        Kelas IF-7
        Waktu 23/05/19 4:28
*/
public class PeopleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_people,container,false);
        Global g = Global.getInstance();
        ArrayList<Person> teman = g.getData();

        PersonListAdaptor adaptor = new PersonListAdaptor(getContext(),R.layout.adapter_view,teman);

        ListView lvTeman = (ListView) view.findViewById(R.id.list_teman);
        lvTeman.setAdapter(adaptor);
        Button btnTambahTeman = (Button) view.findViewById(R.id.buttonTambahTeman);
        btnTambahTeman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TambahTeman.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
