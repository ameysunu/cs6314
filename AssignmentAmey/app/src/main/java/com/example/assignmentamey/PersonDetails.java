package com.example.assignmentamey;

import java.io.Serializable;

public class PersonDetails implements Serializable {
    private String image;
    private String location;
    private String name;
    private String url;

    public PersonDetails(String image, String location, String name, String url) {
        this.image = image;
        this.location = location;
        this.name = name;
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}


