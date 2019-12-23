package com.example.foodcourt.beveragesui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BeverageList {

    public List<BeverageUI> asList() {
        return Arrays.asList(new BeverageUI("Coffee", "Small", 5, 4),
                new BeverageUI("Tea", "Small", 3, 5),
                new BeverageUI("Milk tea", "Small", 4, 5),
                new BeverageUI("I-Spy", "Medium", 5, 2),
                new BeverageUI("The Royal Tenenbaums", "Medium", 8, 1),
                new BeverageUI("Zoolander", "Large",  6, 4),
                new BeverageUI("Shanghai Noon","Small",  7, 2)

        );
    }
}