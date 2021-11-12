package com.raca.ms_item.clients;

import com.raca.ms_item.models.entity.Product;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-products")
@Primary
public interface IClientProductRest {

   /* @GetMapping("/getAll")
    public List<Product> findAll();

    @GetMapping("/get/{id}")
    public Product findById(@PathVariable("id") Long id); */

    @GetMapping("/api/product/getAll")
    public ResponseEntity<List<Product>> findAll();

    @GetMapping("/api/product/get/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id);

}
