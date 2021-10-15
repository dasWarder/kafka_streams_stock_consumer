package com.example.kafkaconsumerstockstreams.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@Document("stock")
@AllArgsConstructor
public class StockInfo {

  @Id private Long id;

  @BsonProperty("name")
  private String name;

  @BsonProperty("quantity")
  private Integer quantity;
}
