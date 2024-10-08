package com.CoffeeApp.CoffeeApp.Controller;

import com.CoffeeApp.CoffeeApp.Entity.CoffeeAppEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/_Coffee")
public class CoffeeController {

    private final Map<String, CoffeeAppEntity> coffeeAppObject = new HashMap<>();

    @GetMapping("/test")
    public String test() {
        return "API_Working";
    }

    @GetMapping
    public List<CoffeeAppEntity> fetchOrders() {
        return new ArrayList<>(coffeeAppObject.values());
    }
    @PostMapping
    public boolean CreateEntry(@RequestBody CoffeeAppEntity RequestData) {
        coffeeAppObject.put(RequestData.getId(),RequestData);
        return true;
    }
    @GetMapping("id/{id}")
    public ResponseEntity<CoffeeAppEntity> GetOrderById(@PathVariable String id) {
        CoffeeAppEntity order = coffeeAppObject.get(id);

        if (order != null) {
            return ResponseEntity.ok(order); // Return 200 OK if found
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 Not Found if not found
        }
    }
    @DeleteMapping("id/{id}")
    public ResponseEntity<CoffeeAppEntity> DeleteOrderById(@PathVariable String id) {
        CoffeeAppEntity order = coffeeAppObject.get(id);
        if (order != null) {
            coffeeAppObject.remove(id);
            return ResponseEntity.ok(order); // Return 200 OK if found
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 Not Found if not found
        }
    }
    @PutMapping("id/{id}")
    public ResponseEntity<CoffeeAppEntity> UpdateOrderById(@PathVariable String id, @RequestBody CoffeeAppEntity RequestData) {
        CoffeeAppEntity order = coffeeAppObject.get(id);

        if (order != null) {
            coffeeAppObject.put(id,RequestData);
            order=coffeeAppObject.get(id);
            return ResponseEntity.ok(order); // Return 200 OK if found
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 Not Found if not found
        }
    }
}
