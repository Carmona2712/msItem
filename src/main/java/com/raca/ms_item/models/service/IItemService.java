package com.raca.ms_item.models.service;

import com.raca.ms_item.models.entity.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IItemService {

    public List<Item> findAll();

    public Item findById(Long id,Integer quantity);


}
