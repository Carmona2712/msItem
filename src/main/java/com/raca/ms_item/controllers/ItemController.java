package com.raca.ms_item.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.raca.ms_item.models.entity.Item;
import com.raca.ms_item.models.entity.Product;
import com.raca.ms_item.models.service.Impl.ItemFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemFeignService itemService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Item>> getAll() {
        return new ResponseEntity(itemService.findAll().getBody(),HttpStatus.OK);
    }


    @HystrixCommand(fallbackMethod = "findById")
    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") Long id) {
        System.out.println(itemService.findById(id, 2).toString());
        try{
            return new ResponseEntity(itemService.findById(id, 2),HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Item> findById(Long id) {
       Item item = new Item();
       Product product = new Product();
       product.setId(id);
       product.setName("TV SAMSUMG 65");
       product.setCost(Double.parseDouble("2368000"));
       item.setProduct(product);
       item.setQuantity(4);
        try{
            return new ResponseEntity(item,HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
