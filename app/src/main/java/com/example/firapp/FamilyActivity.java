package com.example.firapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class FamilyActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout dLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        setNavigationDrawer();
        ImageView arrow_white = (ImageView)findViewById (R.id.dot);

        arrow_white.setOnClickListener (this);

        ImageView three_line = (ImageView)findViewById (R.id.back);
        three_line.setOnClickListener (this);

        FamilyListData[] mylistdata = new FamilyListData[] {
                new FamilyListData("Pop", R.drawable.manavatar),
                new FamilyListData("Mum", R.drawable.manavatar),
                new FamilyListData("Uncle", R.drawable.manavatar),
                new FamilyListData("Aunt", R.drawable.manavatar),
                new FamilyListData("Sister", R.drawable.manavatar),
                new FamilyListData("Brother", R.drawable.manavatar),
                new FamilyListData("Brother", R.drawable.manavatar),
                new FamilyListData("Brother", R.drawable.manavatar),
                new FamilyListData("Brother", R.drawable.manavatar),
                new FamilyListData("Brother", R.drawable.manavatar),
                new FamilyListData("Brother",R.drawable.manavatar),
                new FamilyListData("Brother",R.drawable.manavatar),
        };

        RecyclerView recyclerView = (RecyclerView)findViewById (R.id.recyfler);
        FamilyListAdapter adapter = new FamilyListAdapter (mylistdata);
        recyclerView.setHasFixedSize (true);
        recyclerView.setLayoutManager (new LinearLayoutManager (this));
        recyclerView.setAdapter (adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.dot:

                Intent intent = new Intent (FamilyActivity.this,HomeActivity.class);
                startActivity (intent);
                finish ();

                break;
            case R.id.back:

                dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                NavigationView draw = (NavigationView) findViewById(R.id.navigation);
                dLayout.openDrawer(draw,true);




        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }




    private void setNavigationDrawer() {
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment frag = null;
                int itemId = menuItem.getItemId();

                if (itemId == R.id.Message) {
//                    frag = new CallsFragment();
                } else if (itemId == R.id.Location) {
//                    frag = new ChatsFragment();
                } else if (itemId == R.id.About) {
//                    frag = new ContactFragment();
                }

                if (frag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                    transaction.replace(R.id.simpleFrameLayout, frag);
                    transaction.commit();
                    dLayout.closeDrawers();
                    return true;
                }
                return false;

            }

        });
    }
    public void onItemClick(int position, View view){

    }
}