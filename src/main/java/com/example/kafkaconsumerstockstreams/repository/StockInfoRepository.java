package com.example.kafkaconsumerstockstreams.repository;

import com.example.kafkaconsumerstockstreams.model.StockInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockInfoRepository extends MongoRepository<StockInfo, Long> {
}
