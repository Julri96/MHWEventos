package com.example.mhweventos.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Mapa implements Serializable {
    private int id;
    private String name;
    private int zoneCount;
    private ArrayList<Camp> camps;

    public Mapa(int id, String name, int zoneCount, ArrayList<Camp> camps) {
        this.id = id;
        this.name = name;
        this.zoneCount = zoneCount;
        this.camps = camps;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getZoneCount() {
        return zoneCount;
    }

    public ArrayList<Camp> getCamps() {
        return camps;
    }
}
