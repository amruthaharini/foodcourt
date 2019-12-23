package com.example.foodcourt;

import com.example.foodcourt.beveragesui.BeverageClient;
import com.example.foodcourt.beveragesui.BeverageList;
import com.example.foodcourt.appetizersui.AppetizerClient;
import com.example.foodcourt.appetizersui.AppetizerUI;
import com.example.foodcourt.beveragesui.BeverageUI;
import com.example.foodcourt.appetizersui.AppetizerList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RootController {
    private BeverageClient beveragesClient;
    private BeverageList beveragesList;
    private AppetizerClient appetizersClient;
    private AppetizerList appetizersList;


    public RootController(BeverageClient beveragesClient, AppetizerClient appetizersClient, AppetizerList appetizersList,BeverageList beveragesList) {
        this.beveragesClient = beveragesClient;
        this.appetizersClient = appetizersClient;
        this.appetizersList =appetizersList;
        this.beveragesList = beveragesList;
    }

    @GetMapping("/")
    public String rootPath() {
        return "index";
    }

    @GetMapping("/setup")
    public String setupDatabase(Map<String, Object> model) {

        beveragesList.asList().forEach(beveragesClient::create);
        model.put("beverages", beveragesClient.getAll());

        appetizersList.asList().forEach(appetizersClient::create);
        model.put("appetizers", appetizersClient.getAll());

        return "setup";
    }




}
