package com.example.foodcourt.appetizers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Appetizer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String appTitle;
    private double appPrice;
    private double appRating;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Appetizer() {
    }

    public Appetizer(String appTitle, double appPrice, double appRating) {
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
