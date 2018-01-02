package com.example.playgirl.mvp.content;

import com.example.playgirl.mvp.utlis.CityInfo;

import java.util.ArrayList;

/**
 * Created by playgirl on 1/2/18.
 */
public interface ViewContent {
    void addSuccess();
    void showAll(ArrayList<CityInfo> listCityInfos);
}
