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

@Service
@Primary
public class ItemFeignService implements IItemService {

    @Autowired
    private IClientProductRest clientProductRest;
    //@Autowired
    //private ItemService itemService;

    @Override
    public List<Item> findAll() {
        return ((List<Product>) clientProductRest.findAll()).stream().map(p ->{
          return  new Item(p,2);
        }).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Product product = (Product) clientProductRest.findById(id);
        System.out.println(product.toString());
        return new Item(product,quantity);
    }
}
