package com.example.playgirl.mvp.content;

import android.content.Context;
import android.util.Log;

import com.example.playgirl.mvp.utlis.CityInfo;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


/**
 * Created by playgirl on 1/2/18.
 */

public class PresenterLogicContent implements PresenterImpContent{

    private Context context;
    private Realm  realm;

    private ViewContent viewContent;

    private ModelContent modelContent;

    ArrayList<CityInfo> lisCityInfos;
    public PresenterLogicContent(Context context, ViewContent viewContent) {
        this.context = context;
        this.viewContent = viewContent;
        modelContent = new ModelContent(context);
        lisCityInfos = modelContent.getListCity();
    }

    @Override
    public void addCity(CityInfo cityInfo) {
        modelContent.AddCity(cityInfo);
    }
    @Override
    public void showAllCity() {
       viewContent.showAll(lisCityInfos);
    }
    public ArrayList<CityInfo> getListCity(){
        return lisCityInfos;
    }
}
