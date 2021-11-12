package com.raca.ms_item.models.service.Impl;

import com.raca.ms_item.models.entity.Item;
import com.raca.ms_item.models.entity.Product;
import com.raca.ms_item.models.service.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Primary
public class ItemService implements IItemService {

    private static final Logger log = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    private RestTemplate clientRest;

    @Override
    public ResponseEntity<List<Item>> findAll() {
        log.info("------ Client REST -----------------------");
        List<Product>  products = Arrays.asList(clientRest.getForObject("http://ms_item/api/product/getAll",Product[].class));
        return new ResponseEntity(products.stream().map(p -> new Item(p,1)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Item> findById(Long id, Integer quantity) {
        log.info("------ Client REST -----------------------");
        List<Product>  products = Arrays.asList(clientRest.getForObject("http://ms_item/api/product/getAll",Product[].class));
        return new ResponseEntity(products.stream().map(p -> new Item(p,1)).collect(Collectors.toList()),HttpStatus.OK);
    }

    /*@Override
    public List<Item> findAll() {
        List<Product>  products = Arrays.asList(clientRest.getForObject("http://localhost:8001/api/product/getAll",Product[].class));
       return products.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String,String> parameters = new HashMap<>();
        parameters.put("id",id.toString());
        Product product = clientRest.getForObject("http://localhost:8001/api/product/get/{id}",Product.class,parameters);
        return new Item(product,quantity);
    }*/


}
