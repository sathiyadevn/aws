package com.dev.ec2ConnDynamoDbApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.s3.S3Client;

@RestController
public class HelloController {

    private final S3Client s3Client;

    public HelloController(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @GetMapping
    public String greet() {
        return "Hello world :)";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello world! Checking S3 Connection, Buckets: " +
                s3Client.listBuckets()
                        .buckets()
                        .stream()
                        .map(bucket -> bucket.name())
                        .toList();
    }

}
