package com.example.playgirl.mvp.utlis;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by playgirl on 1/2/18.
 */
public class CityInfo extends RealmObject {
    private String id;
    private String name;
    private String Populat;

    public CityInfo() {
    }

    public CityInfo(String id, String name, String populat) {
        this.id = id;
        this.name = name;
        Populat = populat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulat() {
        return Populat;
    }

    public void setPopulat(String populat) {
        Populat = populat;
    }
}
