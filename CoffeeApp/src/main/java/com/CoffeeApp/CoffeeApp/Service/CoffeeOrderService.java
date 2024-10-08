package com.CoffeeApp.CoffeeApp.Service;

import com.CoffeeApp.CoffeeApp.Entity.CoffeeAppEntity;
import com.CoffeeApp.CoffeeApp.Repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CoffeeOrderService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<CoffeeAppEntity> GetAllEntry() {
        return coffeeRepository.findAll();
    }
    public Optional<CoffeeAppEntity> GetEntryById(String id) {
        return coffeeRepository.findById(id);
    }
    public boolean saveEntry(CoffeeAppEntity requestData) {
        coffeeRepository.save(requestData);
        return true;
    }
    public Optional<CoffeeAppEntity> RemoveEntry(String id) {
        if(coffeeRepository.existsById(id)){
            Optional<CoffeeAppEntity> Item=coffeeRepository.findById(id);
            coffeeRepository.deleteById(id);
            return Item;
        }
        return Optional.empty();
    }
    public CoffeeAppEntity updateOrder(String id, CoffeeAppEntity updatedData) {
        Optional<CoffeeAppEntity> orderOptional = coffeeRepository.findById(id);

        if (orderOptional.isPresent()) {
            CoffeeAppEntity existingOrder = orderOptional.get();
            existingOrder.setTitle(updatedData.getTitle());
            existingOrder.setDescription(updatedData.getDescription());
            existingOrder.setPriority(updatedData.getPriority());
            existingOrder.setAmount(updatedData.getAmount());

            return coffeeRepository.save(existingOrder);
        } else {
            throw new RuntimeException("Order not found with id: " + id);
        }
    }
}
