package com.project.startpark_admin.screens.activity.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.project.startpark_admin.R;
import com.project.startpark_admin.databinding.ActivityHomeBinding;
import com.project.startpark_admin.screens.activity.home.adapter.AreaListAdapter;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    protected ActivityHomeBinding homeBinding;
    protected LinearLayoutManager linearLayoutManager;
    protected AreaListAdapter areaListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(homeBinding.getRoot());

        init();
    }

    public void init(){

        /*Initialize Variables*/
        initializeVariables();


        /*ONCLICK Functionalities*/
        homeBinding.layoutHomeDashboard.imgHomeDashboardMenu.setOnClickListener(this);

    }

    private void initializeVariables() {

        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        homeBinding.layoutHomeDashboard.recyclerHomeDashboardAreaList.setLayoutManager(linearLayoutManager);

        /*Adapter*/
        areaListAdapter = new AreaListAdapter(this);
        homeBinding.layoutHomeDashboard.recyclerHomeDashboardAreaList.setAdapter(areaListAdapter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.img_home_dashboard_menu:
                homeBinding.layoutHomeDashboardSideNav.openDrawer(GravityCompat.START);

                break;

            case R.id.img_home_dashboard_nav_profile:

                break;

        }
    }
}