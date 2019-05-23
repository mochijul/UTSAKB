

package com.hijulmochamad.utsakb;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.hijulmochamad.utsakb.R;
import com.hijulmochamad.utsakb.presenter.ContactFragment;
import com.hijulmochamad.utsakb.presenter.PeopleFragment;
import com.hijulmochamad.utsakb.presenter.ProfileFragment;
/*
        Nim   10116296
        Nama  Mochamad Hijul M
        Kelas IF-7
        Waktu 22/05/19 14:35
*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new ProfileFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment  = null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.nav_contact:
                            selectedFragment = new ContactFragment();
                            break;
                        case R.id.nav_people:
                            selectedFragment = new PeopleFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

    public void Telepon(View view) {
        String uri = "tel:089525692775";
        Intent teleponPribadi = new Intent(Intent.ACTION_DIAL);
        teleponPribadi.setData(Uri.parse(uri));
        startActivity(teleponPribadi);
    }

    public void SendMeEmail(View view) {
        Intent sendEmail = new Intent(Intent.ACTION_SEND);
        sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"hijul1998@gmail.com"});
        sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Welcome to hijul app");
        sendEmail.setType("message/rfc822");
        startActivity(sendEmail);


    }

    public void BukaIg(View view) {
        String url = "https://instagram.com/hijulmochamad";
        Intent bukaIg = new Intent(Intent.ACTION_VIEW);
        bukaIg.setData(Uri.parse(url));
        startActivity(bukaIg);
    }

    public void BukaTwitter(View view) {
        String url = "https://twitter.com/hijulmochamad";
        Intent bukaTwitter = new Intent(Intent.ACTION_VIEW);
        bukaTwitter.setData(Uri.parse(url));
        startActivity(bukaTwitter);
    }

    public void BukaGit(View view) {
        String url = "https://github.com/mochijul";
        Intent bukaGit = new Intent(Intent.ACTION_VIEW);
        bukaGit.setData(Uri.parse(url));
        startActivity(bukaGit);
    }




 }
