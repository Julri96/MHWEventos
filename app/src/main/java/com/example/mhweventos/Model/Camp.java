package com.example.mhweventos.Model;

import java.io.Serializable;

class Camp implements Serializable {
    private int id;
    private String name;
    private int zone;

    public Camp(int id, String name, int zone) {
        this.id = id;
        this.name = name;
        this.zone = zone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getZone() {
        return zone;
    }
}
