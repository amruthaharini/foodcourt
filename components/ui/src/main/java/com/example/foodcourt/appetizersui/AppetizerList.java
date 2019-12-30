package com.example.foodcourt.appetizersui;

import com.example.foodcourt.appetizersui.AppetizerUI;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class AppetizerList {

    public List<AppetizerUI> asList() {
        return Arrays.asList(
                new AppetizerUI("Sausage Pinwheels", 12, 5),
                new AppetizerUI("Loaded Mashed Potato Bites", 10, 5),
                new AppetizerUI("Garlic Roast Beef Pinwheels", 9, 6),
                new AppetizerUI("Puff Pastry Sausage Rolls", 14, 10),
                new AppetizerUI("French Onion Dip", 12, 9),
                new AppetizerUI("Italian Sub Crescent Roll Ring", 13, 9),
                new AppetizerUI("Homemade Cheesy Chili Dip", 14, 10),
                new AppetizerUI("Melon Caprese Skewers with Herb Oil", 8, 4)
        );
    }
}