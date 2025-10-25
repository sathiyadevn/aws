package com.dev.ec2ConnDynamoDbApp.entity;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

// @Entity   -> SQL
@DynamoDbBean   // -> NoSQL
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder    //
public class Product {

    private String id;
    private String name;
    private double price;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}