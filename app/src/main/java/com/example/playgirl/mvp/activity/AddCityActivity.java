package com.example.playgirl.mvp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.playgirl.mvp.R;
import com.example.playgirl.mvp.adapter.ShowCityAdapter;
import com.example.playgirl.mvp.content.PresenterLogicContent;
import com.example.playgirl.mvp.content.ViewContent;
import com.example.playgirl.mvp.utlis.CityInfo;

import java.util.ArrayList;

public class AddCityActivity extends AppCompatActivity
    implements ViewContent, View.OnClickListener {
    private EditText edtId, edtName, edtPopulation;
    private Button btnAdd;
    private RecyclerView recyclerView;
    private PresenterLogicContent presenterLogicContent;
    private ArrayList<CityInfo> listCityInfos = new ArrayList<>();
    private ShowCityAdapter showCityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
        init();
        presenterLogicContent = new PresenterLogicContent(this, this);
        listCityInfos.addAll(presenterLogicContent.getListCity());
        showCityAdapter = new ShowCityAdapter(listCityInfos, this);
        recyclerView.setAdapter(showCityAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this
        ));
        btnAdd.setOnClickListener(this);
    }

    private void init() {
        recyclerView = findViewById(R.id.recy);
        edtId = (EditText) findViewById(R.id.edt_id);
        edtName = findViewById(R.id.edt_city_name);
        edtPopulation = findViewById(R.id.edt_count);
        btnAdd = findViewById(R.id.btn_add);
    }

    @Override
    public void onClick(View view) {
        CityInfo cityInfo = new CityInfo(edtId.getText() + "", edtName.getText() + "",
            edtPopulation.getText() + "");
        presenterLogicContent.addCity(cityInfo);
    }

    @Override
    public void addSuccess() {
    }

    @Override
    public void showAll(ArrayList<CityInfo> listCityInfos) {
        showCityAdapter.setListCityInfos(listCityInfos);
    }
}
