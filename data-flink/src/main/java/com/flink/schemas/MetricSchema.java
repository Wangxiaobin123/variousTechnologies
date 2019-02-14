package com.flink.schemas;

/**
 * @Author: shengbin
 * @since: 2019/2/14 下午4:04
 */

import com.flink.model.Metrics;
import com.google.gson.Gson;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;

import java.nio.charset.Charset;

/**
 * Metric Schema ，支持序列化和反序列化
 */
public class MetricSchema implements DeserializationSchema<Metrics>, SerializationSchema<Metrics> {

    private static final Gson gson = new Gson();
    private static final long serialVersionUID = -2301600356001037554L;

    @Override
    public Metrics deserialize(byte[] bytes) {
        return gson.fromJson(new String(bytes), Metrics.class);
    }

    @Override
    public boolean isEndOfStream(Metrics metricEvent) {
        return false;
    }

    @Override
    public byte[] serialize(Metrics metricEvent) {
        return gson.toJson(metricEvent).getBytes(Charset.forName("UTF-8"));
    }

    @Override
    public TypeInformation<Metrics> getProducedType() {
        return TypeInformation.of(Metrics.class);
    }
}
