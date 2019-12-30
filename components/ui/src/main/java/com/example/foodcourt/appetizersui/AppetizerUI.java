package com.example.foodcourt.appetizersui;

import java.util.Objects;

public class AppetizerUI {
    private Long id;
    private String appTitle;
    private double appPrice;
    private double appRating;

    public AppetizerUI() {
    }

    public AppetizerUI(String appTitle, double appPrice, double appRating) {
        this.appTitle = appTitle;
        this.appPrice = appPrice;
        this.appRating = appRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getappTitle() {
        return appTitle;
    }

    public void setappTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public double getappPrice() {
        return appPrice;
    }

    public void setappPrice(double appPrice) {
        this.appPrice = appPrice;
    }

    public double getappRating() {
        return appRating;
    }

    public void setappRating(double appRating) {
        this.appRating = appRating;
    }
}