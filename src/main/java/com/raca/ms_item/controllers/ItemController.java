package com.raca.ms_item.controllers;

import com.raca.ms_item.models.entity.Item;
import com.raca.ms_item.models.service.Impl.ItemFeignService;
import com.raca.ms_item.models.service.Impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemFeignService itemService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Item>> getAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") Long id) {
        System.out.println(itemService.findById(id, 2).toString());
        try{
            return new ResponseEntity(itemService.findById(id, 2),HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
