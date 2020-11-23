package com.example.firapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private final String recyclerViewTitleText[] = {"Android", "RecyclerView", "Android List", "GridView", "ListView", "Tutorial", "Example", "CardView", "Lollipop", "Marshmallow", "Custom ListView", "Custom GridView"
    };

    private final int recyclerViewImages[] = {
            R.drawable.model_female, R.drawable.model_female, R.drawable.model_female, R.drawable.model_female, R.drawable.model_female, R.drawable.model_female,
            R.drawable.model_female, R.drawable.model_female, R.drawable.model_female, R.drawable.model_female, R.drawable.model_female, R.drawable.model_female

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ImageView dots = (ImageView) findViewById(R.id.dot);
        dots.setOnClickListener (this);
//
//        ImageView family = (ImageView)findViewById(R.id.family);
//        ImageView friend = (ImageView)findViewById(R.id.friend);
//        ImageView business = (ImageView)findViewById(R.id.business);
//
//        ImageView aa = (ImageView)findViewById(R.id.aa);
//        ImageView schedule = (ImageView)findViewById(R.id.schedule);
//        ImageView more = (ImageView) findViewById(R.id.more);
//
//
//
//
//        family.setOnClickListener(this) ;

        initRecyclerViews();


    }

    private void initRecyclerViews() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager (getApplicationContext(), 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<AndroidVersion> av = prepareData();
        AndroidDataAdapter mAdapter = new AndroidDataAdapter(getApplicationContext(), av);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItem(getApplicationContext(), new RecyclerItem.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                        switch (i) {
                            case 0:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent (HomeActivity.this,FamilyActivity.class);
                                Log.d ("dfdsf", String.valueOf (intent));
                                startActivity(intent);

                                break;
                            case 1:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 3:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 4:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 5:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 6:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 7:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 8:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 9:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 10:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 11:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                })
        );

    }

    private ArrayList<AndroidVersion> prepareData() {

        ArrayList<AndroidVersion> av = new ArrayList<>();
        for (int i = 0; i < recyclerViewTitleText.length; i++) {
            AndroidVersion mAndroidVersion = new AndroidVersion();
            mAndroidVersion.setAndroidVersionName(recyclerViewTitleText[i]);
            mAndroidVersion.setrecyclerViewImage(recyclerViewImages[i]);
            av.add(mAndroidVersion);
        }
        return av;
    }

    public void onClick(View vw){

        switch (vw.getId ()){

            case R.id.dot:
                showMenu (vw);

                break;

//            case R.id.family:
//                Intent intent = new Intent(HomeActivity.this, FamilyActivity.class);
//                startActivity(intent);
//                finish();
//
//                break;
        }
    }

    public void showMenu(View v) {

        PopupMenu popup = new PopupMenu (this, v);
        // This activity implements OnMenuItemClickListener
        popup.setOnMenuItemClickListener(this::onOptionsItemSelected);
        popup.inflate(R.menu.option_menu);
        popup.show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.search_item:
                // do your code
                return true;
            case R.id.upload_item:
                // do your code
                return true;
            case R.id.copy_item:
                // do your code
                return true;
//            case R.id.print_item:
//                // do your code
//                return true;
            case R.id.share_item:
                // do your code
                return true;
//            case R.id.bookmark_item:
//                // do your code
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}