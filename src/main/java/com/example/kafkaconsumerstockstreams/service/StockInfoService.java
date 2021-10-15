package com.example.kafkaconsumerstockstreams.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface StockInfoService {

    void consume(String info) throws JsonProcessingException;
}
