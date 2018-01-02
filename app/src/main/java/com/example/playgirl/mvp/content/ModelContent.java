package com.example.playgirl.mvp.content;

import android.content.Context;
import android.util.Log;

import com.example.playgirl.mvp.utlis.CityInfo;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by playgirl on 1/2/18.
 */
public class ModelContent {
    private String TAG = "ModelContent";
    private Context context;
    private Realm realm;

    public ModelContent(Context context) {
        this.context = context;
        Realm.init(context);
        RealmConfiguration realmConfiguration =
            new RealmConfiguration.Builder().name("data").build();
        realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
    }

    public ArrayList<CityInfo> getListCity() {
        ArrayList<CityInfo> listCityInfos = new ArrayList<>();
        RealmResults<CityInfo> results1 =
            realm.where(CityInfo.class).findAll();
        for (CityInfo cityInfo : results1) {
            listCityInfos.add(cityInfo);
        }
        return listCityInfos;
    }

    public void AddCity(CityInfo cityInfo) {
        realm.beginTransaction();
        realm.copyToRealm(cityInfo);
        realm.commitTransaction();
    }
}
