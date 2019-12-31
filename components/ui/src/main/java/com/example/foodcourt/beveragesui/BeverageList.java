package com.example.foodcourt.beveragesui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BeverageList {

    public List<BeverageUI> asList() {
        return Arrays.asList(new BeverageUI("Coffee", "Small", 5, 4),
                new BeverageUI("Coffee", "Medium", 5, 5),
                new BeverageUI("Coffee", "Large", 5, 7),
                new BeverageUI("Tea", "Small", 3, 5),
                new BeverageUI("Tea", "Medium", 3, 6),
                new BeverageUI("Tea", "Small", 4, 7),
                new BeverageUI("Milk tea", "Small", 4, 5),
                new BeverageUI("Milk tea", "Medium", 5, 6),
                new BeverageUI("Milk tea", "Large", 5, 7),
                new BeverageUI("I-Spy", "Small", 5, 2),
                new BeverageUI("I-Spy", "Medium", 5, 3),
                new BeverageUI("I-Spy", "Large", 5, 5),
                new BeverageUI("The Royal Tenenbaums", "Small", 8, 4),
                new BeverageUI("The Royal Tenenbaums", "Medium", 8, 5),
                new BeverageUI("The Royal Tenenbaums", "Large", 7, 6),
                new BeverageUI("Zoolander", "Small",  6, 4),
                new BeverageUI("Zoolander", "Medium",  6, 5),
                new BeverageUI("Zoolander", "Large",  6, 6),
                new BeverageUI("Shanghai Noon","Small",  7, 2),
                new BeverageUI("Shanghai Noon","Medium",  7, 3),
                new BeverageUI("Shanghai Noon","Large",  7, 6),
                new BeverageUI("Iced Tea","Small", 7, 5),
                new BeverageUI("Iced Tea","Medium", 7, 6),
                new BeverageUI("Iced Tea","Large", 7, 7),
                new BeverageUI("Hot Chocolate", "Small", 9, 3),
                new BeverageUI("Hot Chocolate", "Medium", 9, 5)

        );
    }
}