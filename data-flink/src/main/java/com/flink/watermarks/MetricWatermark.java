package com.flink.watermarks;

import com.flink.model.Metrics;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;

import javax.annotation.Nullable;

/**
 * @Author: shengbin
 * @since: 2019/2/14 下午3:52
 */

public class MetricWatermark implements AssignerWithPeriodicWatermarks<Metrics> {

    private static final long serialVersionUID = -3930514000703261758L;
    private long currentTimestamp = Long.MIN_VALUE;

    @Nullable
    @Override
    public Watermark getCurrentWatermark() {
        return new Watermark(currentTimestamp == Long.MIN_VALUE ? Long.MIN_VALUE : currentTimestamp - 1);
    }

    @Override
    public long extractTimestamp(Metrics metrics, long l) {
        long timestamp = metrics.getTimestamp() / (1000 * 1000);
        this.currentTimestamp = timestamp;
        return timestamp;
    }
}
