package com.flink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * start main class
 *
 * @Author: shengbin
 * @since: 2019/2/14 上午10:48
 */
@SpringBootApplication
public class ElasticSearchSinkMain {

    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchSinkMain.class, args);
    }
}
