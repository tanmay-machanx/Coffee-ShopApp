package com.CoffeeApp.CoffeeApp.Controller;

import com.CoffeeApp.CoffeeApp.Entity.CoffeeAppEntity;
import com.CoffeeApp.CoffeeApp.Service.CoffeeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Coffee")
public class CoffeeController2 {

    private final Map<String, CoffeeAppEntity> coffeeAppObject = new HashMap<>();
    @Autowired
    private CoffeeOrderService coffeeOrderService;
    @GetMapping("/test")
    public String test() {
        return "API_Working";
    }

    @GetMapping
    public List<CoffeeAppEntity> fetchOrders() {
        return coffeeOrderService.GetAllEntry();
    }
    @PostMapping
    public boolean CreateEntry(@RequestBody CoffeeAppEntity RequestData) {
        return coffeeOrderService.saveEntry(RequestData);
    }
    @GetMapping("id/{id}")
    public Optional<CoffeeAppEntity> GetOrderById(@PathVariable String id) {
        return coffeeOrderService.GetEntryById(id);
    }
    @DeleteMapping("id/{id}")
    public Optional<CoffeeAppEntity> DeleteOrderById(@PathVariable String id) {
        return coffeeOrderService.RemoveEntry(id);
    }
    @PutMapping("id/{id}")
    public CoffeeAppEntity UpdateOrderById(@PathVariable String id, @RequestBody CoffeeAppEntity RequestData) {
        return coffeeOrderService.updateOrder(id,RequestData);
    }
}
