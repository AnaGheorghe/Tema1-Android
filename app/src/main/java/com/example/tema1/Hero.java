package com.example.tema1;

import java.io.Serializable;

public class Hero implements Serializable {
    private String name, alias, actor, abilities, plot, image, logo, url;

    public Hero(String name, String alias,String actor, String abilities, String plot, String image, String logo, String url)
    {
        this.name=name;
        this.alias=alias;
        this.actor=actor;
        this.abilities=abilities;
        this.plot=plot;
        this.image=image;
        this.logo=logo;
        this.url=url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
