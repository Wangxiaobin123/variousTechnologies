package com.flink.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Author: shengbin
 * @since: 2019/2/14 下午3:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metrics {
    private String name;
    private Long timestamp;
    private Map<String, Object> fields;
    private Map<String, String> tags;
}
