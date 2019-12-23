package com.example.foodcourt.beverages;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beverages")
public class BeverageController {

    private com.example.foodcourt.beverages.BeveragesBean beveragesBean;

    public BeverageController(com.example.foodcourt.beverages.BeveragesBean beveragesBean) {
        this.beveragesBean = beveragesBean;
    }

    @PostMapping
    public ResponseEntity<com.example.foodcourt.beverages.Beverage> create(@RequestBody com.example.foodcourt.beverages.Beverage beverage) {

        beveragesBean.addBeverage(beverage);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Beverage> delete(@PathVariable Long id) {
        Beverage doomed = beveragesBean.find(id);
        if (doomed != null) beveragesBean.deleteBeverage(doomed);
        HttpStatus status = (doomed != null) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @GetMapping("/count")
    public int count(
            @RequestParam(value = "field", required = false) String field,
            @RequestParam(value = "key", required = false) String key
    )
    {
        return (field != null && key != null) ? beveragesBean.count(field, key) : beveragesBean.countAll();
    }

    @GetMapping()
    public List<Beverage> read(
            @RequestParam(value = "field", required = false) String field,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "start", required = false) Integer start,
            @RequestParam(value = "pageSize", required = false) Integer pageSize
    ){
        if (field != null && key != null && start != null && pageSize != null)
            return beveragesBean.findRange(field, key, start, pageSize);
        else if (start != null && pageSize != null)
            return beveragesBean.findAll(start, pageSize);
        else
            return beveragesBean.getBeverages();

    }

}