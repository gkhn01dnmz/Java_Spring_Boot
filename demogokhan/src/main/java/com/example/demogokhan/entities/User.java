package com.example.demogokhan.entities;

import org.springframework.data.annotation.Id;



public class User {
    @Id
    private String id;
    private String adi;
    private String soyadi;
    private String properties;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdi() {
        return this.adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return this.soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getProperties() {
        return this.properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

}
