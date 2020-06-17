package com.example.mhweventos.Model;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {
    private int id;
    private String name;
    private String platform;
    private String exclusive;
    private String type;
    private String expansion;
    private String description;
    private String requirements;
    private int questRank;
    private Boolean masterRank;
    private String successConditions;
    private Date startTimestamp;
    private Date endTimestamp;
    private Mapa location;

    public Event(int id, String name, String platform, String exclusive, String type, String expansion, String description, String requirements, int questRank, Boolean masterRank, String successConditions, Date startTimestamp, Date endTimestamp, Mapa location) {
        this.id = id;
        this.name = name;
        this.platform = platform;
        this.exclusive = exclusive;
        this.type = type;
        this.expansion = expansion;
        this.description = description;
        this.requirements = requirements;
        this.questRank = questRank;
        this.masterRank = masterRank;
        this.successConditions = successConditions;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlatform() {
        return platform;
    }

    public String getExclusive() {
        return exclusive;
    }

    public String getType() {
        return type;
    }

    public String getExpansion() {
        return expansion;
    }

    public String getDescription() {
        return description;
    }

    public String getRequirements() {
        return requirements;
    }

    public int getQuestRank() {
        return questRank;
    }

    public Boolean getMasterRank() {
        return masterRank;
    }

    public String getSuccessConditions() {
        return successConditions;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public Mapa getLocation() {
        return location;
    }
}
