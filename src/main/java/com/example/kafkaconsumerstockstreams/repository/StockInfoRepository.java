package com.example.kafkaconsumerstockstreams.repository;

import com.example.kafkaconsumerstockstreams.model.StockInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StockInfoRepository extends MongoRepository<StockInfo, Long> {

  List<StockInfo> findStocksInfoByName(String name);
}
