package com.example.kafkaconsumerstockstreams.controller;

import com.example.kafkaconsumerstockstreams.service.StockInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/consumer/stocks")
public class StockInfoController {

  private final StockInfoService service;

  @GetMapping
  public ResponseEntity<Integer> countByName(@RequestParam("name") String name) {

    Integer quantityByName = service.getQuantityByName(name);

    return ResponseEntity.ok(quantityByName);
  }
}
