package com.example.kafkaconsumerstockstreams.service;

import com.example.kafkaconsumerstockstreams.model.StockInfo;
import com.example.kafkaconsumerstockstreams.repository.StockInfoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockInfoServiceImpl implements StockInfoService {

  private final ObjectMapper mapper;

  private final StockInfoRepository repository;

  @Override
  @KafkaListener(topics = "stock", groupId = "stock_group_1")
  public void consume(String info) throws JsonProcessingException {

    log.info("Receive data from producer and store it into the database");

    StockInfo stockInfo = mapper.readValue(info, StockInfo.class);
    repository.save(stockInfo);
  }

  @Override
  public Integer getQuantityByName(String name) {

    log.info("Receive count of sold products by the name = {}", name);

    return repository.findStocksInfoByName(name).stream()
        .map(i -> i.getQuantity())
        .reduce(0, (p, n) -> p + n);
  }
}
