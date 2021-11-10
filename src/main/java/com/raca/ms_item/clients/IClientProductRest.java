package com.raca.ms_item.clients;

import com.raca.ms_item.models.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-products",url = "localhost:8001")
public interface IClientProductRest {

    @GetMapping("/api/product/all")
    public List<Product> findAll();

    @GetMapping("/api/product/get/{id}")
    public Product findById(@PathVariable("id") Long id);

}
