package com.raca.ms_item.models.service.Impl;

import com.raca.ms_item.clients.IClientProductRest;
import com.raca.ms_item.models.entity.Item;
import com.raca.ms_item.models.entity.Product;
import com.raca.ms_item.models.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("feign-client-product")
public class ItemFeignService implements IItemService {

    @Autowired
    private IClientProductRest clientProductRest;
    //@Autowired
    //private ItemService itemService;

    @Override
    public ResponseEntity<List<Item>> findAll() {
        return new ResponseEntity((clientProductRest.findAll().getBody()).stream().map(p ->{
          return  new Item(p,2);
        }).collect(Collectors.toList()),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Item> findById(Long id, Integer quantity) {
        Product product = clientProductRest.findById(id).getBody();
        System.out.println(product.toString());
        return new ResponseEntity(new Item(product,quantity),HttpStatus.OK);
    }
}
