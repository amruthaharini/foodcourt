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
                new BeverageUI("Shanghai Noon","Small",  7, 2),
                new BeverageUI("Wine","Small",9,12),
                new BeverageUI("Lemonade","Large",10,12),
                new BeverageUI("Iced Tea","Medium", 7, 10),
                new BeverageUI("Hot Chocolate", "Medium", 9, 20),
                new BeverageUI("Juice", "Small", 5, 2),
                new BeverageUI("Beer", "Large", 7, 12)
        );
    }
}