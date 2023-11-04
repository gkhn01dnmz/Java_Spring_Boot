package com.gokhan.springmongorestapi.entities;
import java.util.HashMap;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class User {
    @Id
    private String id;
    private String adi;
    private String soyadi;
    private HashMap attributes;

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

    public HashMap getAttributes() {
        return this.attributes;
    }

    public void setAttributes(HashMap attributes) {
        this.attributes = attributes;
    }
}
